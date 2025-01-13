package org.example;

public class TicTacToe {

    public static void main(String[] args) {

        Player player1 = new Player("Pratik", Symbol.X);
        Player player2 = new Player("Opp", Symbol.O);

        Game game = new Game(player1, player2, 3);
        game.startGame();
    }
}
