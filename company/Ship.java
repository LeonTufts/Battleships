package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Ship {

    /////////////////////////////Attributes//////////////////////

    private int length;




    ////////////////////////////Constructors/////////////////////

    public Ship(int length) {
        this.length = length;
    }




    //////////////////////////Methods////////////////////////////

    private int getLength(){
        return length;
    }


}
