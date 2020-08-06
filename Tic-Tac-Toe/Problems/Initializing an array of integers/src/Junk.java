import java.util.Arrays;

public class Junk {
    public static void main(String[] args) {
        System.out.println("Hello junk");
    }

    private static void example1() {
        int[][] twoDimArray = new int[3][];

        twoDimArray[0] = new int[] { 1, 2, 3,4 };
        twoDimArray[1] = new int[] { 5, 7, 3 };
        twoDimArray[2] = new int[] { 8 };

        for (int i = 0; i < twoDimArray.length; i++) {
            System.out.println(Arrays.toString(twoDimArray[i]));
        }

        // three two dimensional arrays.
        int[][][] cubic = new int[3][4][5];

        int current = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    cubic[i][j][k] = current;
                }
            }
            current++;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(cubic[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        current = 1;
        for (int[][] dim2Array : cubic) {     // for each 2-dim array
            for (int[] vector : dim2Array) {  // for each 1-dim array (vector) of 2-dim array
                Arrays.fill(vector, current); // fill the vector
            }
            current++; // the next current
        }

        // this code prints all 2-dimensional arrays
        for (int[][] dim2Array : cubic) {
            for (int[] vector : dim2Array) {
                System.out.println(Arrays.toString(vector));
            }
            System.out.println();
        }
    }
}
