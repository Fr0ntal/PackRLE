package com.xyi;

import java.io.*;

public class PackRLE {

    public static void main(String[] args) throws IOException {
        PackRLE.main(args);
    }

    static String encode(String string) {

        StringBuilder result = new StringBuilder();

        int c = 1;

        for (int i = 0; i < string.length() - 1; i++) {
            char current = string.charAt(i);
            char next = string.charAt(i + 1);
            if (current != next) {
                if (c != 1) result.append(c);
                result.append(current);
                c = 1;
            } else c++;
        }
        if (string.length() - 1 >= 0) {
            if (c != 1) result.append(c);
            result.append(string.charAt(string.length() - 1));
        }

        return result.toString();
    }

    static String decode(String str) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i< str.length(); i++) {
            Character currentChar = str.charAt(i);
            if (Character.isDigit(currentChar)) continue;
            String str2 = str.substring(0, i);
            StringBuilder multiplyNumber = new StringBuilder();
            for (int j = str2.length() - 1; j > -1; j--) {
                if (Character.isDigit(str2.charAt(j))) {
                    multiplyNumber.append(str2.charAt(j));
                } else break;
            }
            if (multiplyNumber.isEmpty()) multiplyNumber = new StringBuilder("1");
            multiplyNumber.reverse();
            result.append(String.valueOf(currentChar).repeat(Math.max(0, Integer.parseInt(multiplyNumber.toString()))));
        }
        return result.toString();
    }

    public static void packRLE(boolean pack, String inputFile, String outputFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        String st = "";
        while ((st = br.readLine()) != null) {
            if (pack) bw.write(decode(st));
            else bw.write(encode(st));
        }
        bw.close();
        if (pack) {
            System.out.println("Pack-rle: pack");
        } else {
            System.out.println("Pack-rle: unpack + successful");
        }
    }
}
