import java.util.Scanner;

public class StartUp {

    //Machine Ingredients.
    public static double waterAmount;
    public static int coffeeAmount;
    public static double milkAmount;
    public static int cacaoAmount;

    //Getter and Setters for all ingredients.
    public double getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(double waterAmount) {
        StartUp.waterAmount = waterAmount;
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public void setCoffeeAmount(int coffeeAmount) {
        StartUp.coffeeAmount = coffeeAmount;
    }

    public double getMilkAmount() {
        return milkAmount;
    }

    public void setMilkAmount(double milkAmount) {
        StartUp.milkAmount = milkAmount;
    }

    public int getCacaoAmount() {
        return cacaoAmount;
    }

    public void setCacaoAmount(int cacaoAmount) {
        StartUp.cacaoAmount = cacaoAmount;
    }

    //Ingredients get subtracted to make a Coffee black.
    public void getCoffeeBlack(double a, int b) {
        double sumWater = waterAmount - a;
        int sumPowder = coffeeAmount - b;

        waterAmount = sumWater;
        coffeeAmount = sumPowder;
    }

    //Ingredients get subtracted to make a Coffee with milk.
    public void getCoffeeMilk(double a, double b, int c) {
        double sumWater = waterAmount - a;
        double sumMilk = milkAmount - b;
        int sumPowder = coffeeAmount - c;

        waterAmount = sumWater;
        milkAmount = sumMilk;
        coffeeAmount = sumPowder;
    }

    //Ingredients get subtracted to make Chocolate milk.
    public void getChocoMilk(double a, int b) {
        double sumMilk = milkAmount - a;
        int sumCacao = cacaoAmount - b;

        milkAmount = sumMilk;
        cacaoAmount = sumCacao;
    }

    //Machine startup menu.
    public void machineStartUp() {

        //Scanner for user input.
        Scanner scan = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("|   Start Machine? |");
        System.out.println("|       Y or N     |");
        System.out.println("--------------------");

        try {
            //User input.
            String input = scan.next();

            //if input is y it starts the coffee machine otherwise it exits.
            if (input.equals("Y") || input.equals("y")) {
                MainMenu menu = new MainMenu();
                menu.startMenu();
            } else if (input.equals("N") || input.equals("n")) {
                System.exit(0);
            } else {
                //Outputs Error if wrong Input.
                System.out.println(input + " Not found, please try again");
                machineStartUp();
            }
        } catch (Exception e) {
            System.out.println("Error wrong input!");
            machineStartUp();
        }
    }

    public static void main(String[] args) {

        //Object for start menu.
        StartUp start = new StartUp();
        start.machineStartUp();

    }

}
