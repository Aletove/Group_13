package goals.commonGoal;

import game.*;
import goals.*;
import java.util.*;


public class CommonGoal4 extends Goal {

    private ArrayList<Integer> hasCompletedID;
    private static final int[][] DIRECTIONS = {// Directions: top, down, left, right
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    /**
     * The constructor generates the array list points, based on the number of
     * players.
     *
     * @param nPlayers
     */
    public CommonGoal4(int nPlayers) {
        super(nPlayers);
        hasCompletedID = new ArrayList<Integer>();

    }

    @Override
    public int isCompleted(Player currentPlayer) {
        Tile[][] shelf;
        int rows, cols;
        HashSet<String> foundGroups;
        HashSet<String> currentGroup;
        shelf = currentPlayer.getShelf();
        rows = shelf.length;
        cols = shelf[0].length;
        currentGroup = new HashSet<String>();
        foundGroups = new HashSet<String>();

        // Iterate through all the cells of the shelf
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                Tile targetType = shelf[i][j]; // Tile type that we are looking for

                currentGroup.clear(); // Clears the current group of Tiles from all added elements before

                // Executes findAdjacent to find the group of adjacent tiles of the same type
                findAdjacent(shelf, i, j, targetType, currentGroup);
                // If the group is formed by four tiles, we store it in the set foundGroups
                if (currentGroup.size() == 4) {
                    foundGroups.addAll(currentGroup);
                    //System.out.println("Group found: " + currentGroup);
                }
            }
        }

        if (foundGroups.size() > 5) {
            if (super.notCompletedYet(currentPlayer, hasCompletedID)) {
                return super.pointsMethod();
            }
        }

        return 0;
    }

    /**
     * This method uses an implementation of Depth - first research to find
     * groups of adjacent tiles
     *
     * @param grid the shelf used in the method
     * @param row x coordinate of the tile
     * @param col y coordinate of the tile
     * @param targetType (e.g. Tile.CATS)
     * @param currentGroup Set of strings containing the current group of tiles
     */
    private void findAdjacent(Tile[][] grid, int row, int col, Tile targetType, Set<String> currentGroup) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Checking the boundaries of the matrix and the target type
        if (row < 0 || row >= rows || col < 0 || col >= cols || !grid[row][col].equals(targetType)) {
            return;
        }

        String position = row + "-" + col; // The format of the position in the hash set

        if (currentGroup.contains(position)) {// Checks if the tile has already been found
            return;
        }

        currentGroup.add(position);

        // Explore adjacent tiles using the matrix DIRECTIONS
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            findAdjacent(grid, newRow, newCol, targetType, currentGroup);
        }
    }

}