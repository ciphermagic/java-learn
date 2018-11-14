package com.cipher.test;

import java.io.*;

public class Test {

    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\cipher\\Desktop\\语言包\\配置文件";
        File dir = new File(path);
        File[] list = dir.listFiles();
        StringBuilder sb = new StringBuilder();
        String s;
        for (File file : list) {
            sb.append(">>>>>>>>>>>>>>>>>>>>> ").append(file.getName()).append("\n");
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            while ((s = bReader.readLine()) != null) {
                sb.append(s).append("\n");
            }
            bReader.close();
        }

        File file = new File("F:\\sum.xml");
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        ps.println(sb.toString());
    }

}
