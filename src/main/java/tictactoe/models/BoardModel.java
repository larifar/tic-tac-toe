package tictactoe.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BoardModel {
    private List<String> positions;
    
    public BoardModel(){
        var list = new ArrayList<String>();
        for (PositionModel enumConstant : PositionModel.class.getEnumConstants()) {
            list.add(enumConstant.name());
        }
        this.positions = list;
    }

    public boolean isPositionAvailable(String position){
        return position != null && positions.contains(position);
    }

    public boolean occupyPosition(String position, PlayerModel player){
        if (isPositionAvailable(position)){
            int index = positions.indexOf(position);
            this.positions.set(index, player.getPieceType());
            return true;
        } else {
            return false;
        }
    }

    public List<String> getPositions() {
        return positions.stream()
                .filter(s -> !Objects.equals(s, "O"))
                .filter(s -> !Objects.equals(s, "X"))
                .collect(Collectors.toList());
    }

    public void showBoard(){
        System.out.printf("""
                %s | %s | %s
              _________________
                %s | %s | %s
              _________________
                %s | %s | %s
                """,
                positions.get(0), positions.get(1), positions.get(2),
                positions.get(3), positions.get(4), positions.get(5),
                positions.get(6), positions.get(7), positions.get(8));
    }
}
