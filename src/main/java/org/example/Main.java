package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(args));
        Scanner scanner = new Scanner(System.in);

        String a;
        while (!(a = scanner.nextLine()).equals("q")){
            System.out.println(a);
        }
    }
}