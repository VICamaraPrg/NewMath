package test.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    public static ArrayList<String> readStrings(String pathToRead) {
        ArrayList<String> lines = new ArrayList<>();
        try {

            File inFile = new File(pathToRead);
            Scanner reader = new Scanner(inFile);

            while (reader.hasNextLine())
                lines.add(reader.next());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

    public static ArrayList<Integer> readIntegers(String pathToRead) {
        ArrayList<Integer> lines = new ArrayList<>();
        try {

            File inFile = new File(pathToRead);
            Scanner reader = new Scanner(inFile);

            while (reader.hasNextLine()) {
                int lineInt = Integer.parseInt(reader.next());
                lines.add(lineInt);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }
    public static ArrayList<Long> readLongs(String pathToRead) {
        ArrayList<Long> lines = new ArrayList<>();
        try {

            File inFile = new File(pathToRead);
            Scanner reader = new Scanner(inFile);

            while (reader.hasNextLine()) {
                long lineLong = Long.parseLong(reader.next());
                lines.add(lineLong);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }
}
