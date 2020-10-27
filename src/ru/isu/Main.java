package ru.isu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Сергей 
 */

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            if (!args[0].endsWith(".txt")) throw new IllegalArgumentException();
            System.out.println(numberOfWordsInFile(new File(args[0])));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No argument specified!");
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong argument");
        }
    }

    /**
     * Метод, который считает количество слов в файле
     * @param file - принимаемый файл
     * @return Количество слов в файле
     */
    public static int numberOfWordsInFile(File file) {
        int number = 0;
        try(InputStream stream = new FileInputStream(file)) {
            int n = stream.available();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append((char) stream.read());
            }
            number = stringBuilder.toString().split("\\s+|\\W").length;
            System.out.println(Arrays.toString(stringBuilder.toString().split("\\s+|\\W")));

        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exists!");
        } catch (IOException e) {
            System.out.println("Wrong input");
        }
        return number;
    }

}
