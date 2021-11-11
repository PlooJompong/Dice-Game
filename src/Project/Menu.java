package Project;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    //Scanner
    Scanner scanner = new Scanner(System.in);
    
    //ArraysList
    ArrayList<String> players = new ArrayList<String>();

    //Menu
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

    //Start the game
    public void start() {
        System.out.println("\n Let's Play");
    }

    //Add player to ArrayList
    public void addPlayer() {
        System.out.println("\n ===== ADD PLAYER ===== \n");
        System.out.println("How many players?");
        int playerAmount = scanner.nextInt();

        for (int i = 0; i < playerAmount; i++) {
            String player = MessageFormat.format("Enter player {0} name", i + 1);
            System.out.println(player);
            String playerName = scanner.next();
            players.add(playerName);
        }
    }

    //Check player amount § name
    public void checkPlayer() {
        System.out.println("\n ===== PLAYER'S NAME ===== \n");

        if (players.size() == 0) {
            System.out.println("Players are missing");
        } else {
            for (int i = 0; i < players.size(); i++) {
                String names = MessageFormat.format("Player {0} is: " + players.get(i), i + 1);
                System.out.println(names);
            }
        }
    }

    //Remove all players
    public void clearPlayer() {
        System.out.println("\n ===== CLEAR PLAYER ===== \n");

        if (players.size() == 0) {
            System.out.println("The list is empty");
        } else {
            System.out.println("Player's name har been deleted");
            players.clear();
        }
    }

    //End the game
    public void end() {
        System.out.println("\nEnded");
    }
}