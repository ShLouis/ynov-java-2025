package fr.ynov.java.easy;

import java.security.PublicKey;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
    float num1=Float.parseFloat(args[0]);
    float num2=Float.parseFloat(args[1]);
    Calculate(num1,num2);


    }

    public static void Calculate(float num1 ,float num2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an operator: (+, -, /, *)");
        float sum = switch (sc.next()) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "/" -> num1 / num2;
            case "*" -> num1 * num2;
            default -> 0;
        };
        System.out.println(sum);
    }
}
