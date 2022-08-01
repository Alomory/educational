package com.thisgary.c3034.project;

import com.thisgary.library.Dumpster;
import com.thisgary.library.GetNumber;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;


public class Main {
    private static void swap(int[] xs, int i, int j) {
        int t = xs[j];
        xs[j] = xs[i];
        xs[i] = t;
    }

    // Fisher–Yates
    private static int[] fillBox() {
        Random r = ThreadLocalRandom.current();
        int[] row = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = 8;
        while (i > 0) {
            int j = r.nextInt(i + 1);
            swap(row, i--, j);
        }
        return row;
    }

//    private static boolean checkBox(int[][] board, int x, int y) {
//        boolean pass = true;
//        int x0 = x / 3 * 3, y0 = y / 3 * 3;
//        int x1 = x0 + 3, y1 = y0 + 3;
//        for (int i = x0; i < x1; i++) {
//            for (int j = y0; j < y1; j++) pass &= (i == x && j == y || board[i][j] == 0 || board[x][y] != board[i][j]);
//        }
//        return pass;
//    }

    private static boolean check(int[][] grid) {
        boolean pass = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) // row check
                for (int k = 0; k < 9; k++) pass &= (j == k || grid[i][j] != grid[i][k]);
            for (int j = 0; j < 9; j++)
                for (int k = 0; k < 9; k++) pass &= (j == k || grid[j][i] != grid[k][i]);
        }
        return pass;
    }

    private static int[][] toGrid(int[] flat) {
        int[][] grid = new int[9][9];
        int k = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) grid[i][j] = flat[k++];
        }
        return grid;
    }

    private static int[][] fill() {
        int[] flat = new int[81]; // flatten grid

        // filling flat
        for (int b = 0; b < 9; b++) {
            int[] box = fillBox(); // generate shuffled {1, ..., 9}
            // allocate the array to flat
            int o = (b / 3 * 9 + b % 3) * 3; // origin of box on flat
            // iterate through cells in box
            for (int j = 0; j < 9; j++) {
                int pos = o + j / 3 * 9 + j % 3; // pos of cell on flat
                flat[pos] = box[j];
            }
        }

        // verification
        // TODO: Implements own version of it

        // erase, comment this section for debug
        Random r = ThreadLocalRandom.current();
        boolean[] unique = new boolean[81];
        for (int i = 0; i < 63 + r.nextInt(10); i++) {
            int j = r.nextInt(81);
            while (!unique[j]) {
                flat[j] = 0;
                unique[j] = true;
            }
        }

        return toGrid(flat);
    }


    private static void render(int[][] grid) {
        StringBuilder s = new StringBuilder();
        int i = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                String d;
                if (i == 0) d = "";
                else if (i % 27 == 0) d = "\n" + Dumpster.repeat(21, "-") + "\n";
                else if (i % 9 == 0) d = "\n";
                else if (i % 3 == 0) d = " | ";
                else d = " ";
                s.append(d);
                s.append(cell);
                i++;
            }
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        int newGame;
        do {
            int[][] board;

            // fake democracy
            int roll;
            do {
                board = fill();
                render(board);
                roll = GetNumber.scanInt("Re-roll board? (0: No) ");
            } while (roll != 0);

            int[][] gameBoard = board.clone();

            // game
            boolean solved = true;
            do {
                render(gameBoard);
                int x, y, v;
                Function<Number, Boolean> inRange = (Number i) -> (int) i > -1 && (int) i < 10;
                x = GetNumber.scan("Row? ", "1 - 9 only", inRange).intValue();
                y = GetNumber.scan("Column? ", "1 - 9 only", inRange).intValue();
                v = GetNumber.scan("Value? ", "1 - 9 only", inRange).intValue();
                if (board[x][y] > 0) System.out.println("Can't change preset values.");
                else {
                    gameBoard[x][y] = v;
                }
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) solved &= check(gameBoard);
                }
                System.out.println(solved);
            } while (!solved);
            System.out.println("Congrats! You solved the puzzle!");

            // end-game
            newGame = GetNumber.scanInt("New game? (0: No) ");
        } while (newGame != 0);
    }
}
