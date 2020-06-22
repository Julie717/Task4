package com.buyalskaya.array.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DataReader {
    public String readArrayFromFile(String filePath) {
        String data;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            data = bufferedReader.lines().collect(Collectors.joining(" "));
        } catch (IOException e) {
            throw new RuntimeException("Error in opening file " + filePath, e);
        }
        return data;
    }

    public String readArrayFromConsole() {
        System.out.println("Enter numbers in line separated by space:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String[] readMatrixFromFile(String filePath) {
        String[] matrix;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            List<String> data = bufferedReader.lines()
                    .collect(Collectors.toList());
            matrix = new String[data.size()];
            data.toArray(matrix);
        } catch (IOException e) {
            throw new RuntimeException("Error in opening file " + filePath, e);
        }
        return matrix;
    }
}