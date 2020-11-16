package utilities;

/*
File: InputUtility.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A utility for input, uses Singleton Design Pattern
*/

/*
Imported Libraries
*/
import java.util.Scanner;

public class InputUtility 
{
    private static InputUtility singleInstance;
    private Scanner scan;

    private InputUtility()
    {
        scan = new Scanner(System.in);
    }

    public static InputUtility getSingleInstance()
    {
        if (singleInstance == null)
        {
            singleInstance = new InputUtility();
        }
        return singleInstance;
    }

    public String inputString()
    {
        String input = scan.nextLine();

        return input;
    }

    public String inputString(String[] options)
    {
        boolean active = true;
        String input = "";

        while(active)
        {
            input = scan.nextLine();
            for (String option : options)
            {
                if (option.equalsIgnoreCase(input))
                {
                    active = false;
                    return input;
                }
            }
            System.out.println("Please input a valid choice.");
        }

        return input;
    }

    public int inputInt(int min, int max)
    {
        boolean active = true;
        int input = 0;
        while (active)
        {
            try
            {
                input = scan.nextInt();
                if (input >= min && input <= max)
                {
                    active = false;
                    break;
                }
            }
            catch (Exception e)
            {
                scan.nextLine();
            }
            System.out.println("Please input a valid number.");
        }
        scan.nextLine();

        return input;
    }

    public double inputDouble(double min, double max)
    {
        boolean active = true;
        double input = 0;
        while (active)
        {
            try
            {
                input = scan.nextDouble();
                if (input >= min && input <= max)
                {
                    active = false;
                    break;
                }
            }
            catch (Exception e)
            {
                scan.nextLine();
            }
            System.out.println("Please input a valid number.");
        }
        scan.nextLine();

        return input;
    }

    public String yesNo()
    {
        boolean active = true;
        String input = "";
        while (active)
        {
            input = scan.nextLine();
            if (input.equalsIgnoreCase("YES") || input.equalsIgnoreCase("NO"))
            {
                active = false;
                break;
            }
            System.out.println("Please input yes or no.");
        }

        return input;
    }

    public void pressEnter()
    {
        scan.nextLine();
    }
}
