import java.util.*;
public class SudokuSolver {
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, column, num)) {
                            board[row][column] = num;
                            if (solveSudoku(board)) return true;
                            board[row][column] = 0;
                        }
                    }
                    return false; 
                }
            }
        }
        return true;
    }
    private static boolean isValid(int[][] board, int row, int column, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][column] == num ||
                board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] == num)
                return false;
        }
        return true;
    }
    public static void printBoard(int[][] board) {
        System.out.println("Solved Sudoku:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                if (j < 8) System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[9][9];
        System.out.println("Enter the Sudoku board row by row (0 for empty cells):");

        for (int i = 0; i < 9; i++) {
            String[] row = scanner.nextLine().trim().split("\\s+");
            if (row.length != 9) {
                System.out.println("Each row must have exactly 9 numbers.");
                return;
            }
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }
        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists for the given Sudoku.");
        }
    }
}
