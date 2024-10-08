package Zadanie6.Part2;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class FileManager {
    private final File file;
    private FileWriter txtWriter;
    

    private FileManager(File file) throws IOException {
        this.file = file;
        this.txtWriter = new FileWriter(file, true);
    }

    public static FileManager openAndGetFile(String fileName) {
        File f = new File(fileName);

        try {
            return f.exists() ? new FileManager(f) : null;

        } catch (IOException e) {
            return null;
        }
    }

    public static FileManager createAndGetFile(String fileName) {
        File newFile = new File(fileName);

        try {
            return newFile.createNewFile() ? new FileManager(newFile) : null;

        } catch (IOException e) {
            return null;
        }
    }

    public boolean write(String text) {
        try {
            txtWriter.write(text);
            txtWriter.flush();

            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public boolean writeAll(String[] text) {
        try {
            for (String idk : text) {
                txtWriter.write(idk);
            }
            txtWriter.flush();

            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public String read(int t) {
        String targetLine = null;

        try {
            Scanner f = new Scanner(file);

            for (int i = 1; i <= t; i++) {
                targetLine = f.nextLine();
            }

            return targetLine;

        } catch (NoSuchElementException e) {
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public String[] readAll() {
        ArrayList<String> al = new ArrayList<String>();

        try {
            Scanner f = new Scanner(file);
            while (f.hasNextLine()) {
                al.add(f.nextLine());
            }

            return al.toArray(new String[0]);

        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
