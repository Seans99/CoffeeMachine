import java.util.Scanner;

public class CleanMachine {

   public void cleanMachine() {

        //Object for other classes.
        Scanner scan = new Scanner(System.in);
        MainMenu menu = new MainMenu();
        CleanMachine clean = new CleanMachine();
        StartUp startup = new StartUp();

        double cleanWater = 0;
        int cleanCoffeePowder = 0;
        double cleanMilk = 0;
        int cleanCacao = 0;

        //Outputs choice to clean machine.
        System.out.println("---------------------------------------------");
        System.out.println("|    Would you like to clean the machine?   |");
        System.out.println("|                    Y or N                 |");
        System.out.println("---------------------------------------------");

        //User input
        String input = scan.next();

        //If answer is y it cleans the machine, otherwise returns to Main menu.
        if (input.equals("Y") || input.equals("y")) {

            System.out.println("Cleaning machine...");
            startup.setWaterAmount(cleanWater);
            startup.setMilkAmount(cleanMilk);
            startup.setCoffeeAmount(cleanCoffeePowder);
            startup.setCacaoAmount(cleanCacao);
            System.out.println("Machine cleaned!");
            System.out.println("Returning to menu...");
            menu.startMenu();
            } else if (input.equals("N") || input.equals("n")) {
            System.out.println("returning to menu...");
            menu.startMenu();
            } else {
            //Outputs Error if wrong Input.
            System.out.println(input + " not found!");
            clean.cleanMachine();

        }
    }
}
