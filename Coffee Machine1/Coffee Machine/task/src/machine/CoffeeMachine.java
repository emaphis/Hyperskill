package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static final Machine machine = new Machine(400, 540, 120, 9, 550);
    private static final Scanner scan = new Scanner(System.in);

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
                    machine.displayMachineState();
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

    private static void buyCoffee() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scan.next();
        switch (choice) {
            case "1":
                makeCoffee(Coffees.ESPRESSO);
                break;
            case "2":
                makeCoffee(Coffees.LATTE);
                break;
            case "3":
                makeCoffee(Coffees.CAPPUCCINO);
                break;
            case "back":
                break;
            default:
                System.out.println("Unknown choice ...");
                break;
        }
    }

    private static boolean makeCoffee(Coffees type) {

        ErrorStates error = machine.machineMakeCoffee(type);
        boolean ret = false;

        if (error == ErrorStates.WATER) {
            System.out.println("Sorry, not enough water!");
            ret = false;
        } else if (error == ErrorStates.MILK) {
            System.out.println("Sorry, not enough milk!");
            ret = false;
        } else if (error == ErrorStates.BEANS) {
            System.out.println("Sorry, not enough beans!");
            ret = false;
        } else if (error == ErrorStates.OK) {
            System.out.println("I have enough resources, making you a coffee!");
            ret = true;
        }
        return ret;
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

        machine.loadMachine(water, milk, beans, cups);
    }

    private static void takeMoney() {
        int money = machine.resetMoney();
        System.out.println("I gave you $" + money);
    }

}

// espresso, 2 - latte, 3 - cappuccino
enum Coffees {
    ESPRESSO, LATTE, CAPPUCCINO
}

enum ErrorStates {
    OK, WATER, MILK, BEANS, CUPS
}

class Machine {
    private int amountWater;
    private int amountMilk;
    private int amountBeans;
    private int amountDispCups;
    private int amountMoney;

    public Machine(int water, int milk, int beans, int dispCups, int money) {
        this.amountWater = water;
        this.amountMilk = milk;
        this.amountBeans = beans;
        this.amountDispCups = dispCups;
        this.amountMoney = money;
    }

    public ErrorStates machineMakeCoffee(Coffees type) {
        ErrorStates state = ErrorStates.OK;

        switch (type) {
            case ESPRESSO:
                state = consumeIngredients(250, 0, 16, 4);
                break;
            case LATTE:
                state = consumeIngredients(350, 75, 20, 7);
                break;
            case CAPPUCCINO:
                state = consumeIngredients(200, 100, 12, 6);
                break;
        }

        return state;
    }

    public ErrorStates consumeIngredients(int water, int milk, int beans, int money) {
        if (water > amountWater) {
            return ErrorStates.WATER;
        }
        if (milk > amountMilk) {
            return ErrorStates.MILK;
        }
        if (beans > amountBeans) {
            return ErrorStates.BEANS;
        }
        if (amountDispCups < 1) {
            return ErrorStates.CUPS;
        }
        amountWater -= water;
        amountMilk -= milk;
        amountBeans -= beans;
        amountDispCups--;
        amountMoney += money;

        return ErrorStates.OK;
    }

    public void loadMachine(int water, int milk, int beans, int cups) {
        amountWater += water;
        amountMilk += milk;
        amountBeans += beans;
        amountDispCups += cups;
    }

    public int resetMoney() {
        int money = amountMoney;
        amountMoney = 0;
        return  money;
    }

    public void displayMachineState() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(amountWater + " of water");
        System.out.println(amountMilk + " of milk");
        System.out.println(amountBeans + " of coffee beans");
        System.out.println(amountDispCups + " of disposable cups");
        System.out.println("$" + amountMoney + " of money");
        System.out.println();
    }
}

