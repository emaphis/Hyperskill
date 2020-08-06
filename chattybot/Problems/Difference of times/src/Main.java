import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int hours1 = scanner.nextInt();
        int minutes1 = scanner.nextInt();
        int secondes1 = scanner.nextInt();
        int hours2 = scanner.nextInt();
        int minutes2 = scanner.nextInt();
        int secondes2 = scanner.nextInt();
        int time1 = hours1 * 3600 + minutes1 * 60 + secondes1;
        int time2 = hours2 * 3600 + minutes2 * 60 + secondes2;
        System.out.println(time2 - time1);
    }
}