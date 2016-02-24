package com.luckywarepro.handler;

import com.luckywarepro.model.Brick;
import com.luckywarepro.model.Wall;
import java.util.ArrayList;

/**
 * @author Itzhak
 */

public class WallBuilder {

    private int[][] inputWall = Wall.wallMatrix;
    private int[][] currentWall = new int[Wall.wallHeight][Wall.wallWidth];
    private ArrayList<String[]> inputBrickList = Brick.brickList;
    private ArrayList<String[]> sortedBrickList = Brick.brickListSortedByHeight;
    private ArrayList<String[]> usefulBrickList = new ArrayList<String[]>();

    private void filterBricks(){
        int brickHeight;
        for (String[] brick : sortedBrickList){
            brickHeight = Brick.getBricksHeight(brick);
            if (brickHeight<=Wall.wallHeight){
                usefulBrickList.add(brick);
            }
        }
        usefulBrickList.trimToSize();
    }

    private void fillWallWithZero(){
        for(int row=0; row<Wall.wallHeight; row++){
            for (int column=0; column<Wall.wallWidth; column++ ){
                currentWall[row][column] = 0;
            }
        }
    }

    private void putBrickInTheWall(ArrayList<String[]> brickList){

        for(String[] brick : brickList){

            int brickHeight = Brick.getBricksHeight(brick);
            int brickWidth = Brick.getBricksWidth(brick);
            int brickCount = Brick.getBricksCount(brick);

            int[][] currentBrick = Brick.convertBrickListToArray(brick);

            while (brickCount > 0) {
                for (int row = 0; row <= Wall.wallHeight; row++) {
                    for (int column = 0; column <= Wall.wallWidth; column++) {
                        if (currentBrick[row][column] == 1 && currentWall[row][column] == 0) {
                            currentWall[row][column] = 1;
                        }
                    }
                }
                brickCount--;
            }
        }

        for(int row=0; row<=Wall.wallHeight;row++){
            for(int column=0; column<=Wall.wallWidth;column++){

            }
        }
    }

    public void buildWall(){
        fillWallWithZero();
        filterBricks();
        putBrickInTheWall(usefulBrickList);
    }

}
