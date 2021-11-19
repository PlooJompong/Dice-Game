package Project;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    
    // Scanner
    Scanner scanner = new Scanner(System.in);
    
    // ArraysLists
    // Custom class som bara kan ta emot players
    ArrayList<Player> playerList = new ArrayList<Player>();
    ArrayList<String> players = new ArrayList<String>();
    ArrayList<Integer> scores = new ArrayList<Integer>();
    ArrayList<String> winningPlayer = new ArrayList<String>();
    ArrayList<Integer> maxScore = new ArrayList<Integer>();
    
    // Instansiera 2 Dice
    Dice die = new Dice(6);
    Dice die2 = new Dice(6);

    // Menu
    public void menu() {
        System.out.println("\n ===== WELCOME TO THE GAME =====");
        int ch;
        do {

            System.out.println("\n===== MENU ===== \n");
            System.out.println("[1] Check Winner");
            System.out.println("[2] Add Player & Throw Dice");
            System.out.println("[3] Check Player");
            System.out.println("[4] Clear Player");
            System.out.println("[0] Exit \n");
            System.out.println("================");
            
            ch = scanner.nextInt();
            switch (ch) {
                case 1 -> checkWinner();
                case 2 -> addPlayer();  
                case 3 -> checkPlayer();
                case 4 -> clearPlayer();
                case 0 -> end();
                default -> System.out.println("Invalid input");
            }
        } while (ch != 0);
        scanner.close();
    }
    
    // Check winner
    private void checkWinner() {
        System.out.println("\n ===== CHECK WINNER ===== \n");
        // Om plyerList är tomt
        if (playerList.isEmpty()) {
            System.out.println("Please Add Player");
        } else {
            for (int i = 0; i < playerList.size(); i++) {
                Player tempPlayer = playerList.get(i);
                players.add(tempPlayer.getName());
                scores.add(tempPlayer.getScore());
                // Kommer alltid att köras minst en gång
                if (maxScore.isEmpty()) {
                    winningPlayer.add(tempPlayer.getName());
                    maxScore.add(tempPlayer.getScore());
                }
                // Kolla om maxpoängen är mindre än nästa spelarens poäng
                else if (maxScore.get(0) < tempPlayer.getScore()) {
                    winningPlayer.clear();
                    maxScore.clear();
                    winningPlayer.add(tempPlayer.getName());
                    maxScore.add(tempPlayer.getScore());
                }
                // Kolla om nästa spelarens poäng har samma som tidigare maxpoäng
                else if (maxScore.contains(tempPlayer.getScore())) {
                    winningPlayer.add(tempPlayer.getName());
                    maxScore.add(tempPlayer.getScore());
                } 
            }
            // Printa ut vinnare/vinnarna
            for (int i = 0; i < winningPlayer.size(); i++) {
                System.out.println("The winner is: " + winningPlayer.get(i) + " with a score of " + maxScore.get(i));
            }
        }
    }

    // Add player & score to ArrayList & roll dice
    private void addPlayer() {
        System.out.println("\n ===== ADD PLAYER ===== \n");
        System.out.println("How many players?\n");
        int playerAmount = scanner.nextInt();
        System.out.println("======================");
        for (int i = 0; i < playerAmount; i++) {
            String player = MessageFormat.format("Enter player {0} name", i + 1);
            System.out.println(player);
            String playerName = scanner.next();
            int tempDie = die.throwDie(); 
            int tempDie2 = die2.throwDie();
            System.out.println("\n======================");
            System.out.println(playerName);
            System.out.println("Dice #1: " + tempDie); 
            System.out.println("Dice #2: " + tempDie2); 
            System.out.println("======================");
            int totalScore = tempDie + tempDie2;
            playerList.add(new Player(playerName, totalScore));
        }
    }

    // Check players amount & name
    private void checkPlayer() {
        System.out.println("\n ===== PLAYER'S NAME ===== \n");
        if (playerList.isEmpty()) {
            System.out.println("Players are missing");
        } else {
            for (int i = 0; i < playerList.size(); i++) {
                String names = MessageFormat.format("Player {0} is: " + playerList.get(i).getName(), i + 1);
                System.out.println(names);
            }
        }
    }
    
    // Remove all players && scores
    private void clearPlayer() {
        System.out.println("\n ===== CLEAR PLAYER ===== \n");
        if (playerList.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            System.out.println("Player's name has been deleted");
            playerList.clear();
            players.clear();
            scores.clear();
            winningPlayer.clear();
            maxScore.clear();
        }
    }
    
    // End the game
    private void end() {
        System.out.println("\nEnd");
    }
}