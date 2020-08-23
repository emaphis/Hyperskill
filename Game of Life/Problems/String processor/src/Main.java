import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        // implement this method
        boolean loop = true;
        while (loop) {
            String line = scanner.nextLine();
            if (isAnyLowerCase(line)) {
                System.out.println(line.toUpperCase());
            } else {
                System.out.println("FINISHED");
                loop = false;
            }
        }
    }

    private boolean isAnyLowerCase(String str) {
        char[] array = str.toCharArray();

        for (char chr : array) {
            if (Character.isLowerCase(chr)) {
                return true;
            }
        }
        return false;
    }
}
