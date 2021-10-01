public class SudokuDriver {

    public static void main(String[] args) {
        int[][] board =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0},  // empty row
             {1, 0, 0, 0, 0, 0, 0, 0, 0},  // incomplete rows
             {4, 0, 3, 0, 2, 0, 1, 0, 0},
             {8, 6, 7, 4, 1, 2, 5, 9, 3},  // complete row
             {0, 0, 8, 0, 0, 8, 0, 0, 0},  // incomplete but invalid
             {8, 6, 2, 4, 1, 2, 5, 9, 3},  // complete but invalid
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        Sudoku sudoku = new Sudoku(board);
        System.out.println("Row 0: Expected true, actual " + sudoku.isRowValid(0));
        System.out.println("Row 1: Expected true, actual " + sudoku.isRowValid(1));
        System.out.println("Row 2: Expected true, actual " + sudoku.isRowValid(2));
        System.out.println("Row 3: Expected true, actual " + sudoku.isRowValid(3));
        System.out.println("Row 4: Expected false, actual " + sudoku.isRowValid(4));
        System.out.println("Row 5: Expected false, actual " + sudoku.isRowValid(5));
        
        

        // Add verification for isColumnValid
        System.out.println("Column 0: Expected false, actual " + sudoku.isColumnValid(0));
        System.out.println("Column 1: Expected false, actual " + sudoku.isColumnValid(1));
        System.out.println("Column 2: Expected true, actual " + sudoku.isColumnValid(2));
        System.out.println("Column 3: Expected false, actual " + sudoku.isColumnValid(3));
        System.out.println("Column 4: Expected false, actual " + sudoku.isColumnValid(4));
        System.out.println("Column 5: Expected false, actual " + sudoku.isColumnValid(5));
        System.out.println("Column 6: Expected false, actual " + sudoku.isColumnValid(6));
        System.out.println("Column 7: Expected false, actual " + sudoku.isColumnValid(7));
        System.out.println("Column 8: Expected false, actual " + sudoku.isColumnValid(8));
        
        // Add verification for isSquareValid
        System.out.println("Square 0: Expected true, actual " + sudoku.isSquareValid(0));
        System.out.println("Square 1: Expected true, actual " + sudoku.isSquareValid(1));
        System.out.println("Square 2: Expected true, actual " + sudoku.isSquareValid(2));
        System.out.println("Square 3: Expected false, actual " + sudoku.isSquareValid(3));
        System.out.println("Square 4: Expected false, actual " + sudoku.isSquareValid(4));
        System.out.println("Square 5: Expected false, actual " + sudoku.isSquareValid(5));
        
        System.out.println("Board: Expected false, actual " + sudoku.isBoardValid());
    }
}
