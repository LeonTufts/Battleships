package com.company;

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

        board1 = PlaceShips(board1);

        System.out.println("Player 2, please place your ships.");

        board2 = PlaceShips(board2);

        Board board3 = new Board();
        Board board4 = new Board();

        while(!isGameOver(board1) || !isGameOver(board2)){

            System.out.println("Player 1, take your shot. Enter your x and then y coordinates. ");

            int hitCounter1 = 0;
            int hitCounter2 = 0;

            int x = sc.nextInt();
            int y = sc.nextInt();

            board2.FireAway(x, y);
            if(board2.isHit(x, y, board3) == 1){
                System.out.println("HIT!! Great shot. ");
                hitCounter1 = hitCounter1 + 1;
            }

            System.out.println("Would you like to see your previous shots? ");
            String yesNo = yesNoVerifier();
            if(yesNo.equals("YES")){
                PrintBoard(board3);
            }

            System.out.println("Here are your current ships. ");
            PrintBoard(board1);

            System.out.println("Player 2, take your shot. Enter your x and then y coordinates. ");

            x = sc.nextInt();
            y = sc.nextInt();

            board1.FireAway(x, y);
            if(board1.isHit(x, y, board4) == 1){
                System.out.println("HIT!! Great shot. ");
                hitCounter2 = hitCounter2 + 1;
            }

            System.out.println("MISS!! Better luck next time. ");

            System.out.println("Would you like to see your previous shots? ");
            yesNo = yesNoVerifier();
            if(yesNo.equals("YES")){
                PrintBoard(board4);
            }

            System.out.println("Here are your current ships. ");
            PrintBoard(board2);

        }

    }

public static Board PlaceShips(Board board) {

    for (int i = 0; i <= 4; i++) {

        System.out.println("You have " + board.shipsToPlace.toString() + " left to place.");

        System.out.println("Which ship do you wish to place first? (enter place of ship in list) ");
        int shipToPlace = sc.nextInt();
        boolean validAnswer = shipToPlace == 1 || shipToPlace == 2 || shipToPlace == 3 || shipToPlace == 4 || shipToPlace == 5;
        while (!validAnswer) {
            System.out.println("Please enter any of " + board.shipsToPlace.toString());
            shipToPlace = sc.nextInt();
            validAnswer = shipToPlace == 1 || shipToPlace == 2 || shipToPlace == 3 || shipToPlace == 4 || shipToPlace == 5;
        }

        PrintBoard(board);

        System.out.println("Do you want to place your " + board.shipsToPlace.get(shipToPlace - 1) + " [v]ertically or [h]orizontally? ");
        String orientation = sc.next();
        orientation = orientation.toUpperCase();
        validAnswer = orientation.equals("V") || orientation.equals("H");
        while (!validAnswer) {
            System.out.println("Please select either v or h. ");
            orientation = sc.next();
            orientation = orientation.toUpperCase();
            validAnswer = orientation.equals("V") || orientation.equals("H");
        }

        if (orientation.equals("V")) {
            System.out.println("Please enter the top most y coordinate for this ship. ");
            int y = sc.nextInt();

            while (y < 1 || y > (10 - board.shipsToPlace.get(shipToPlace - 1).getLength())) {
                System.out.println("Please enter a valid y coordinate for your " + board.shipsToPlace.get(shipToPlace - 1));
                y = sc.nextInt();
            }

            System.out.println("Please enter the x coordinate for this ship. ");
            int x = sc.nextInt();

            while (x < 1 || x > 10) {
                System.out.println("Please enter a valid x coordinate for your " + board.shipsToPlace.get(shipToPlace - 1));
                x = sc.nextInt();
            }

            int boatChecker = board.boatCheckerVertical(x, y, board.shipsToPlace.get(shipToPlace - 1));

            while(boatChecker == 0){
                System.out.println("Please enter a different y coordinate. ");
                y = sc.nextInt();

                while (y < 1 || y > (10 - board.shipsToPlace.get(shipToPlace - 1).getLength())) {
                    System.out.println("Please enter a valid y coordinate for your " + board.shipsToPlace.get(shipToPlace - 1));
                    y = sc.nextInt();
                }

                System.out.println("Please enter a different x coordinate. ");
                x = sc.nextInt();

                while (x < 1 || x > 10) {
                    System.out.println("Please enter a valid x coordinate for your " + board.shipsToPlace.get(shipToPlace - 1));
                    x = sc.nextInt();
                }

                boatChecker = board.boatCheckerVertical(x, y, board.shipsToPlace.get(shipToPlace - 1));

            }

            board.addShipVertical(x, y, board.shipsToPlace.get(shipToPlace - 1));


        } else {
            System.out.println("Please enter the left most x coordinate for this ship. ");
            int x = sc.nextInt();

            while (x < 1 || x > (10 - board.shipsToPlace.get(shipToPlace - 1).getLength())) {
                System.out.println("Please enter a valid x coordinate for your " + board.shipsToPlace.get(shipToPlace - 1));
                x = sc.nextInt();
            }

            System.out.println("Please enter the y coordinate for this ship. ");
            int y = sc.nextInt();

            while (y < 1 || y > 10) {
                System.out.println("Please enter a valid y coordinate for your " + board.shipsToPlace.get(shipToPlace - 1));
                y = sc.nextInt();
            }

            int boatChecker = board.boatCheckerHorizontal(x, y, board.shipsToPlace.get(shipToPlace - 1));

            while(boatChecker == 0){

                System.out.println("Please enter a different x coordinate. ");
                x = sc.nextInt();

                while (x < 1 || x > (10 - board.shipsToPlace.get(shipToPlace - 1).getLength())) {
                    System.out.println("Please enter a valid x coordinate for your " + board.shipsToPlace.get(shipToPlace - 1));
                    y = sc.nextInt();
                }

                System.out.println("Please enter a different y coordinate. ");
                y = sc.nextInt();

                while (y < 1 || y > 10) {
                    System.out.println("Please enter a valid y coordinate for your " + board.shipsToPlace.get(shipToPlace - 1));
                    y = sc.nextInt();
                }

                boatChecker = board.boatCheckerVertical(x, y, board.shipsToPlace.get(shipToPlace - 1));

            }

            board.addShipHorizontal(x, y, board.shipsToPlace.get(shipToPlace - 1));

        }

        PrintBoard(board);

        board.removeShip(board.shipsToPlace.get(shipToPlace - 1));
    }

    return board;
    }

    public static void PrintBoard(Board board){

        for (int j = 0; j < board.length(); j++) {
            for (int k = 0; k < board.length(); k++) {
                System.out.print(board.grid()[j][k] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean isGameOver(Board board){
        int check = 1;
        for(int i = 0; i < board.length(); i++){
            for(int j = 0; j < board.length(); i++){
                if(board.grid()[i][j] < check){
                    return false;
                }
            }
        }
        return true;
    }

    public static String yesNoVerifier()
    {
        String yesNo = sc.next();

        yesNo = yesNo.toUpperCase();
        boolean validAnswer = yesNo.equals("YES") || yesNo.equals("NO");

        while (!validAnswer) {
            System.out.println("Please enter either Yes or No.");
            yesNo = sc.next();
            yesNo = yesNo.toUpperCase();
            validAnswer = yesNo.equals("YES") || yesNo.equals("NO");
        }

        return yesNo;
    }

}
