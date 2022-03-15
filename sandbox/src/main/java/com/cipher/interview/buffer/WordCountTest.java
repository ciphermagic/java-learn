package com.cipher.interview.buffer;

import org.junit.Test;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cipher
 */
public class WordCountTest {

    private static final ExecutorService POOL = Executors.newFixedThreadPool(16);
    private static final AtomicInteger count = new AtomicInteger();


    private static HashMap<String, Integer> countByString(String str) {
        HashMap<String, Integer> map = new HashMap<>(str.length());
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            incKey(word, map, 1);
        }
        return map;
    }

    private static void incKey(String key, HashMap<String, Integer> map, Integer n) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + n);
        } else {
            map.put(key, n);
        }
    }

    static class CountTask implements Callable<HashMap<String, Integer>> {
        private final long start;
        private final long end;
        private final String fileName;

        public CountTask(String fileName, long start, long end) {
            this.start = start;
            this.end = end;
            this.fileName = fileName;

        }

        @Override
        public HashMap<String, Integer> call() throws Exception {
            FileChannel channel = new RandomAccessFile(this.fileName, "rw").getChannel();
            // [start, end] -> Memory
            // Device -> Kernel Space -> UserSpace(buffer) -> Thread
            MappedByteBuffer mbuf = channel.map(FileChannel.MapMode.READ_ONLY, this.start, this.end - this.start);
            String str = StandardCharsets.US_ASCII.decode(mbuf).toString();
            return countByString(str);
        }
    }

    public void run(String fileName, long chunkSize) throws ExecutionException, InterruptedException {
        File file = new File(fileName);
        long fileSize = file.length();

        long position = 0;

        long startTime = System.currentTimeMillis();
        ArrayList<Future<HashMap<String, Integer>>> tasks = new ArrayList<>();
        while (position < fileSize) {
            long next = Math.min(position + chunkSize, fileSize);
            CountTask task = new CountTask(fileName, position, next);
            position = next;
            Future<HashMap<String, Integer>> future = POOL.submit(task);
            tasks.add(future);
        }
        System.out.format("split to %d tasks\n", tasks.size());

        HashMap<String, Integer> totalMap = new HashMap<>(16);
        for (Future<HashMap<String, Integer>> future : tasks) {
            HashMap<String, Integer> map = future.get();
            System.out.println(count.getAndIncrement());
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                incKey(entry.getKey(), totalMap, entry.getValue());
            }
        }

        System.out.println("time:" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("total:" + totalMap.size());
        System.out.println(totalMap.get("ababb"));
    }

    @Test
    public void count() throws ExecutionException, InterruptedException {
        WordCountTest counter = new WordCountTest();
        System.out.println("processors:" + Runtime.getRuntime().availableProcessors());
        counter.run("word", 1024 * 1024 * 20);
    }

    @Test
    public void compareWithSingle() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("word"));
        byte[] buf = new byte[4 * 1024];
        int len;
        HashMap<String, Integer> total = new HashMap<>(16);
        long startTime = System.currentTimeMillis();
        while ((len = in.read(buf)) != -1) {
            byte[] bytes = Arrays.copyOfRange(buf, 0, len);
            String str = new String(bytes);
            HashMap<String, Integer> hashMap = countByString(str);
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                incKey(key, total, entry.getValue());
            }
        }
        System.out.println("time:" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println(total.get("ababb"));
        System.out.println(total.size());
    }

}
