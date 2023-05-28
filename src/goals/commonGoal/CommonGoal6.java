package goals.commonGoal;
import game.*;
import goals.*;
import java.util.*;

public class CommonGoal6 extends Goal{
	private ArrayList<Integer> hasCompletedID;
	private static final int[][] SQUAREDIRECTIONS = {// Directions: down, right, diagonal right. top is excluded
				{0, 1},
				{1, 0},
				{1, 1}
				};

	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonGoal6(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<Integer>();
		
	}
	
	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		int rows, cols;
		Set<String> foundGroups;
		shelf = currentPlayer.getShelf();
		foundGroups = new HashSet<>();
		rows = shelf.length;
		cols = shelf[0].length;
		 // Iterate through all the cells of the shelf
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               
            	Tile targetType = shelf[i][j]; // Tile type that we are looking for
                    
            	Set<String> currentGroup = new HashSet<>(); // Current group of Tiles
                    
            	// Executes findAdjacent to find the group of adjacent tiles of the same type forming a 2x2 square
                findAdjacent(shelf, i, j, targetType, currentGroup);
                // If the group is formed by four tiles, we store it in the set foundGroups
                if (currentGroup.size() == 4) {
                	foundGroups.addAll(currentGroup);
                   	System.out.println("Group found: " + currentGroup);
                }
            }
        }
        
        if(foundGroups.size() >= 2) {
        	if(super.notCompletedYet(currentPlayer, hasCompletedID)) {
        		return super.pointsMethod();
        	}
        }
        
        return 0;
    }
	
	
	/**
	 * this method uses an implementation of Depth - first research to find groups of adjacent tiles
	 * @param grid the shelf used in the method
	 * @param row x coordinate of the tile
	 * @param col y coordinate of the tile
	 * @param targetType (e.g. Tile.CATS)
	 * @param currentGroup Set of strings containing the current group of tiles
	 */
	private void findAdjacent(Tile[][] grid, int row, int col, Tile targetType, Set<String> currentGroup) {
		int rows = grid.length;
		int cols = grid[0].length;
	        
		// Boundary and tile type check
		if (row < 0 || row >= rows || col < 0 || col >= cols || !grid[row][col].equals(targetType) || currentGroup.size() > 4) {
			return;
		}
	        
		String position = row + "-" + col; //the format of the position is the same in all the groups
	        
		// Check if the tile has already been found
		if (currentGroup.contains(position)) {
			return;
		}
		
		currentGroup.add(position);
	        
		// Explore adjacent tiles
		for (int[] direction : SQUAREDIRECTIONS) {
			int newRow = row + direction[0];
			int newCol = col + direction[1];
	            
			findAdjacent(grid, newRow, newCol, targetType, currentGroup);
		}
	}

	

}