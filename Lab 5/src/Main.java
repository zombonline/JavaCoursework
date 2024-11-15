
//For this exercise, you will create a program that allows the user to edit a database from the console. The database will store a person's first name, last name and age. The user should be allowed to add, remove and list database entries. Create a custom class to represent the database entries and an appropriate container type to store the entries. Here is an example session showing how the program should behave:
//
//    > Please enter a command: help
//
//    Valid commands are:
//      a   Add record
//      r   Remove record
//      l   List records
//      q   Quit

import javax.imageio.plugins.tiff.ExifParentTIFFTagSet;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Entry> data = new ArrayList<Entry>();
    public static void main(String[] args) {
        displayOptions();
        boolean running = true;
        while(running)
        {
            switch (getInput("Please enter a command:"))
            {
                case "a":
                    addEntry();
                    break;
                case "r":
                    System.out.println("Remove");
                    break;
                case "l":
                    listEntries();
                    break;
                case "q":
                    running = false;
                    break;
                default:
                    displayOptions();
                    break;
            }
        }
    }
    public static void displayOptions()
    {
        System.out.println("a - Add record");
        System.out.println("r - Remove record");
        System.out.println("l - List records");
        System.out.println("q - Quit");
    }
    public static String getInput(String m)
    {
        System.out.println(m);
        return scanner.nextLine().toLowerCase();
    }
    public static void addEntry()
    {
        String input = getInput("Please enter data in the following format 'firstname lastname age':");
        String[] parts = input.split(" ");
        Entry newEntry = new Entry(parts[0], parts[1], Integer.parseInt(parts[2]));
        data.add(newEntry);
    }
    public static void listEntries()
    {
        for(int i = 0; i < data.size(); i++)
        {
            Entry entry = data.get(i);
            String entryString = entry.getLastName() + ", " + entry.getFirstName() + " " + entry.getAge();
            System.out.println(entryString);
        }
    }

}