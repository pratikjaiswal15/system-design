package org.example;

public class Board {

    private int boardSize;
    private Symbol[][] grid;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.grid = new Symbol[boardSize][boardSize];

        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                grid[i][j] = null;
            }
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void displayBoard() {
        for (int i = 0; i < boardSize; i++) {
            for(int j = 0; j< boardSize; j++) {
                if(grid[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean placeMove(int row, int column, Symbol symbol) {
        if(grid[row][column] == null) {
            grid[row][column] = symbol;
            return true;
        }
        return false;
    }


    public boolean isWinningMove(int row, int column, Symbol symbol) {

        boolean win = true;

        for(int i=0; i<boardSize; i++) {
            if(grid[row][i] != symbol) {
                win = false;
                break;
            }
        }
        if(win) return true;

        win = true;

        for(int i=0; i<boardSize; i++) {
            if(grid[i][column]  != symbol) {
                win = false;
                break;
            }
        }

        if(win) return true;
        if(row == column) {
            win = true;

            for(int i=0; i<boardSize; i++) {
                if(grid[i][i] != symbol) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }

        if(row + column == boardSize-1) {
            win = true;
            for(int i=0; i<boardSize; i++) {
                if(grid[i][boardSize-i-1] != symbol) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }

        return false;
    }

    public boolean isFull() {

        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                if(grid[i][j] == null) {
                    return false;
                }
            }
        }

        return true;
    }
}
