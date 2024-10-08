package Zadanie6.Part1;

import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FileManager fileHandler = null;

        while (true) {
            System.out.println("What would you like to do: ");

            switch (input.nextLine().toLowerCase()) {
                case "open", "o" -> {
                    System.out.println("Choose file to open: ");
                    fileHandler = FileManager.openAndGetFile(input.nextLine());
                }
                case "create", "c" -> {
                    System.out.println("What should the file be named: ");
                    fileHandler = FileManager.createAndGetFile(input.nextLine());
                }
                case "write", "w" -> {
                    if (fileHandler != null) {
                        System.out.println("What would you like to write: ");
                        fileHandler.write(input.nextLine());
                    } else {
                        System.out.println("No file is open!");
                    }
                }
                case "writeall", "wa" -> {
                    if (fileHandler != null) {
                        System.out.println("What would you like to write: ");
                        fileHandler.writeAll(input.nextLine().split(","));
                    } else {
                        System.out.println("No file is open!");
                    }
                }
                case "read", "r" -> {
                    if (fileHandler != null) {
                        System.out.println("What line you want to read: ");
                        System.out.println(fileHandler.read(Integer.parseInt(input.nextLine())));
                    } else {
                        System.out.println("No file is open!");
                    }
                }
                case "readall", "ra" -> {
                    if (fileHandler != null) {
                        for (String line : fileHandler.readAll()) {
                            System.out.println(line);
                        }
                    } else {
                        System.out.println("No file is open!");
                    }
                }
                case "end", "e" -> {
                    return;
                }
                default -> System.out.println("Unknown command!");
            }
        }
    }
}