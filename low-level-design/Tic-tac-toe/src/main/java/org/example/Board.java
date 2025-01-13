package org.example;

// Board Class
class Board {
    private int size;
    private Symbol[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Symbol[size][size];  // Use Symbol enum instead of char

        // Initialize the grid with null (no symbol placed)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = null;  // null represents an empty cell
            }
        }
    }

    public int getSize() {
        return size;
    }

    // Displays the current state of the board
    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) {
                    System.out.print("- ");  // Empty cells are represented by '-'
                } else {
                    System.out.print(grid[i][j] + " ");  // Display Symbol (X or O)
                }
            }
            System.out.println();
        }
    }

    // Places the symbol on the board
    public boolean placeSymbol(int row, int col, Symbol symbol) {
        if (grid[row][col] == null) {  // Check if the cell is empty
            grid[row][col] = symbol;   // Place the Symbol (X or O)
            return true;
        }
        return false;  // Invalid move if cell is already occupied
    }

    // Checks if the board is full
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) {
                    return false;  // If any cell is empty, board is not full
                }
            }
        }
        return true;
    }

    // Checks if the move is a winning move
    public boolean isWinningMove(int row, int col, Symbol symbol) {
        // Checking row
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (grid[row][i] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Checking column
        win = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][col] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Checking first diagonal
        if (row == col) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (grid[i][i] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Checking second diagonal
        if (row + col == size - 1) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (grid[i][size - 1 - i] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        return false;
    }
}
