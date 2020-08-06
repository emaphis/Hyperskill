import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);

        int iLen = 0;
        String line;
        StringBuilder builder = new StringBuilder();

        while (true) {
            line = scan.nextLine();
            if ("end".equals(line)) {
                break;
            }
            builder.append(line).append(" ");
            iLen++;
        }

        String[] pieces = builder.toString().trim().split(" ");
        int jLen = pieces.length / iLen;
        int[][] array = new int[iLen][jLen];

        int idx = 0;
        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                array[i][j] = Integer.parseInt(pieces[idx]);
                idx++;
            }
        }

        int[][] sum = sumArray(array, iLen, jLen);

        printArray(sum);
    }

    /*
    (i-1, j)     (i+1, j)     (i, j-1),    (i, j+1)
    (prev(i), j) (next(i), j) (i, prev(i)) (i, next(i))
    */
    private static int[][] sumArray(int[][] array, int iLen, int jLen) {
        int[][] sumArray = new int[iLen][jLen];
        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                sumArray[i][j] = array[prev(i, iLen)][j]
                               + array[next(i, iLen)][j]
                               + array[i][prev(j, jLen)]
                               + array[i][next(j, jLen)];
            }
        }
        return sumArray;
    }

    private static int next(int idx, int iLen) {
        if (idx == iLen - 1) {
            return 0;
        }
        return  idx + 1;
    }
    private static int prev(int idx, int jLen) {
        if (idx == 0) {
            return jLen - 1;
        }
        return idx - 1;
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
