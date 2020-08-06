import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int iLen = scan.nextInt();
        int jLen = scan.nextInt();
        int[][] array = new int[iLen][jLen];

        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                array[i][j] = scan.nextInt();
            }
        }

        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                if (array[i][j] > array[maxI][maxJ]) {
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        System.out.println("\n" + maxI + " " + maxJ);
    }
}