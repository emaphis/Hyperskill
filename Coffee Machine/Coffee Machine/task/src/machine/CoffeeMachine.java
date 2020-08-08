package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int amountWater = 400;
    private static int amountMilk = 540;
    private static int amountBeans = 120;
    private static int amountDispCups = 9;
    private static int amountMoney = 550;

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        programLoop();
    }

    private static void programLoop() {
        boolean next = true;
        while (next) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String choice = scan.next();
            switch (choice) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    displayMachineState();
                    break;
                case "exit":
                    next = false;
                    break;
                default:
                    System.out.println("Unknown action..");
                    break;
            }
        }
    }

    private static void displayMachineState() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(amountWater + " of water");
        System.out.println(amountMilk + " of milk");
        System.out.println(amountBeans + " of coffee beans");
        System.out.println(amountDispCups + " of disposable cups");
        System.out.println("$" + amountMoney + " of money");
        System.out.println();
    }

    private static  void buyCoffee() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scan.next();
        switch (choice) {
            case "1":
                makeCoffee("espresso",250, 0, 16, 4);
                break;
            case "2":
                makeCoffee("latte",350, 75, 20, 7);
                break;
            case "3":
                makeCoffee("cappuccino",200, 100, 12, 6);
                break;
            case "back":
                break;
            default:
                System.out.println("Unknown choice ...");
                break;
        }

    }

    private static boolean makeCoffee(String type, int water, int milk, int beans, int money) {
        if (water > amountWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk > amountMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beans > amountBeans) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!");
        consumeIngredients(water, milk, beans, money);
        return true;
    }

    private static void fillMachine() {
        System.out.println();
        System.out.println("Write how many ml of water do you want to add:");
        int water = scan.nextInt();

        System.out.println("Write how many ml of milk do you want to add: ");
        int milk = scan.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beans = scan.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int cups = scan.nextInt();

        loadMachine(water, milk, beans, cups);
    }


    private static void takeMoney() {
        int money = resetMoney();
        System.out.println("I gave you $" + money);
    }

    ///////////////////
    /// machine methods.

    private static void consumeIngredients(int water, int milk, int beans, int money) {
        amountWater -= water;
        amountMilk -= milk;
        amountBeans -= beans;
        amountDispCups--;
        amountMoney += money;
    }

    private static void loadMachine(int water, int milk, int beans, int cups) {
        amountWater += water;
        amountMilk += milk;
        amountBeans += beans;
        amountDispCups += cups;
    }

    private static int resetMoney() {
        int money = amountMoney;
        amountMoney = 0;
        return  money;
    }
}
