package ch02.item09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    // try-finally
    static String firstLineOfFileV1(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    // try-with-resources
    static String firstLineOfFileV2(String path, String defaultVal) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) { // catch절과 함께 사용할 수 있음.
            return defaultVal;
        }
    }
}
