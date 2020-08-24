import java.util.Scanner;
import java.util.function.IntBinaryOperator;

class Operator {

    public static IntBinaryOperator binaryOperator = (x, y) -> x > y ? x : y;
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();

        int z = Operator.binaryOperator.applyAsInt(x, y);
        System.out.println(z);
    }
}