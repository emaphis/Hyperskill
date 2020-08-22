import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);

        while (true) {

            String input = scan.next();

            try {
                int num = Integer.parseInt(input);
                if (num == 0) {
                    break;
                }
                System.out.println(num * 10);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid user input: " + input);
            }
        }
    }
}