import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        String room = scan.nextLine();
        double a;
        double b;
        double c;
        double r;

        switch (room) {
            case "triangle":
                a = scan.nextDouble();
                b = scan.nextDouble();
                c = scan.nextDouble();
                double s = 0.5 * (a + b + c);
                double ar = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                System.out.println(ar);
                break;
            case "rectangle":
                a = scan.nextDouble();
                b = scan.nextDouble();
                System.out.println(a * b);
                break;
            case "circle":
                r = scan.nextDouble();
                double pi = 3.14;
                System.out.println(pi * r * r);
                break;
            default:
                System.out.println("Unknown room shape");
                break;
        }
    }
}