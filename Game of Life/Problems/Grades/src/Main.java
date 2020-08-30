import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int numA = 0;
        int numB = 0;
        int numC = 0;
        int numD = 0;
        for (int i = 0; i < num; i++) {
            int grade = scan.nextInt();
            switch (grade) {
                case 5:
                    numA++;
                    break;
                case 4:
                    numB++;
                    break;
                case 3:
                    numC++;
                    break;
                case 2:
                    numD++;
                    break;
                default:
            }
        }
        System.out.println(numD + " " + numC + " " + numB + " " + numA);
    }
}