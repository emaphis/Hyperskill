import java.util.Scanner;

class Main {
    private static int limit;
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        limit = num;
        decompose(num);
    }

    public static void decompose(int num) {
        decomposeLoop(num, 1);
    }

    private static void decomposeLoop(int num, int idx) {
        System.out.print(idx + ":" + limit + " - ");
        if (idx >= limit) {
            System.out.println();

        }
        //System.out.print(num + ":" + idx + " ");
        idx++;
        decomposeLoop(num, idx);
    }
}