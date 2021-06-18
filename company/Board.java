package com.company;

import java.util.ArrayList;
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





}
