public class Sudoku {

    // A 9-by-9 array representing a Sudoku board. A 0 means the square has
    // not been assigned yet.
    private int[][] board;
    
    /**
     * Precondition: board is a 9-by-9 array with only the numbers 0-9 as values.
     */ 
    public Sudoku(int[][] board) {
        this.board = board;
    }
    
    /**
     * Returns whether or not the Sudoku board is valid. Each row, column, or
     * 3-by-3 subsquare is valid if it contains the numbers 1-9 exactly once
     * with any number of unassigned squares.
     */
    public boolean isBoardValid() {
        // TODO: Implement this function.
        for (int i = 0; i < 9; i++) {
            if (!isSquareValid(i) || !isRowValid(i) || !isColumnValid(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns true if and only if row r is a valid Sudoku row.
     * Precondition: row is in the range [0, 9).
     */
    public boolean isRowValid(int row) {
        // TODO: Implement this function.
        if (isNumberSetValid(board[row])) {
            return true;
        }
        return false;
    }
    
    /**
     * Returns true if and only if column c is a valid Sudoku column.
     * Precondition: column is in the range [0, 9).
     */
    public boolean isColumnValid(int column) {
        // TODO: Implement this function.
        int[] testArray = new int [9];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col <board[row].length; col++) {
                if (col == column) {
                    testArray[row] = board[row][col];
                }
            }
        }
        if (isNumberSetValid(testArray)) {
            return true;
        }
        return false;
    }
    
    /**
     * Returns true if and only if 3-by-3 subsquare containing the entry at row, column
     * is a valid Sudoku subsquare.
     * Precondition: squareIndex is in the range [0, 9).
     */
    public boolean isSquareValid(int squareIndex) {
        // TODO: Implement this function.
        int starti = 0;
        int startj = 0;
        switch (squareIndex){
            case 0: 
                starti = 0;
                startj = 0;
                break;
            case 1:
                starti = 0;
                startj = 3;
                break;
            case 2: 
                starti = 0;
                startj = 6;
                break;
            case 3:
                starti = 3;
                startj = 0;
                break;
            case 4:
                starti = 3;
                startj = 3;
                break;
            case 5: 
                starti = 3;
                startj = 6;
                break;
            case 6: 
                starti = 6;
                startj = 0;
                break;
            case 7: 
                starti = 6;
                startj = 3;
                break;
            case 8: 
                starti = 6;
                startj = 6;
                break;
            
        }
        int[] testArray = new int[9];
        int count = 0;
        for (int row = starti; row < starti + 3; row++) {
            for (int col = startj; col < startj + 3; col++) {
                testArray[count] = board[row][col];
                count++;
            }
        }
        if (isNumberSetValid(testArray)) {
            return true;
        }
        return false;
    }

    /**
     * Returns whether the input set could constitute a valid row, column, or subsquare.
     */
    public static boolean isNumberSetValid(int[] set) {
        int[] testArray = new int[9];
        for(int i = 0; i < set.length; i++) {
            if (set[i] != 0) {
                testArray[set[i] - 1]++;
            }
        }
        for (int j = 0; j < testArray.length; j++) {
            if (testArray[j] == 2) {
                return false;
            }
        }
        return true;
    }
        
}
