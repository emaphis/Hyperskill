package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int amountWater = 400;
    private static int amountMilk = 540;
    private static int amountBeans = 120;
    private static int amountDispCups = 9;
    private static int amountMoney = 550;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        displayMachineState();
        handleInput(scan);
        //calcIngredients(scan);
    }

    private static void displayMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(amountWater + " of water");
        System.out.println(amountMilk + " of milk");
        System.out.println(amountBeans + " of coffee beans");
        System.out.println(amountDispCups + " of disposable cups");
        System.out.println(amountMoney + " of money");
    }

    private static void handleInput(Scanner scan) {
        System.out.println("Write action (buy, fill, take): ");
        String action = scan.nextLine();
        if (action.equals("buy")) {
            System.out.println("buy");
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
            int choice = scan.nextInt();
            if (choice == 1) { // "espresso..."
                consumeIngredients(250, 0, 16, 4);
            } else if (choice == 2) {  // "latte..."
                consumeIngredients(350, 75, 20, 7);
            } else if (choice == 3) {  // "cappuccino ..."
                consumeIngredients(200, 100, 12, 6);
            } else {
                System.out.println("Unknown choice ...");
            }
            System.out.println();
            displayMachineState();
        } else if (action.equals("fill")) {
            System.out.println("Write how many ml of water do you want to add:");
            amountWater += scan.nextInt();

            System.out.println("Write how many ml of milk do you want to add: ");
            amountMilk += scan.nextInt();

            System.out.println("Write how many grams of coffee beans do you want to add:");
            amountBeans += scan.nextInt();

            System.out.println("Write how many disposable cups of coffee do you want to add: ");
            amountDispCups += scan.nextInt();

            System.out.println();
            displayMachineState();
        } else if (action.equals("take")) {
            System.out.println("I gave you $" + amountMoney);
            amountMoney = 0;
            System.out.println();
            displayMachineState();
        } else {
            System.out.println("Unknown action..");
        }
    }

    private static void consumeIngredients(int water, int milk, int beans, int money) {
        amountWater -= water;
        amountMilk -= milk;
        amountBeans -= beans;
        amountDispCups--;
        amountMoney += money;
    }

}
