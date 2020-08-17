public class Junk {
    public static void main(String[] args) {
        System.out.println(method(127));
        System.out.println(method(128));
        System.out.println(method(1));
        System.out.println(method(128));
        System.out.println(method(129));
        System.out.println(method(128));
    }

    public static long method(long n) {

        if (n == 1) {
            return 0;
        }
        return method(n / 2) + 1;
    }
}
// 8 7 6 5 4 3 2 1 0
// 2 + 9 + 8 + 1 + 5