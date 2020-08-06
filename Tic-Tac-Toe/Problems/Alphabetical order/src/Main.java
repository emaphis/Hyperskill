import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        String[] strings = line.split(" ");
        boolean inOrder = true;

        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i].compareTo(strings[i + 1]) > 0) {
                inOrder = false;
                break;
            }
        }

        System.out.println(inOrder);
    }
}