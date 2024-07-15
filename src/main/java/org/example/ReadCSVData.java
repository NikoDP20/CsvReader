package org.example;

import java.io.FileReader;
import com.opencsv.*;
import java.util.List;
import java.util.Scanner;

public class ReadCSVData {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your CSV file path: ");
        String csvFile = scanner.next();

        System.out.println("___________________ Start of Data ___________________");
        readData(csvFile);
        System.out.println("____________________ End of Data ____________________");
        
    }

    public static void readData(String file)
    {
        try {
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(fileReader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
