package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Board board1 = new Board();
        Carrier carrier1 = new Carrier();
        Battleship battleship1 = new Battleship();
        Cruiser cruiser1 = new Cruiser();
        Submarine submarine1 = new Submarine();
        Destroyer destroyer1 = new Destroyer();
        board1.addShip(carrier1);
        board1.addShip(battleship1);
        board1.addShip(cruiser1);
        board1.addShip(submarine1);
        board1.addShip(destroyer1);

        Board board2 = new Board();
        Carrier carrier2 = new Carrier();
        Battleship battleship2 = new Battleship();
        Cruiser cruiser2 = new Cruiser();
        Submarine submarine2 = new Submarine();
        Destroyer destroyer2 = new Destroyer();
        board2.addShip(carrier2);
        board2.addShip(battleship2);
        board2.addShip(cruiser2);
        board2.addShip(submarine2);
        board2.addShip(destroyer2);

        System.out.println("Player 1, please place your ships.");

            System.out.println("You have " + board1.shipsToPlace.toString() + " left to place.");
            System.out.println("Which ship do you wish to place first? ");
            String shipToPlace = sc.next();
            shipToPlace = shipToPlace.toUpperCase();
            boolean validAnswer = shipToPlace.equals("CARRIER") || shipToPlace.equals("BATTLESHIP") || shipToPlace.equals("CRUISER") || shipToPlace.equals("SUBMARINE") || shipToPlace.equals("DESTROYER");
            while(!validAnswer){
                System.out.println("Please enter any of " + board1.shipsToPlace.toString());
                shipToPlace = sc.next();
                shipToPlace = shipToPlace.toUpperCase();
                validAnswer = shipToPlace.equals("CARRIER") || shipToPlace.equals("BATTLESHIP") || shipToPlace.equals("CRUISER") || shipToPlace.equals("SUBMARINE") || shipToPlace.equals("DESTROYER");
            }

            for (int i = 0; i < board1.length(); i++){
                for (int j = 0; j < board1.length(); j++){
                    System.out.print(board1.grid()[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.println("Do you want to place this ship [v]ertically or [h]orizontally? ");
            String orientation = sc.next();
            orientation = orientation.toUpperCase();
            validAnswer = orientation.equals("V") || orientation.equals("H");
            while(!validAnswer){
                System.out.println("Please select either v or h. ");
                orientation = sc.next();
                orientation = orientation.toUpperCase();
                validAnswer = orientation.equals("V") || orientation.equals("H");
            }
            if (orientation.equals("V")){
                System.out.println("Please enter the top most y coordinate for this ship. ");
                int y = sc.nextInt();
                while (y < 1 || y > (10 - shipToPlace.length())){
                    System.out.println("Please enter a valid y coordinate for your " + shipToPlace.toString());
                    y = sc.nextInt();
                }
                System.out.println("Please enter the x coordinate for this ship. ");
                int x = sc.nextInt();
                while(x < 1 || x > 10){
                    System.out.println("Please enter a valid x coordinate for your " + shipToPlace.toString());
                    x = sc.nextInt();
                }
            }







    }
}
