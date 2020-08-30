import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int larger = 0;   // 1
        int smaller = 0;  // -1
        int perfect = 0;  // 0

        int num = scan.nextInt();
        for (int i = 0; i < num; i++) {
            int part = scan.nextInt();
            if (part == 1) {
                larger++;
            } else if (part == -1) {
                smaller++;
            } else if (part == 0) {
                perfect++;
            }
        }
        System.out.println(perfect + " " + larger + " " + smaller);
    }
}