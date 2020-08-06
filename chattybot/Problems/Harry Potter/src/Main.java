import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        String house = scan.nextLine();
        String ret;

        switch (house) {
            case "gryffindor":
                ret = "bravery";
                break;
            case "hufflepuff":
                ret = "loyalty";
                break;
            case "slytherin":
                ret = "cunning";
                break;
            case "ravenclaw":
                ret = "intellect";
                break;
            default:
                ret = "not a valid house";
                break;
        }
        System.out.println(ret);
    }
}