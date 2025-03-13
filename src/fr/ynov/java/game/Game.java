package fr.ynov.java.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private Items randomItem;
    private int highestScore;

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    private void chooseRandomItem(){
        randomItem=Items.values()[new Random().nextInt(Items.values().length)];
    }

    public Items askPlayerChoice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Pick an item: ");
        System.out.println("1:ROCK ");
        System.out.println("2:PAPER ");
        System.out.println("3:SCISSORS ");

        try {
            int choice = sc.nextInt();
            return switch (choice) {
                case 1 -> Items.ROCK;
                case 2 -> Items.PAPER;
                case 3 -> Items.SCISSORS;
                default -> null;
            };
        } catch (Exception e){
            return null;
        }
    }

    private void compare(){
        if (randomItem.equals(this.player.getCurrentItem())) {
            System.out.println("It's a Draw!");
        }
        else {
            if (randomItem == Items.ROCK) {
                if (this.player.getCurrentItem() == Items.SCISSORS) {
                    System.out.println("You Lose!");
                    this.player.resetScore();
                }
                else {
                    System.out.println("You Win!");
                    this.player.updateScore();
                }
            } else if (randomItem == Items.PAPER) {
                if (this.player.getCurrentItem() == Items.ROCK) {
                    System.out.println("You Lose!");
                    this.player.resetScore();
                }
                else {
                    System.out.println("You Win!");
                    this.player.updateScore();
                }

            } else{
                if (this.player.getCurrentItem() == Items.PAPER) {
                    System.out.println("You Lose!");
                    this.player.resetScore();
                }
                else {
                    System.out.println("You Win!");
                    this.player.updateScore();
                }

            }
        }
    }
    public void playRound(){
        System.out.println("Score:"+this.player.getScore());
        this.player.setCurrentItem(askPlayerChoice());
        chooseRandomItem();
        if(randomItem!=null) {
            if(this.player.getCurrentItem()==null){
                System.out.println("That's not an option");
                playRound();
            }else{
                System.out.println("You chose "+this.player.getCurrentItem());
                System.out.println("The computer chose "+this.randomItem);
                compare();
                if(this.player.getScore()>this.highestScore){
                    this.highestScore=this.player.getScore();
                    writeNewHighScore(this.highestScore);
                    System.out.println("Congratulations, you beat the highest score!");
                }
            }
        }
    }

    private boolean askPlayAgain(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to play again? (y/n) ");
        String choice = sc.nextLine();
        return switch (choice) {
            case "y", "Y" -> true;
            case "n", "N" -> false;
            default -> askPlayAgain();
        };
    }

    public int getHighestScore() {
        int highestScore;
        String fileName="C:\\Users\\louis\\Desktop\\Ynov\\java\\ynov-java-2025\\src\\fr\\ynov\\java\\game\\score.txt";
        try {
            File openedFile = new File(fileName);
            Scanner reader = new Scanner(openedFile);
                highestScore = reader.nextInt();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            highestScore=0;
        }
        return highestScore;
    }
    public boolean createHighestScoreFile(){
        String filePath="C:\\Users\\louis\\Desktop\\Ynov\\java\\ynov-java-2025\\src\\fr\\ynov\\java\\game\\score.txt";
        try {
            File newFile = new File(filePath);
            return newFile.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred with the high-score file.");
            e.printStackTrace();
        }
        return false;
    }

    public static void writeNewHighScore(int score) {
        String filepath="C:\\Users\\louis\\Desktop\\Ynov\\java\\ynov-java-2025\\src\\fr\\ynov\\java\\game\\score.txt";
        try {
            FileWriter writer = new FileWriter(filepath);
            writer.write(String.valueOf(score));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame() {
        try {
            this.highestScore = getHighestScore();
        }
        catch (Exception e){
            if(createHighestScoreFile()) {
                writeNewHighScore(0);
            }
        }
        System.out.println("Welcome to Rock-Paper-Scissors\nScore to beat:"+this.highestScore);
        this.player = new Player();
        this.player.askName();
        boolean playAgain;
        do {
            playRound();
            playAgain = askPlayAgain();
        } while (playAgain);
    }
}
