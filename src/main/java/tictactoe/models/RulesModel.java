package tictactoe.models;

import java.util.*;

public class RulesModel {

    private final List<List<PositionModel>> positionsWinner;

    public RulesModel(){
        this.positionsWinner = new ArrayList<>();
        initializeWinningPositions();
    }

    private void initializeWinningPositions() {
        positionsWinner.add(Arrays.asList(PositionModel.A, PositionModel.B, PositionModel.C));
        positionsWinner.add(Arrays.asList(PositionModel.D, PositionModel.E, PositionModel.F));
        positionsWinner.add(Arrays.asList(PositionModel.G, PositionModel.H, PositionModel.Y));
        positionsWinner.add(Arrays.asList(PositionModel.A, PositionModel.D, PositionModel.G));
        positionsWinner.add(Arrays.asList(PositionModel.B, PositionModel.E, PositionModel.H));
        positionsWinner.add(Arrays.asList(PositionModel.C, PositionModel.F, PositionModel.Y));
        positionsWinner.add(Arrays.asList(PositionModel.A, PositionModel.E, PositionModel.Y));
        positionsWinner.add(Arrays.asList(PositionModel.C, PositionModel.E, PositionModel.G));
    }

    public boolean gameWinner(PlayerModel player){
        List<PositionModel> positions = player.getPositions();
        return comparePositions(positions);
    }

    private boolean comparePositions(List<PositionModel> positions){
        Set<PositionModel> playerPositionSet = new HashSet<>(positions);
        for (List<PositionModel> winningCombination : this.positionsWinner) {
            if (playerPositionSet.containsAll(winningCombination)) {
                return true;
            }
        }
        return false;
    }

}
