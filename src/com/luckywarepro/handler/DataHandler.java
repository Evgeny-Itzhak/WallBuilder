package com.luckywarepro.handler;

import com.luckywarepro.exception.*;
import java.util.ArrayList;

/**
 * @author Itzhak
 */
public class DataHandler {

    public static int wallWidth;
    public static int wallHeight;
    public static int[][] wallMatrixArr;
    private ArrayList<String> wallMatrix;
    public static int generalBricksCount;
    private int stringsAmountInInputData;
    public static ArrayList<String[]> brickList;

    final ArrayList<String> inputData = ConsoleReader.inputData.size() > 0 ? ConsoleReader.inputData : FileReader.inputData;

    public void initData() throws WrongDataException {
        checkInputDataIsNotEmptyOrNull();
        initWallParams();
        initBrickParams();
        checkInputDataFormat();
    }

    private void checkInputDataIsNotEmptyOrNull() throws EmptyInputDataException {
        if (inputData == null || inputData.isEmpty()) {
            throw new EmptyInputDataException("The input data is null or empty!");
        }
    }

    private void checkInputDataFormat() throws WrongDataParamException {
        stringsAmountInInputData = 1 + wallHeight + 1 + generalBricksCount;
        if (inputData.size() != stringsAmountInInputData) {
            throw new WrongDataParamException("The input data has wrong format!");
        }
    }

    private void initWallParams() throws WrongWallParamException {
        checkWallParams();
        initWallMatrixInArrayList();
        checkWallMatrix();
        convertWallArrayListMatrixToArray();
    }

    private void initWallMatrixInArrayList() {
        wallWidth = Integer.parseInt(inputData.get(0).trim().substring(0, 1));
        wallHeight = Integer.parseInt(inputData.get(0).trim().substring(2));
        wallMatrix = new ArrayList<String>(inputData);
        wallMatrix.remove(0);
        int row = wallMatrix.size() - 1;
        while (row != wallHeight - 1) {
            wallMatrix.remove(row);
            row--;
        }
        wallMatrix.trimToSize();
    }

    private void checkWallParams() throws WrongWallParamException {
        boolean correctWallParams = inputData.get(0).length() == 3;
        if (!correctWallParams) {
            throw new WrongWallParamException("Wrong parameters of \"Wall\" in input data!");
        }
    }

    private void checkWallMatrix() throws WrongWallParamException {
        boolean correctWallMatrix = wallMatrix.size() == wallHeight;
        for (String currentRow : wallMatrix) {
            if (currentRow.length() != wallWidth) {
                correctWallMatrix = false;
                break;
            }
        }
        if (!correctWallMatrix) {
            throw new WrongWallParamException("Wrong parameters of \"Wall\" in input data!");
        }
    }

    private void convertWallArrayListMatrixToArray() {
        int wallMatrixRawCount = wallMatrix.size();
        int wallMatrixFieldsCount = wallMatrix.get(0).length();
        wallMatrixArr = new int[wallMatrixRawCount][wallMatrixFieldsCount];
        for (int rowNum = 0; rowNum < wallMatrixRawCount; rowNum++) {
            for (int columnNum = 0, endColumnNum = wallMatrixFieldsCount - 1; columnNum < wallMatrixFieldsCount; columnNum++, endColumnNum--) {
                String row = wallMatrix.get(rowNum);
                int beginIndex = columnNum;
                int endIndex = row.length() - endColumnNum;
                String currentRow = row.substring(beginIndex, endIndex);
                wallMatrixArr[rowNum][columnNum] = Integer.parseInt(currentRow);
            }
        }
    }

    private void isBrickParamsCorrect() throws WrongBrickParamException {
        boolean correctBricksCount = inputData.get(wallHeight + 1).trim().length() == 1;
        if (!correctBricksCount) {
            throw new WrongBrickParamException("Wrong parameters of \"Brick\" in input data!");
        }
    }

    private void initBrickList() {
        generalBricksCount = Integer.parseInt(inputData.get(wallHeight + 1).trim().substring(0, 1));
        brickList = new ArrayList<String[]>();
        for (int i = 0; i < generalBricksCount; i++) {
            String[] currentBrick = inputData.get(wallHeight + 2 + i).trim().split(" ");
            brickList.add(currentBrick);
            //System.out.println(Arrays.toString(brickList.get(i)));
        }
    }

    private void initBrickParams() throws WrongBrickParamException {
        isBrickParamsCorrect();
        initBrickList();
    }

}