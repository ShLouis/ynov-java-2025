package fr.ynov.java.game;

import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private Items currentItem;

    Player(){
        this.score = 0;
        this.currentItem=null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public void setCurrentItem(Items currentItem) {
        this.currentItem = currentItem;
    }
    public Items getCurrentItem() {
        return currentItem;
    }

    public void askName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Username: ");
        name = sc.nextLine();
        setName(name);
    }

    public void updateScore(){
        this.score++;
    }

    public void resetScore(){
        this.score = 0;
    }
}
