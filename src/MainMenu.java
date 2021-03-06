import java.util.Scanner;

public class MainMenu {

    //Scanner for user input.
    Scanner scan = new Scanner(System.in);

    public void startMenu() {

        //Objects for the other classes.
        CleanMachine clean = new CleanMachine();
        MakeCoffee make = new MakeCoffee();
        StartUp startup = new StartUp();

        //Outputs Main menu.
        System.out.println("-----------------------------");
        System.out.println("|     Coffee Machine Menu   |");
        System.out.println("-----------------------------");
        System.out.println("|     1. Status ingredients |");
        System.out.println("-----------------------------");
        System.out.println("|     2. Fill Ingredient    |");
        System.out.println("-----------------------------");
        System.out.println("|     3. Clean Machine      |");
        System.out.println("-----------------------------");
        System.out.println("|     4. Make Coffee        |");
        System.out.println("-----------------------------");
        System.out.println("|     5. Amount Coffee made |");
        System.out.println("-----------------------------");
        System.out.println("|     6. Exit               |");
        System.out.println("-----------------------------");

        boolean run = true;
        while (run) {
            try {
                //User input.
                int input = scan.nextInt();

                switch (input) {

                    //Shows status of ingredients in machine.
                    case 1:
                        System.out.println("Current Status:");
                        System.out.println("Available water(Liters): " + startup.getWaterAmount());
                        System.out.println("Available Coffee(Grams): " + startup.getCoffeeAmount());
                        System.out.println("Available milk(Liters): " + startup.getMilkAmount());
                        System.out.println("Available Cacao(Grams): " + startup.getCacaoAmount());
                        startMenu();
                        break;

                    //Fill machine with ingredients.
                    case 2:
                        addIngredient();
                        break;

                    //Clean the machine by taking out all ingredients.
                    case 3:
                        /*If machine is empty system gives output and returns to main menu,
                        otherwise cleans machine.
                        */
                        if (startup.getCoffeeAmount() == 0 && startup.getWaterAmount() == 0 &&
                                startup.getMilkAmount() == 0 && startup.getCacaoAmount() == 0) {
                            System.out.println("No cleaning needed, machine is empty.");
                            startMenu();
                        } else {
                            clean.cleanMachine();
                        }
                        break;

                    //Outputs menu to choose what user would like to drink.
                    case 4:
                        make.makeCoffee();
                        break;

                    /*Shows what coffee has already been made.
                    if no drinks made the System will show output and go back to main menu.
                    */
                    case 5:
                        if (MakeCoffee.coffeeMade.isEmpty()) {
                            System.out.println("No Coffee made yet.");
                            startMenu();
                        } else {
                            System.out.println("Coffee amount made: "
                                    + make.getCoffeeMade());
                            startMenu();
                        }
                        break;

                    //Turns machine off.
                    case 6:
                        run = false;
                        System.out.println("Shutting Down...");
                        System.exit(0);
                        break;

                    default:
                        //Outputs Error if wrong Input.
                        System.out.println("Error " + input + " was not found!");
                        startMenu();
                        break;
                }

            } catch (Exception e) {

                MainMenu menu = new MainMenu();
                System.out.println("Error wrong input!");
                menu.startMenu();

            }
        }
    }

    //Method for adding ingredients to machine.
    public void addIngredient() {

        MainMenu menu = new MainMenu();
        StartUp startup = new StartUp();

        double maxWater = 1;
        int maxCoffeePowder = 20;
        double maxMilk = 1;
        int maxCacao = 20;

        System.out.println("Filling machine...");
        startup.setWaterAmount(maxWater);
        startup.setCoffeeAmount(maxCoffeePowder);
        startup.setMilkAmount(maxMilk);
        startup.setCacaoAmount(maxCacao);
        menu.startMenu();
    }
}
