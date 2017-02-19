package Scaner;
import java.lang.*;
import java.util.Scanner;

public class Main {
    public static  void main (String[] strings) throws  java.io.UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext())
        {
            if (scanner.hasNextDouble())
                sum = sum + scanner.nextDouble();
            else scanner.next();
        }
        System.out.printf("%.6f", sum);
        System.out.flush();
    }
}
