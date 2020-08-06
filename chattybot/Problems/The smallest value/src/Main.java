import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        long num =  scan.nextLong();
        long fac = 1;
        long i = 0;
        while (num >= fac) {
            i++;
            fac *= i;
        }
        System.out.println(i);
    }
}