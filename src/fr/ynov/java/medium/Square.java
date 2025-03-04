package fr.ynov.java.medium;

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        if (args.length == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number: ");
            System.out.print(square(sc.nextInt()));
        }
        else{
            System.out.print(square(Integer.parseInt(args[0])));
        }

    }
    public static int square(int n) {
        return n * n;
    }
}
