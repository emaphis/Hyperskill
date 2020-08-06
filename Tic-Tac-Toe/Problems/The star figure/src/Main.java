import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        final int num = scan.nextInt();
        final int half = num / 2;
        final char[][] array = new char[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == j || j == num - (i + 1) || i == half || j == half) {
                    array[i][j] = '*';
                } else {
                    array[i][j] = '.';
                }
            }
        }

        System.out.println();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
