import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        final int iLen = scan.nextInt();
        final int jLen = scan.nextInt();
        final int[][] array = new int[iLen][jLen];
        final int[][] rotArray = new int[jLen][iLen];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scan.nextInt();
            }
        }

        /* 1,1 1,2 1,3 1,4 -- i  ,j+0 | i  ,j+1| i  ,j+2 ...|i  , j+n-1
           2,1 2,2 2,3 2,4 -- 1+1,
           3,1 3,2 3,3 3,4 --
           .........
           3,1 2,1 1,1 --
           3,2 2,2 1,2 --
           3,3 2,3 1,3 --
           3,4 2,3 1,4 --
         */
        // rotate 90.
        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                rotArray[j][iLen - 1 - i] = array[i][j];
            }
        }

        printArray(rotArray);
    }

    private static void printArray(int[][] array) {
        System.out.println();
        for (int[] row : array) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}