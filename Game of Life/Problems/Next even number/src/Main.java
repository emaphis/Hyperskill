import java.util.function.LongUnaryOperator;

class Operator {

    public static LongUnaryOperator unaryOperator = num -> {
        if (num % 2 == 0) {
            return num + 2;
        } else {
            return num + 1;
        }
    };
}