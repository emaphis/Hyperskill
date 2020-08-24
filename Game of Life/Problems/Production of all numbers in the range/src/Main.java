import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (x, y) -> {
        long prod = 1;
        for (long i = x; i <= y; i++) {
            prod *= i;
        }
        return prod;
    };
}
