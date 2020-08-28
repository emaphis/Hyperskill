class Predicate {

    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (a, b, c) -> a != b && a != c && b != c;

    @FunctionalInterface
    public interface TernaryIntPredicate {
        // Write a method here
        boolean test(int a, int b, int c);
    }
}
