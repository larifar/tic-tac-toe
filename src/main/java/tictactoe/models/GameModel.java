package tictactoe.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameModel {
    private List<PlayerModel> playersList;
    private final BoardModel board = new BoardModel();
    private PlayerModel currentPlayer;
    private PlayerModel winner = null;

    private final Scanner scan = new Scanner(System.in);

    private final RulesModel rules = new RulesModel();

    public void startGame(){
        do {
            currentTurn();
            if (rules.gameWinner(currentPlayer)){
                this.winner = this.currentPlayer;
            }
            changeTurn();
        } while (winner == null && !board.getPositions().isEmpty());
        if (board.getPositions().isEmpty()){
            System.out.println("Empate! Não há mais posições disponiveis!");
        } else{
            System.out.println("Jogador " + winner.getNumberPlayer() + " venceu!!!");
        }
        board.showBoard();
        System.out.println("Fim de jogo");
    }

    public GameModel(){
        createPlayers();
        this.currentPlayer = this.playersList.get(0);
    }


    private void createPlayers(){
        this.playersList = new ArrayList<>();
        PlayerModel player1 = new PlayerModel(1, "X");
        this.playersList.add(player1);
        PlayerModel player2= new PlayerModel(2, "O");
        this.playersList.add(player2);
    }

    private void changeTurn(){
        var oldPlayer = currentPlayer.getNumberPlayer();
        if(oldPlayer == 1){
            currentPlayer = playersList.get(1);
        } else if (oldPlayer == 2){
            currentPlayer = playersList.get(0);
        }
    }

    private boolean makeMove(String position){
        var player = currentPlayer;
        return board.occupyPosition(position, player);
    }

    private void currentTurn(){
        boolean b;
        String position;
        do {
            System.out.println("Vez do jogador " + currentPlayer.getNumberPlayer());
            board.showBoard();
            System.out.println("Posições disponiveis: " + board.getPositions());
            position = playerChoosePosition();
            b = makeMove(position);
        } while (!b);
        currentPlayer.addPosition(position);
    }

    private String playerChoosePosition(){
        System.out.println("Onde você quer posicionar? ");
        return scan.nextLine();
    }
}
