import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int num = -1;
        while (count > 0) {
            int newnum = scanner.nextInt();
            if (newnum % 4 == 0 && newnum > num) {
                num = newnum;
            }
            count--;
        }
        System.out.println(num);
    }
}