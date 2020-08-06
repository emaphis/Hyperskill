//put imports you need here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        scanner.next();
        scanner.next();
        scanner.next();
        String preference = scanner.next();
        
        System.out.print("The form for ");
        System.out.print(name);
        System.out.print(" is completed. We will contact you if we need a chef that cooks ");
        System.out.print(preference);
        System.out.println(" dishes.");
    }
}
