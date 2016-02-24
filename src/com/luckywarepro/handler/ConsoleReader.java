package com.luckywarepro.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Itzhak
 */
public class ConsoleReader implements DataReader {

    public static ArrayList<String> inputData = new ArrayList<String>();

    @Override
    public void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String string = reader.readLine();
                if (string.equals("")) break;
                inputData.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n*****\nInput data:\n");
        for (String string : inputData) {
            System.out.println("" + string);
        }
        System.out.println("\n*****\n");
    }
}
