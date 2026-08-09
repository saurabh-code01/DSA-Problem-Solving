class Solution {
    public boolean issafe(char[][] board, int row, int col) {
        char val = board[row][col];
        if (val == '.') return true; // skip empty cells

        // check vertically 
        for (int i = 0; i < board.length; i++) {
            if (i != row && board[i][col] == val) {
                return false;
            }
        }

        // check horizontally
        for (int j = 0; j < board.length; j++) {
            if (j != col && board[row][j] == val) {
                return false;
            }
        }

        // check the 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if ((i != row || j != col) && board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solvsudoku(char[][] board, int row, int col) {
        // base case: reached last cell
        if (row == board.length - 1 && col == board.length - 1) {
            return issafe(board, row, col);
        }

        int nextr = row;
        int nextc = col + 1;
        if (col == board.length - 1) {
            nextr = row + 1;
            nextc = 0;
        }

        if (board[row][col] != '.') {
            if (!issafe(board, row, col)) {
                return false;
            }
        }

        return solvsudoku(board, nextr, nextc);
    }

    public boolean isValidSudoku(char[][] board) {
        return solvsudoku(board, 0, 0);
    }
}
