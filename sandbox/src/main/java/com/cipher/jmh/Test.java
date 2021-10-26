package com.cipher.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Warmup(iterations = 1)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Threads(1)
@State(Scope.Benchmark)
public class Test {

    private Map<Long, Long> hashMap;
    private Map<Long, Long> synchronizedMap;

    @Setup
    public void setUp() {
        this.hashMap = new HashMap<>();
        this.synchronizedMap = Collections.synchronizedMap(new HashMap<>());
    }

    @Benchmark
    public void testHashMap() {
        this.hashMap.put(System.nanoTime(), System.nanoTime());
    }

    @Benchmark
    public void testSynchronizedMap() {
        this.synchronizedMap.put(System.nanoTime(), System.nanoTime());
    }

    public static void main(String[] args) throws RunnerException {
        final Options opts = new OptionsBuilder().include(Test.class.getSimpleName()).build();
        new Runner(opts).run();
    }

}
