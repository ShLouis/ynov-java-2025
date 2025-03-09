package fr.ynov.java.medium;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args){
        String word;
        if (args.length<1){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a word: ");
            word=sc.nextLine();
        }
        else{
            word = args[0];
        }
        for (int i = 0; i < word.length()/2; i++) {
            if (word.charAt(i)!=word.charAt(word.length()-i-1)){
                System.out.println("The word '"+word+"' is not a palindrome.");
                return;
            }
        }
        System.out.println("The word "+word+" is a palindrome.");
    }
}
