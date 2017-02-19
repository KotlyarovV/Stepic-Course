package SreamsInOut;
import java.io.*;
import java.nio.charset.Charset;

/**
По историческим причинам на разных платформах принят разный способ обозначения конца строки в текстовом файле.
 На Unix-системах конец строки обозначается символом с кодом 10 ('\n'), на Windows — двумя последовательными
 символами с кодами 13 и 10 ('\r' '\n').
 */

public class Main {
    public static void main (String [] args) throws IOException {
        byte[] arr = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13, 10};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        System.setIn(inputStream);
        byte a1;
        byte a2;
        boolean last = false;
        a1 = (byte)System.in.read();
        if (a1 >= 0) {
            while ((a2 = (byte) System.in.read()) >= 0) {
                if (a1 == 13 && a2 == 10) {
                    System.out.write(a2);
                    int a = (byte) System.in.read();
                    if (a < 0) {
                        last = true;
                        break;
                    } else {
                        a1 = (byte) a;
                        last = false;
                    }
                } else {
                    System.out.write(a1);
                    a1 = a2;
                    last = false;
                }
            }
            if (!last) {
                System.out.write(a1);
            }
        }
        System.out.flush();
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int summ = 0;
        int read;
        while ((read = inputStream.read())  >= 0)
            summ = Integer.rotateLeft(summ,1) ^ read;
        return summ;
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        int b;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset );
        String string = "";
        while ((b = inputStreamReader.read())  >= 0)
            string = string + Character.toString((char)b);
        return string;
    }
}
