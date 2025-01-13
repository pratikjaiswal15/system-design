package org.example;

import java.util.Scanner;

public class Game {

    private Player[] players = new Player[2];
    private Board board;

    private int currentPlayerIndex = 0;

    public Game(Player player1, Player player2, int boardSize) {

        players[0] = player1;
        players[1] = player2;

        board = new Board(boardSize);
    }

    public void startGame() {

        boolean gameWon = false;
        boolean draw = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameWon && !draw) {
            Player currentPlayer = players[currentPlayerIndex];
            board.displayBoard();

            System.out.println(currentPlayer.getName() + "'s turn. Symbol - " + currentPlayer.getSymbol() );
            int row, column;
            boolean validMove = false;
            do {

                System.out.println("Enter row and column between 0  to " + (board.getBoardSize() -1));
                row = scanner.nextInt();
                column = scanner.nextInt();

                if(row < 0 || row >=board.getBoardSize() || column < 0 || column >= board.getBoardSize()) {
                    System.out.println("Invalid row or column.");
                } else if(!board.placeMove(row, column, currentPlayer.getSymbol())) {
                    System.out.println("Error - Cell is already occupied");
                } else {
                    validMove = true;
                }
            } while (!validMove);

            gameWon = board.isWinningMove(row, column, currentPlayer.getSymbol());

            if(gameWon) {
                board.displayBoard();
                System.out.println(currentPlayer.getName() + " wins");
            } else if (board.isFull()) {
                board.displayBoard();
                System.out.println("Match draw");
                draw = true;
            } else {
                switchPlayer();
            }
        }
        scanner.close();
    }

    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
    }
}
