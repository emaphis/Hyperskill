import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        // put your code here
        System.out.println("Matrix a");
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        String[] pieces = line.split(" ");
        int[] a = new int[pieces.length];
        for (int i = 0; i < pieces.length; i++) {
            a[i] = Integer.parseInt(pieces[i]);
        }

        int num = scan.nextInt();
     //   num %= pieces.length;

        for (int k = 0; k < num; k++) {
            int temp = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = temp;
            System.out.print(Arrays.toString(a));
            System.out.println();
        }

        for (int n: a) {
            System.out.print(n + " ");
        }
    }
}
