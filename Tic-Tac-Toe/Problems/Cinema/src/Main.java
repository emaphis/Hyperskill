import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();  // rows
        int m = scan.nextInt();   // seats in one row
        int[][] cinema = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cinema[i][j] = scan.nextInt();
            }
        }
        int request = scan.nextInt();

        int row  = 0;
        for (int i = 0; i < cinema.length; i++) {
            if (request <= maxSeats(cinema[i])) {
                row = i + 1;  // human count starts at one.
                break;
            }
        }

        System.out.println(row);
    }

    private static int maxSeats(int[] row) {
        int max = 0;
        int count = 0;
        for (int seat : row) {
            if (seat == 0) {
                count++;
            } else {
                count = 0;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}