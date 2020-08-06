import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[][] array = new int[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                array[i][j] = scan.nextInt();
            }
        }

        boolean symmetric = true;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (array[i][j] != array[j][i]) {
                    symmetric = false;
                    break;
                }
            }
        }

        if (symmetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

/*
(3,3)
0 1 2
1 2 3
2 3 4

(0,0) == (0,0)
(0,1) == (1,0)
(0,2) == (2,0)
(1,2) == (2,1)
(2,2) == (2,1)
 */