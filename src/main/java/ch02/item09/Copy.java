package ch02.item09;

import java.io.*;

public class Copy {

    private static final int BUFFER_SIZE = 8 * 1024;

    /**
     * try-finally 구문
     *  - 자원이 둘 이상이면 코드가 지저분해진다.
     *  - 예외가 여러 개 발생했을 경우 가장 나중에 발생한 예외만 기록에 남는다.
     */
    static void copyV1(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            FileOutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    /**
     * try-resource 구문
     *  - 읽기 수월
     *  - 예외 내역에 'suppressed'라는 꼬리표를 달고 출력
     */
    static void copyV2(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
