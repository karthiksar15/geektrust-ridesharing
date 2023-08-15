package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.example.geektrust.appconfig.ApplicationConfig;
import com.example.geektrust.commands.CommandInvoker;

public class Main {
      public static void main(String[] args) {
        
        //Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               run(sc.nextLine());
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }
        
    }

    public static void run(String line)
    {
        ApplicationConfig applicationConfig=new ApplicationConfig();
        CommandInvoker commandInvoker=applicationConfig.getCommandInvoker();
        try {
                List<String> tokens = Arrays.asList(line.split(" "));
                commandInvoker.executeCommand(tokens.get(0),tokens);
        } catch (UnsupportedOperationException  e) {
            e.printStackTrace();
        }
    }
}
