//Import the Scanner class
import java.util.Scanner;
public class CandyStore {
    public static void main(String[] args) {
        //Create a scanner for the main method
        Scanner input = new Scanner(System.in);
        //Welcome message
        System.out.println("\nWelcome to the Candy Store! \n");
        //Create String variable for choice of candy (or quit)
        String choice = "";
        //Create Double variable 'totalCost' for the overall cost of the purchase
        Double totalCost = 0.0;
        //Continue asking the user for a choice of candy until they enter 'quit'
        while (!"quit".equals(choice)) {
            choice = candyChoices();
            if (!choice.equals("quit")) {
                //Prompt the user for the quantity of candy they would like to purchase
                System.out.print("Enter the quantity you wish to purchase: ");
                double qty = input.nextDouble(); 
                System.out.println("");
                //Call the candyChoices method
                double cost = calculateCost(choice, qty);
                //Add the cost of the candy just purchased to the total cost
                totalCost += cost;
                //Convert choice selection letter to name of candy
                if (choice.equals("a")) {
                    choice = "Reese's Pieces";
                }
                else if (choice.equals("b")) {
                    choice = "Skittles";
                }
                else if (choice.equals("c")) {
                    choice = "Jubjubes";
                }
                else if (choice.equals("e")) {
                    choice = "Smarties";
                }
                //If the candy choice is lollipops, print a whole number quantity without kg
                if (choice.equals("d")) {
                    System.out.printf("Total cost of %.0f Lollipops is $%.2f\n\n", qty, cost);
                }
                //Print quantity rounded to one decimal place and kg
                else {
                    System.out.printf("Total cost of %.1f kg of %s is $%.2f\n\n", qty, choice, cost);
                }
            }
        }
        //Print the receipt
        System.out.println("--------------------------------------------------\n\nThank you for visiting! Here is your receipt: \n");
        //Print the total cost before tax
        System.out.printf("Your total cost BEFORE TAX: $%.2f\n", totalCost);
        //Print the total cost after 13% tax
        System.out.printf("Your total cost AFTER TAX: $%.2f\n", totalCost*1.13);


    } //End main method


    public static String candyChoices() {
        //Create a scanner for the candyChoices method
        Scanner choiceInput = new Scanner(System.in);
        //Set the choiceExists boolean so that the loop begins
        boolean choiceExists = false;
        //Create String variable 'choice' (required before loop due to return)
        String choice = "";
        //Loop until the user enters a candy choice that exists
        while (choiceExists == false) {
            //Print out choices and their prices
            System.out.println("--------------------------------------------------\n\nPlease choose from the following options, or type 'quit' to exit: \n");
            System.out.println("a) Reese's Pieces: $2.50/0.5 kg\nb) Skittles: $1.75/1 kg\nc) Jujubes: $0.50/1kg\nd) Lollipops: 1 for $0.50 or 5 for $2.00\ne) Smarties: $1.50/1 kg\n");
            //Prompt for candy choice
            System.out.print("Select a candy to purchase: ");
            choice = choiceInput.nextLine();
            // Convert candy choice to lowercase (ie. 'A' to 'a')
            choice = choice.toLowerCase();
            System.out.println("");
            //If the candy choice exists, proceed to prompt for a quantity
            if ((choice.equals("a")) || (choice.equals("b")) || (choice.equals("c")) || (choice.equals("d")) || (choice.equals("e"))) {
                //Set choiceExists so the loop does not repeat
                choiceExists = true;
            }
            //If the user entered 'quit', the loop will nolt repeat or proceed to prompt for a quantity
            else if (choice.equals("quit")) {
                //Set choiceExists so the loop does not repeat
                choiceExists = true;
            }
            //If the candy choice does not exist, repeat the loop
            else {
                System.out.println("Sorry, that is not an option! Please try again. \n");
            }
        }
        //Return the user's choice of candy
        return choice;
    
    
    } //End candyChoices method


    public static double calculateCost(String choice, double qty) {
        //Create the Double variable 'cost' and set it's value to 0
        double cost = 0;
        //Multiply the quantity by the price, different depending on the user's choice of candy
        if (choice.equals("a")) {
            cost = qty/0.5*2.5;
        }
        else if (choice.equals("b")) {
            cost = qty*1.75;
        }
        else if (choice.equals("c")) {
            cost = qty*0.5;
        }
        else if (choice.equals("d")) {
            cost = (((qty-qty%5)/5)*2) + ((qty%5)*0.5);
        }
        else if (choice.equals("e")) {
            cost = qty*1.5;
        }
        return cost;
    } //End calculateCost method


} //End class
