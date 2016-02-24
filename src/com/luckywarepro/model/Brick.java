package com.luckywarepro.model;

import com.luckywarepro.handler.DataHandler;

import java.util.ArrayList;

/**
 * @author Itzhak
 */

public class Brick {

    public static final int generalBricksCount = DataHandler.generalBricksCount;
    public static final ArrayList<String[]> brickList = DataHandler.brickList;

    public static int getBricksWidth(String[] brick){
        int bricksWidth = Integer.parseInt(brick[0]);
        return bricksWidth;
    }

    public static int getBricksLength(String[] brick){
        int getBricksLength = Integer.parseInt(brick[1]);
        return getBricksLength;
    }

    public static int getBricksCount(String[] brick){
        int bricksCount = Integer.parseInt(brick[2]);
        return bricksCount;
    }

}


