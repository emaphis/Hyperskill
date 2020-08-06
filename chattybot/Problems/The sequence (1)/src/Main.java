import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);

        int mum = scan.nextInt();
        int count1 = 1;
        int count2;
        int accumulate = 0;

        while (accumulate != mum) {
            count2 = 0;
            while (count2 < count1) {
                System.out.print(count1 + " ");
                accumulate++;
                count2++;

                if (accumulate == mum) {
                    break;
                }
            }
            count1++;
        }
    }
}