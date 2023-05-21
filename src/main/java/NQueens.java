public class NQueens {
    private int[][] board;
    private int size;

    public NQueens(int size) {
        this.size = size;
        this.board = new int[size][size];
    }

    public void solve() {
        if (placeQueens(0)) {
            displayBoard();
        } else {
            System.out.println("Nu există soluție pentru această configurație.");
        }
    }

    private boolean placeQueens(int col) {
        if (col == size) {
            return true;
        }

        for (int row = 0; row < size; row++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;

                if (placeQueens(col + 1)) {
                    return true;
                }

                board[row][col] = 0; // undo the placement
            }
        }

        return false;
    }

    private boolean isSafe(int row, int col) {
        // Check if there is a queen in the same row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal
        for (int i = row, j = col; i < size && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size = 8; // Dimensiunea tablei de sah
        NQueens nQueens = new NQueens(size);
        nQueens.solve();
    }
}