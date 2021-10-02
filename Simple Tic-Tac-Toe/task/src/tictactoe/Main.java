package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inStr = scanner.nextLine();
        drawField(inStr);
        launchGame(scanner);
        //calculateResult(inStr);
    }

    private static void launchGame(Scanner scanner) {
        System.out.println("Enter the coordinates: ");
        int[] coords = {scanner.nextInt(),scanner.nextInt()};

    }

    private static void drawField(String inStr) {

        System.out.println("Enter cells: " + inStr);
        System.out.println("---------");
        for (int i = 0; i < inStr.length(); i+=3) {
            System.out.println("| " + inStr.charAt(i) + " "
                    + inStr.charAt(i + 1) + " "
                    + inStr.charAt(i + 2) + " |");
        }
        System.out.println("---------");
    }

    private static void calculateResult(String inStr) {
        int xNum = 0;
        int oNum = 0;
        int xThree = 0;
        int oThree = 0;
        boolean freeSpace = false;

        for (int i = 0; i < inStr.length(); i++) {
            if (inStr.charAt(i) == 'X') {
                xNum++;
            } else if (inStr.charAt(i) == 'O') {
                oNum++;
            } else {
                freeSpace = true;
            }
        }
        int [] row = {0,0,0};
        int [] col = {0,0,0};
        int [] diag = {0,0,0};
        for (int i = 0; i < 3; i++) { //calculating cols values
            for (int j = 0; j < 8; j+=3) {
                col[i] += inStr.charAt(i+j);
            }

        }
        for (int i = 0; i < 8; i+=3) { //calculating rows values
            for (int j = 0; j < 3; j++) {
                row[i/3] += inStr.charAt(i+j);
                System.out.print(inStr.charAt(i+j));
            }
            System.out.println("");
        }
        diag[0] = inStr.charAt(0) +  inStr.charAt(4) + inStr.charAt(8);
        diag[1] = inStr.charAt(2) +  inStr.charAt(4) + inStr.charAt(6);
        for (int i = 0; i < 3; i++) {
            if (row[i]  == 264 || col[i] == 264 || diag[i] == 264) {
                xThree++;
            } else if (row[i] == 237 || col[i] == 237 || diag[i] == 237) {
                oThree++;
            }
        }

        if (Math.abs(xNum - oNum) > 1 || (xThree > 0 && oThree > 0)) {
            System.out.println("Impossible");
        } else if (xThree > 0) {
            System.out.println("X wins");
        } else if (oThree > 0) {
            System.out.println("O wins");
        } else if (oThree == 0 && xThree == 0 && !freeSpace) {
            System.out.println("Draw");
        }  else {
            System.out.println("Game not finished");
        }
    }


}