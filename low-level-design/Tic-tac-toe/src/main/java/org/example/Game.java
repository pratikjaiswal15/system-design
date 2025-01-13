package org.example;

import java.util.Scanner;

// Game Class
class Game {
    private Player[] players = new Player[2];
    private int currentPlayerIndex = 0;
    private Board board;

    public Game(Player player1, Player player2, int boardSize) {
        players[0] = player1;
        players[1] = player2;
        board = new Board(boardSize);
    }

    // Starts the game
    public void startGame() {
        boolean gameWon = false;
        boolean draw = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameWon && !draw) {
            Player currentPlayer = players[currentPlayerIndex];
            board.displayBoard();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + "):");

            int row, col;
            boolean validMove = false;

            // Loop until a valid move is provided
            do {
                System.out.println("Enter row and column (0 to " + (board.getSize() - 1) + "): ");
                row = scanner.nextInt();
                col = scanner.nextInt();

                // Check if row and column are within bounds
                if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
                    System.out.println("Error: Invalid row or column. Please enter values between 0 and " + (board.getSize() - 1) + ".");
                } else if (!board.placeSymbol(row, col, currentPlayer.getSymbol())) {
                    // Check if the position is already occupied
                    System.out.println("Error: Cell is already occupied. Try again.");
                } else {
                    validMove = true;  // Valid move made
                }
            } while (!validMove);

            // Check if the move results in a win
            gameWon = board.isWinningMove(row, col, currentPlayer.getSymbol());
            if (gameWon) {
                board.displayBoard();
                System.out.println(currentPlayer.getName() + " wins!");
            } else if (board.isFull()) {
                // Check if the board is full (i.e., a draw)
                board.displayBoard();
                System.out.println("It's a draw!");
                draw = true;
            } else {
                // Switch players if the game is not over
                switchPlayer();
            }
        }
        scanner.close();
    }

    // Switches between players
    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
    }
}
