import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int nextNumber;
        boolean ret;
        final int same = 0;
        final int ascend = 1;
        final int descend = 2;
        int direction = same;

        while (true) {
            nextNumber = scan.nextInt();
            if (nextNumber == 0) {
                ret = true;
                break;
            }

            if (direction == same) {
                if (number > nextNumber) {
                    direction = descend;
                } else if (number < nextNumber) {
                    direction = ascend;
                }
            } else {
                if (number > nextNumber && direction == ascend) {
                    ret = false;
                    break;
                } else if (number < nextNumber && direction == descend) {
                    ret = false;
                    break;
                } else {
                    number = nextNumber;
                }
            }
        }

        System.out.println(ret);
    }
}