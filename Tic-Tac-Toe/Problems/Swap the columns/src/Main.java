import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int iLen = scanner.nextInt();
        int jLen = scanner.nextInt();
        int[][] array = new int[iLen][jLen];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        int row1 = scanner.nextInt();
        int row2 = scanner.nextInt();

        // swap rows
        for (int i = 0; i < array.length; i++) {
            int temp = array[i][row1];
            array[i][row1] = array[i][row2];
            array[i][row2] = temp;
        }

        System.out.println();
        for (int[] row : array) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}