import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // I had to use a loop
        int height = scanner.nextInt();
        int up = scanner.nextInt();
        int dwn = scanner.nextInt();
        int days = 1;
        int dist = up;
        while (dist < height) {
            dist = dist + (up - dwn);
            days = days + 1;
        }
        System.out.println(days);
    }
}
