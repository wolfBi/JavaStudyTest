package com.study.object.io;

import java.io.*;

public class IOTest {
    public static final String FILE_PATH ="F:\\tmp\\fileServer\\io.txt";

    public static void main(String[] args) {
        try {
            study();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void study() throws Exception {
        InputStream input = new FileInputStream(new File(FILE_PATH));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String nameLine   = reader.readLine();
        int lineIndex = 1;
        while (nameLine != null){
            System.out.println("Line "+lineIndex +" : "+ nameLine);
            nameLine   = reader.readLine();
            lineIndex++;
        }

    }
}
