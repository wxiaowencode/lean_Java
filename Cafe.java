import java.util.*;

public class Cafe {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);  //keyboard input
        int choice; // users menu choice
        String cupSize; // users cup selection
        int serving; // amount served to user

        CoffeePot columbian = new CoffeePot("Columbian Supremo", 32);
        CoffeePot konaroast = new CoffeePot("Kona Medium Roast", 42);
        CoffeePot houseblend = new CoffeePot("Special House Blend", 64);
        CoffeePot[] pots = {columbian,konaroast,houseblend};
        CoffeeBar bar = new CoffeeBar(pots);

        System.out.print("\nOpening Cafe ...\n");
        do{
            System.out.print ("\nPlease order a cup of coffee:\n");
            bar.getMenu();
            System.out.print("Which do you prefer? ");
            choice = keyboard.nextInt();
            if (choice > 0 && choice <=3) {
                System.out.print("What size, small("+bar.getSmallCup()+
                        " oz) or large ("+bar.getLargeCup()+" oz)?");
                keyboard.nextLine();
                cupSize = keyboard.nextLine();
                if (cupSize.compareTo("small") == 0)
                    serving = bar.serveSmallCup(choice);
                else
                    serving = bar.serveLargeCup(choice);
                if (serving == -1)
                    System.out.print("I'm sorry, but we are out of that selection.\n");
            }
        } while (choice != 0);
        System.out.print("\nThank you for coming!\n\n");
    }
}
