package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //calcIngredients(scan);
        calcRequirements(scan);
    }

    private static void calcRequirements(Scanner scan) {
        System.out.println("Write how many ml of water the coffee machine has: ");
        int cupsWater = cupsFromWater(scan.nextInt());
        System.out.println("Write how many ml of milk the coffee machine has:");
        int cupsMilk = cupsFromMilk(scan.nextInt());
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int cupsBeans = cupsFromBeans(scan.nextInt());
        System.out.println(cupsWater + ":" + cupsMilk + ":" + cupsBeans);
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scan.nextInt();

        int cupsCanMake = 0;
        if (cupsWater < cupsMilk) {
            cupsCanMake = cupsWater;
        } else {
            cupsCanMake = cupsMilk;
        }
        if (cupsCanMake > cupsBeans) {
            cupsCanMake = cupsBeans;
        }

        int excessCups = cupsCanMake - cups;
        boolean isEmpty = (cupsWater == 0 || cupsMilk == 0 || cupsBeans == 0);

        if (isEmpty) {
            System.out.println("No, I can make only 0 cup(s) of coffee");
        } else if (cups == cupsCanMake) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (excessCups > 0) {
            System.out.println("Yes, I can make that amount of coffee (and even " + excessCups + " more than that");
        } else {
            System.out.println("No, I can make only " + cupsCanMake + " cup(s) of coffee");
        }
    }

    private static int cupsFromWater(int ml) {
        return ml / 200;
    }

    private static int cupsFromMilk(int ml) {
        return ml / 50;
    }

    private static int cupsFromBeans(int gr) {
        return gr / 15;
    }

    private static void calcIngredients(Scanner scan) {
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scan.nextInt();
        System.out.printf("For %d cups of coffee you will need:\n", cups);
        System.out.printf("%d ml of water\n", getWater(cups));
        System.out.printf("%d ml of milk\n", getMilk(cups));
        System.out.printf("%d g of coffee beans\n", getBeans(cups));
    }

    private static int getWater(int cups) {
        return cups * 200;
    }

    private static int getMilk(int cups) {
        return cups * 50;
    }

    private static int getBeans(int cups) {
        return cups * 15;
    }
}
