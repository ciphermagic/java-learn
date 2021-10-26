package com.cipher.data_structure.F_Set_and_Map.set;

import com.cipher.data_structure.F_Set_and_Map.FileOperation;

import java.util.ArrayList;

import static java.lang.System.nanoTime;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 10:55 2018/10/31
 */
public class Main {

    private static final String PATH = "src/main/java/com/cipher/data_structure/F_Set_And_Map/resource/";
    private static final String A_TALE_OF_TWO_CITIES = PATH + "a-tale-of-two-cities.txt";
    private static final String PRIDE_AND_PREJUDICE = PATH + "pride-and-prejudice.txt";

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile(PRIDE_AND_PREJUDICE, words);
        System.out.println("Total words: " + words.size());

        testSet(new BSTSet<>(), words);
        testSet(new LinkedListSet<>(), words);
    }

    private static void testSet(Set<String> set, ArrayList<String> words) {
        long start = nanoTime();
        for (String w : words) {
            set.add(w);
        }
        long end = nanoTime();
        System.out.println("Total different words: " + set.getSize() + " during " + (end - start)/1000000000.0);
    }

}
