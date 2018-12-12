package raffle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Raffle {

    //Public variables
    public static String name;
    public static int userNum;

    //Reads the user input
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        mainMenu();
    }

    public static void mainMenu() throws IOException {
        //User options
        System.out.println("Please make a selection");
        System.out.println("1: Purchase Raffle Ticket");
        System.out.println("2: Check a Raffle Ticket");

        //Reads user response
        int menuSelection = Integer.parseInt(input.readLine());

        //Chooses which method to use based on which option was picked
        switch (menuSelection) {
            case (1):
                purchaseTicket();
            case (2):
                checkTicket();
            default:
                System.out.println("Not a valid choice");
                break;
        }

    }

    public static void purchaseTicket() throws IOException {

        //Stores name
        System.out.println("Enter Name:");
        name = input.readLine();
        
        //Stores chosen number
        System.out.println("Enter Number:");
        userNum = Integer.parseInt(input.readLine());
        
        //Displays message and goes back to main menu
        System.out.println("Purchasing Ticket");
        System.out.println("");
        mainMenu();
    }

    public static void checkTicket() throws IOException {
        
        //Stores ticket number
        System.out.println("What is your ticket number?");
        userNum = Integer.parseInt(input.readLine());
        System.out.println("Checking Ticket");
        
        // This algorithm basically checks every single possible number (between 2 and half the number) that could be divided and if there is 0 remainder, the number is not prime.
        // Loops from 2 to half of the users number as it is pointless looping more because a number can never be divided by more than half it's value. 
        for (int divisor = 2; divisor <= userNum / 2; divisor++) {
            // If a number has a remainder of 0, it is not prime
            if (userNum % divisor == 0) {
                System.out.println("You lost!");
                break;
            } else {
                //If the number is not divisable by any other number, with no remainder, it is a prime number
                System.out.println("You won!");
                break;
            }
        }
        
        //Goes back to main menu
        System.out.println("");
        mainMenu();
    }

}
