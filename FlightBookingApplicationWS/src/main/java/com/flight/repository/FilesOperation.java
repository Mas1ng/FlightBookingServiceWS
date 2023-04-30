package com.flight.repository;

import com.flight.model.FBS;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class FilesOperation {
    static String FBS_FILE ="fbs.dat";

    public static FBS loadFBS() {
        FBS fbs = new FBS();
        Path file = Paths.get(FBS_FILE);
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file.toString()));
            fbs = (FBS)o.readObject();
            o.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return fbs;
    }
    public static void storeFBS(FBS fbs) {
        Path file = Paths.get(FBS_FILE);
        try{
            ObjectOutputStream o = new ObjectOutputStream(Files.newOutputStream(file, CREATE));
            o.writeObject(fbs);
            o.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
