package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Leetcode. 348. Design Tic-Tac-Toe
 */
public class TicTacToe {
        
    private int[][] board;
    private int win = 0;
    private int n = 0;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        pr(board);
        int maxLen = Math.max(Math.max(row + 1, n - row), Math.max(col + 1, n - col));
        int h = 1;
        int v = 1;
        int dl = 1;
        int dr = 1;
        for (int i = 1; i < maxLen; i++) {
            int minusRow = row - i;
            int plusRow  = row + i;
            int minusCol = col - i;
            int plusCol  = col + i;
            if (minusRow >= 0 && minusCol >= 0)
                dl += (board[minusRow][minusCol] == player)     ? 1 : 0;
            if (plusRow < n && plusCol < n)
                dl += (board[plusRow][plusCol] == player)       ? 1 : 0;
            if (plusRow < n && minusCol >= 0)
                dr += (board[plusRow][minusCol] == player)      ? 1 : 0;
            if (minusRow >= 0 && plusCol < n)
                dr += (board[minusRow][plusCol] == player)      ? 1 : 0;
            if (minusCol >= 0)
                h += (board[row][minusCol] == player)           ? 1 : 0;
            if (plusCol < n)
                h += (board[row][plusCol] == player)            ? 1 : 0;
            if (minusRow >= 0)
                v += (board[minusRow][col] == player)           ? 1 : 0;
            if (plusRow < n)
                v += (board[plusRow][col] == player)            ? 1 : 0;
        }
        if (h == n || v == n || dl == n || dr == n) {
            win = player;
        }
        return win;
    }

    private static void pr(int[][] arr) {
        for (var a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        var t = new TicTacToe(3);
        System.out.println(t.move(0, 0, 1));
        System.out.println(t.move(0, 2, 2));
        System.out.println(t.move(2, 2, 1));
        System.out.println(t.move(1, 1, 2));
        System.out.println(t.move(2, 0, 1));
        System.out.println(t.move(1, 0, 2));
        System.out.println(t.move(2, 1, 1));
    }

}
