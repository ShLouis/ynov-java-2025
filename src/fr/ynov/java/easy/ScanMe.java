package fr.ynov.java.easy;

import java.util.Scanner;

public class ScanMe {
    public static void main(String[] args) {
        System.out.println("Enter your name and age");
        Scanner info = new Scanner(System.in);  // Create a Scanner object
        System.out.println(info.nextLine());
    }
}
