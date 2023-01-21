import java.io.*;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countTest = scanner.nextInt();
        scanner.nextLine();
        StringBuilder results = new StringBuilder();
        for (int j = 0; j < countTest; ++j) {
            String arr = scanner.nextLine();
            String s0 = null;
            String s1 = null;
            String s2 = null;
            String s3 = null;
            int i = 0;
            int sum = 0;
            int k = 0;
            int newsum = 0;
            for (String parts : arr.split(",")) {
                if (i == 0) {
                    s0 = parts;
                }
                if (i == 1) {
                    s1 = parts;
                }
                if (i == 2) {
                    s2 = parts;
                }
                if ((i > 2) && (i < 5)) {
                    k = Integer.parseInt(parts);
                    while (k != 0) {
                        newsum += (k % 10);
                        k /= 10;
                    }
                    sum = sum + newsum;
                    newsum = 0;
                }
                i++;
            }
            s3 = s0 + s1 + s2;
            String result = new StringBuilder(s3).reverse().toString();
            result = result.replaceAll("(.)(?=.*\\1)", "");
            result = new StringBuilder(result).reverse().toString();
            int ascii = (int) result.charAt(0);
            int code = 0;
            code = (result.length()) + (sum * 64) + ((ascii - 64) * 256);
            String convert = Integer.toHexString(code).toUpperCase();
            if (convert.length() > 2) convert = convert.substring(convert.length() - 3);

            results.append(convert).append(" ");
        }
        System.out.println(results);
    }
}