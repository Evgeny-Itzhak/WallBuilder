package com.luckywarepro;

import com.luckywarepro.exception.WrongDataException;
import com.luckywarepro.handler.DataHandler;
import com.luckywarepro.handler.FileReader;

public class WallBuilderAnalyzer {

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        fileReader.openFile();
        fileReader.readData();
        fileReader.closeFile();

        DataHandler dataHandler = new DataHandler();

        try {
            dataHandler.initData();
        } catch (WrongDataException e) {
            e.printStackTrace();
        }

    }

}
