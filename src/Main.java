import java.util.HashSet;

public class Main {

    // Method to validate entire Sudoku board
    public static boolean isValidSudoku(int[][] board) {

        // Check all rows and columns
        for (int i = 0; i < 9; i++) {

            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                // Row validation
                if (rowSet.contains(board[i][j])) {
                    System.out.println("Duplicate found in row " + i);
                    return false;
                }
                rowSet.add(board[i][j]);

                // Column validation
                if (colSet.contains(board[j][i])) {
                    System.out.println("Duplicate found in column " + i);
                    return false;
                }
                colSet.add(board[j][i]);
            }
        }

        // Check 3x3 sub-grids
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {

                HashSet<Integer> boxSet = new HashSet<>();

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        int value = board[row + i][col + j];

                        if (boxSet.contains(value)) {
                            System.out.println("Duplicate found in 3x3 box starting at (" + row + "," + col + ")");
                            return false;
                        }
                        boxSet.add(value);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // Predefined Sudoku board
        int[][] board = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
        };

        // Display board
        System.out.println("Sudoku Board:");
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Validate Sudoku
        if (isValidSudoku(board)) {
            System.out.println("\n✅ Valid Sudoku Solution!");
        } else {
            System.out.println("\n❌ Invalid Sudoku!");
        }
    }
}
