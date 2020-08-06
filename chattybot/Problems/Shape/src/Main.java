import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String message = "You have chosen a ";

        switch (num) {
            case 1:
                message += "square";
                break;
            case 2:
                message += "circle";
                break;
            case 3:
                message += "triangle";
                break;
            case 4:
                message += "rhombus";
                break;
            default:
                message = "There is no such shape!";
                break;
        }
        System.out.println(message);
    }
}