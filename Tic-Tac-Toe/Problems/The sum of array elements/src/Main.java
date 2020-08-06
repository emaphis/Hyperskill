import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            array[i] = scan.nextInt();
        }

        int sum = 0;
        for (int value : array) {
            sum += value;
        }

        System.out.println(sum);
    }
}