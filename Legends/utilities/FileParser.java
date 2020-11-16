package utilities;

/*
File: FileParser.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A utility to read information files, uses Singleton design pattern
*/

/*
Imported Libraries
*/
import java.io.*;
import java.util.ArrayList;

public class FileParser
{
    private static FileParser singleInstance;

    private FileParser(){}

    public static FileParser getSingleInstance()
    {
        if (singleInstance == null)
        {
            singleInstance = new FileParser();
        }
        return singleInstance;
    }

    public ArrayList<String[]> parse(String filename)
    {
        BufferedReader reader;
        String filePath = new File("").getAbsolutePath();
        File file = new File(filePath + filename);
        ArrayList<String[]> fileStrings = new ArrayList<String[]>(); 
        try
        {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null)
            {
                String[] temp = line.split(" ");
                fileStrings.add(temp);
                line = reader.readLine();
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        return fileStrings;
    }
}
