package tictactoe;

import tictactoe.models.BoardModel;
import tictactoe.models.GameModel;

public class App {
    public static void main(String[] args) {

        System.out.println("Bem vindo ao tic tac toe:");
        System.out.println("Player 1: X");
        System.out.println("Player 2: O");

        GameModel jogo = new GameModel();
        jogo.startGame();
    }
}