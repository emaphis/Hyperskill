import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int[][] array = new int[num][num];

        int count = 1;
        int top = 0;
        int bottom = num - 1;
        int left = 0;
        int right = num - 1;

        while (true) {
            if (left > right) {
                break;
            }

            // top row
            for (int i = left; i <= right; i++) {
                array[top][i] = count;
                count++;
            }
            top++;

            if (top > bottom) {
                break;
            }

            // right column
            for (int i = top; i <= bottom; i++) {
                array[i][right] = count;
                count++;
            }
            right--;

            if (left > right) {
                break;
            }

            // bottom row
            for (int i = right; i >= left; i--) {
                array[bottom][i] = count;
                count++;
            }
            bottom--;

            if (top > bottom) {
                break;
            }

            // left column
            for (int i = bottom; i >= top; i--) {
                array[i][left] = count;
                count++;
            }
            left++;
        }

        // print array
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*    1  2  3  4  5
      16 17 18 19  6
      15 24 25 20  7
      14 23 22 21  8
      13 12 11 10  9

   1(0, 0)  2(0, 1)  3(0, 2)  4(0, 3)  5(0, 4)
*  6(1, 4)  7(2, 4)  8(3, 4)  9(4, 4)
  10(4, 3) 11(4, 2) 12(4, 1) 13(4, 0)
* 14(3, 0) 15(2, 0) 16(1, 0)
  17(1, 1) 18(2, 1) 19(3, 1)
* 20(2, 3) 21(3, 3)
  22(3, 2) 23(3, 1)
* 24(2, 1)
  25(2, 2)
 */