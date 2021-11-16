package Project;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    
    // Scanner
    Scanner scanner = new Scanner(System.in);
    
    // ArraysLists
    ArrayList<String> players = new ArrayList<String>();
    ArrayList<Integer> scores = new ArrayList<Integer>();
    ArrayList<Integer> winners = new ArrayList<Integer>();
    
    FirstDice firstDice = new FirstDice();
    SecondDice secondDice = new SecondDice();

    // Menu
    public void menu() {
        System.out.println("\n ===== WELCOME TO THE GAME =====");
        int ch;
        do {
            System.out.println("\n[1] Start");
            System.out.println("[2] Add Player");
            System.out.println("[3] Check Player");
            System.out.println("[4] Clear Player");
            System.out.println("[0] Exit \n");
            
            ch = scanner.nextInt();
            switch (ch) {
                case 1 -> start();
                case 2 -> addPlayer();
                case 3 -> checkPlayer();
                case 4 -> clearPlayer();
                case 0 -> end();
                default -> System.out.println("Invalid input");
            }
            
        } while (ch != 0);
        scanner.close();
    }
    
    // Start the game
    private void start() {
        System.out.println("\n ===== LET'S PLAY ===== \n");
        if (players.isEmpty()) {
            System.out.println("Please Add Player");
        } else {
            Integer high = Collections.max(scores);
            System.out.println(players);
            System.out.println(scores);
            
            for (int i = 0; i < scores.size(); i++) {
                if (scores.get(i) == high) {
                    winners.add(i);
                }
            }

            for (int i = 0; i < winners.size(); i++) {
                if (winners.size() > 1) {
                    System.out.println(winners.get(i) + " are equal with the score of: " + high);
                } else {
                    System.out.println(winners.get(i) + " won with the score of " + high);
                }
            }
        }
    }

    // Add player to ArrayList
    private void addPlayer() {
        System.out.println("\n ===== ADD PLAYER ===== \n");
        System.out.println("How many players?\n");
        int playerAmount = scanner.nextInt();

        for (int i = 0; i < playerAmount; i++) {
            String player = MessageFormat.format("Enter player {0} name", i + 1);
            System.out.println(player);
            String playerName = scanner.next();
            players.add(playerName);
            int totalScore = firstDice.throwDice() + secondDice.throwDice();
            scores.add(totalScore);
        }
    }

    // Check players amount & name
    private void checkPlayer() {
        System.out.println("\n ===== PLAYER'S NAME ===== \n");
        
        if (players.isEmpty()) {
            System.out.println("Players are missing");
        } else {
            for (int i = 0; i < players.size(); i++) {
                String names = MessageFormat.format("Player {0} is: " + players.get(i), i + 1);
                System.out.println(names);
            }
        }
    }
    
    // Remove all players && scores
    private void clearPlayer() {
        System.out.println("\n ===== CLEAR PLAYER ===== \n");
        if (players.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            System.out.println("Player's name has been deleted");
            players.clear();
            scores.clear();
            winners.clear();
        }
    }
    
    // End the game
    private void end() {
        System.out.println("\nEnded");
    }
}