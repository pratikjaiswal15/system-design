package org.example;

// Main Class to Run the Game
public class TicTacToe {
    public static void main(String[] args) {
        Player player1 = new Player("Alice", Symbol.X);
        Player player2 = new Player("Bob", Symbol.O);

        Game game = new Game(player1, player2, 3);
        game.startGame();
    }
}

