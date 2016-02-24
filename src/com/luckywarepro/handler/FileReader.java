package com.luckywarepro.handler;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Itzhak
 */

public class FileReader implements DataReader {

    private final String path = "src//inputdata//inputData.txt";
    private Scanner scanner;
    private File file;

    public static ArrayList<String> inputData = new ArrayList<String>();

    public void openFile(){
        try{
            file = new File(path);
            scanner = new Scanner(file);

        } catch (FileNotFoundException e) {
            System.out.println("There is no file in 'inputdata' directory!\n\nPlease, input data from console!");
            //e.printStackTrace();
        }
    }

    public void closeFile(){
       if(scanner!=null){
           scanner.close();
       }
    }

    @Override
    public void readData() {
        if(scanner!=null){
            while (scanner.hasNext()){
                inputData.add(scanner.nextLine());
            }
        }
    }

}
