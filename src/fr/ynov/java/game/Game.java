package fr.ynov.java.game;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private Items randomItem;
    private boolean playAgain;

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
        int choice = sc.nextInt();
        return switch (choice) {
            case 1 -> Items.ROCK;
            case 2 -> Items.PAPER;
            case 3 -> Items.SCISSORS;
            default -> null;
        };
    }

    private void compare(){
        if (randomItem.equals(this.player.getCurrentItem())) {
            System.out.println("It's a Draw!");
        }
        else {
            if (randomItem == Items.ROCK) {
                if (this.player.getCurrentItem() == Items.SCISSORS)
                    System.out.println("You Lose!");
                else {
                    System.out.println("You Win!");
                }
            } else if (randomItem == Items.PAPER) {
                if (this.player.getCurrentItem() == Items.ROCK)
                    System.out.println("You Lose!");
                else {
                    System.out.println("You Win!");
                }

            } else{
                if (this.player.getCurrentItem() == Items.PAPER)
                    System.out.println("You Lose!");
                else {
                    System.out.println("You Win!");
                }

            }
        }
    }
    public void playRound(){
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

    public void startGame() {
        this.player = new Player();
        this.playAgain = true;
        this.player.askName();
        boolean playAgain;
        do {
            playRound();
            playAgain = askPlayAgain();
        } while (playAgain);
    }
}
