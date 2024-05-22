package tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class PlayerModel {
    private int numberPlayer;
    private String pieceType;

    private List<PositionModel> positions;

    public PlayerModel(int numberPlayer, String pieceType) {
        this.numberPlayer = numberPlayer;
        this.pieceType = pieceType;
        this.positions = new ArrayList<>();
    }

    public int getNumberPlayer() {
        return numberPlayer;
    }

    public String getPieceType() {
        return pieceType;
    }

    public List<PositionModel> getPositions(){
        return positions;
    }

    public void addPosition(String p){
        var position = PositionModel.valueOf(p);
        positions.add(position);
    }
}
