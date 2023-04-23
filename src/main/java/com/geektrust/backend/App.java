package com.geektrust.backend;

import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.config.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String fileName = args[0];
        run(fileName);
    }

    static void run(String fileName) {
        Configuration configuration = Configuration.getInstance();
        CommandInvoker commandInvoker = configuration.getCommandInvoker();

        try {
            FileInputStream fis = new FileInputStream(fileName);
            Scanner sc = new Scanner(fis);
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                commandInvoker.invokeCommand(line);
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
