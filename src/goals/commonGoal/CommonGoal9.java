package goals.commonGoal;

import game.*;
import goals.*;
import java.util.*;

public class CommonGoal9 extends Goal {

    private static final int[][] XDIRECTIONS = {//Directions to use, to search for a X shaped element, assuming the first is the center.
        {-1, -1},
        {-1, 1},
        {1, -1},
        {1, 1}
    };
    private ArrayList<Integer> hasCompletedID;

    /**
     * The constructor generates the array list points, based on the number of
     * players.
     *
     * @param nPlayers
     */
    public CommonGoal9(int nPlayers) {
        super(nPlayers);
        hasCompletedID = new ArrayList<Integer>();

    }

    @Override
    public int isCompleted(Player currentPlayer) {
        Tile[][] shelf;
        shelf = currentPlayer.getShelf();
        int rows = shelf.length;
        int cols = shelf[0].length;
        int count = 0;

        // Iterate through all the cells of the shelf
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //Reset of counter to 0 for new check 
                count = 0;
                
                Tile targetType = shelf[i][j]; // Tile type that we are looking for
                if (!targetType.equals(Tile.EMPTY)) {// The tile type has to be different from EMPTY
                    
                    for (int[] direction : XDIRECTIONS) {
                        int newRow = i + direction[0];
                        int newCol = j + direction[1];
                        if (newRow >= 0 && newRow < 6 && newCol >= 0 && newCol < 5) {
                            if (targetType.equals(shelf[newRow][newCol])) {
                                count++;

                            }
                        }
                    }
                    // Checking if exactly four tiles have been counted and not five, since the middle one is surely correct and not counted.
                    if (count == 4) {
                        if (super.notCompletedYet(currentPlayer, hasCompletedID)) {
                            return super.pointsMethod();
                        }
                    }
                }
            }
        }
        return 0;
    }

}

