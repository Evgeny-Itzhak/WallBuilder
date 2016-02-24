package com.luckywarepro.model;

import com.luckywarepro.handler.DataHandler;

import java.util.ArrayList;

/**
 * @author Itzhak
 */

public class Brick {

    public static final int generalBricksCount = DataHandler.generalBricksCount;
    public static final ArrayList<String[]> brickList = DataHandler.brickList;
    public static final ArrayList<String[]> brickListSortedByHeight = new ArrayList<String[]>();
    public static int[][] brickMatrix;

    public static int getBricksWidth(String[] brick) {
        int bricksWidth = Integer.parseInt(brick[0]);
        return bricksWidth;
    }

    public static int getBricksHeight(String[] brick) {
        int getBricksLength = Integer.parseInt(brick[1]);
        return getBricksLength;
    }

    public static int getBricksCount(String[] brick) {
        int bricksCount = Integer.parseInt(brick[2]);
        return bricksCount;
    }

    public static int[][] convertBrickListToArray(String[] brick){

        int brickHeight = Brick.getBricksHeight(brick);
        int brickWidth = Brick.getBricksWidth(brick);
        brickMatrix = new int[brickHeight][brickWidth];

        for(int row=0; row<brickHeight; row++){
            for (int column=0; column<brickWidth; column++){
                brickMatrix[row][column]=1;
            }
        }
        return brickMatrix;
    }

    public static int decreaseBricksCount(String[] brick) {
        return generalBricksCount - 1;
    }

    public static void sortBricksByHeight(ArrayList<String[]> brickList) {

        String[] brickWithMaxHeight = new String[2];

        for (String[] brick : brickList) {
            int brickHeight = getBricksHeight(brick);
            for (String[] currentBrick : brickList) {
                int currentBrickHeight = getBricksHeight(currentBrick);

                if (currentBrickHeight >= brickHeight) {
                    if (!brickListSortedByHeight.contains(currentBrick)) {
                        brickWithMaxHeight = currentBrick;
                    }
                } else if (brickListSortedByHeight.contains(brick) && !brickListSortedByHeight.contains(currentBrick)) {
                    brickWithMaxHeight = currentBrick;
                }
            }
            if (!brickListSortedByHeight.contains(brickWithMaxHeight)) {
                brickListSortedByHeight.add(brickWithMaxHeight);
            }
        }
    }
}




