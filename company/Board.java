package com.company;

import java.util.LinkedList;

public class Board {

    /////////////////////////Attributes//////////////////////////////////

    private final int[][] board = new int[10][10];

    LinkedList<Ship> shipsToPlace;
    {
        shipsToPlace = new LinkedList<Ship>();
    }




    ////////////////////////Constructors/////////////////////////////////




    ///////////////////////Methods///////////////////////////////////////


    public void addShip(Ship s){
        shipsToPlace.add(s);
    }

    public int length(){
        return board.length;
    }

    public int[][] grid(){
        return board;
    }

    public void addShipVertical(int x, int y, Ship s){
        for(int i = 0; i < s.getLength(); i++) {
            board[y - 1 + i][x - 1] = 1;
        }
    }

    public int boatCheckerVertical(int x, int y, Ship s) {
        for (int i = 0; i < s.getLength(); i++) {
            if (board[y - 1 + i][x - 1] == 1) {
                System.out.println("Your boats cannot touch");
                break;
            } else {
                System.out.println("Good boat placement");
                return 1;
            }
        }
        return -1;
    }

    public int boatCheckerHorizontal(int x, int y, Ship s) {
        for (int i = 0; i < s.getLength(); i++) {
            if (board[y-1][x-1+i] == 1) {
                System.out.println("Your boats cannot touch");
                return 0;
            } else {
                System.out.println("Good boat placement");
                return 1;
            }
        }
        return -1;
    }


    public void addShipHorizontal(int x, int y, Ship s){
        for(int i = 0; i < s.getLength(); i++) {
            board[y-1][x-1+i] = 1;
        }
    }


    public void removeShip(Ship s){
        shipsToPlace.remove(s);
    }

    public void FireAway(int x, int y){
        board[y-1][x-1] = board[y-1][x-1] - 1;
    }

    public int isHit(int x, int y, Board boardx){
        if(board[y-1][x-1] == 1){
            boardx.grid()[y-1][x-1] = 1;
            return 1;
        }
        boardx.grid()[y-1][x-1] = -1;
        return 0;

    }






}
