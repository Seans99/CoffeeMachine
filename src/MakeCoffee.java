import java.util.ArrayList;
import java.util.Scanner;

public class MakeCoffee {

    //Array list for showing what kind of drinks has been made.
    public static ArrayList<String> coffeeMade = new ArrayList<>();

    public ArrayList<String> getCoffeeMade() {
        return coffeeMade;
    }

    public void setCoffeeMade(String drink) {
        coffeeMade.add(drink);
    }

    public void makeCoffee() {

        //Objects for other classes
        MainMenu menu = new MainMenu();
        StartUp start = new StartUp();

        //Scanner for user input.
        Scanner scan = new Scanner(System.in);

        //Outputs drink choice menu.
        System.out.println("-----------------------------");
        System.out.println("|    What would you like?   |");
        System.out.println("-----------------------------");
        System.out.println("|     1. Coffee black       |");
        System.out.println("-----------------------------");
        System.out.println("|     2. Coffee with milk   |");
        System.out.println("-----------------------------");
        System.out.println("|     3. Chocolate milk     |");
        System.out.println("-----------------------------");
        System.out.println("|     4. Menu               |");
        System.out.println("-----------------------------");

        //User input.
        int input = scan.nextInt();

        switch (input) {

            /*Makes 1.Coffee black, 2.Coffee with milk or 3.Chocolate milk.
            if low on ingredients gives output and goes back to choose new drink.
             */
            case 1:
                if (StartUp.getCoffeeAmount() == 0 && StartUp.getWaterAmount() == 0) {
                    System.out.println("No Water, Coffee Powder and milk left.");
                    makeCoffee();
                } else if (StartUp.getCoffeeAmount() == 0) {
                    System.out.println("No Coffee Powder left.");
                    makeCoffee();
                } else if (StartUp.getWaterAmount() == 0) {
                    System.out.println("No Water left.");
                    makeCoffee();
                }
                System.out.println("Making Coffee black...");
                System.out.println("Taking 10g of Coffee beans...");
                System.out.println("Taking 0.2 liter Water...");

                start.getCoffeeBlack(0.2, 10);

                setCoffeeMade("Coffee black");
                System.out.println("Coffee Ready, returning to menu...");
                menu.startMenu();
                break;

            case 2:
                if (StartUp.getCoffeeAmount() == 0 && StartUp.getWaterAmount() == 0 && StartUp.getMilkAmount() == 0) {
                    System.out.println("No Water, Coffee Powder and milk left.");
                    makeCoffee();
                } else if (StartUp.getCoffeeAmount() == 0) {
                    System.out.println("No Coffee Powder left.");
                    makeCoffee();
                } else if (StartUp.getWaterAmount() == 0) {
                    System.out.println("No Water left.");
                    makeCoffee();
                } else if (StartUp.getMilkAmount() == 0) {
                    System.out.println("No Milk left.");
                    makeCoffee();
                }
                System.out.println("Making Coffee with milk...");
                System.out.println("Taking 10g of Coffee beans...");
                System.out.println("Taking 0.2 liter Water...");
                System.out.println("Taking 0.1 liter Milk...");

                start.getCoffeeMilk(0.2, 0.1, 10);

                setCoffeeMade("Coffee milk");
                System.out.println("Coffee ready, returning to menu...");
                menu.startMenu();
                break;

            case 3:
                if (StartUp.getCacaoAmount() == 0 && StartUp.getMilkAmount() == 0) {
                    System.out.println("No Water, Coffee Powder and milk left.");
                    makeCoffee();
                } else if (StartUp.getCacaoAmount() == 0) {
                    System.out.println("No Cacao left.");
                    makeCoffee();
                } else if (StartUp.getMilkAmount() == 0) {
                    System.out.println("No Milk left.");
                    makeCoffee();
                }
                System.out.println("Making Chocolate milk...");
                System.out.println("Taking 10g of Cacao...");
                System.out.println("Taking 0.2 liters of Milk...");

                start.getChocoMilk(0.2, 10);

                setCoffeeMade("Chocolate milk");
                System.out.println("Chocolate milk ready, returning to menu...");
                menu.startMenu();
                break;

            case 4:
                //Returns to Main menu.
                System.out.println("Returning to menu...");
                menu.startMenu();

            default:
                //Outputs Error if wrong Input.
                System.out.println(input + " not found");
                makeCoffee();
                break;
        }
    }
}
