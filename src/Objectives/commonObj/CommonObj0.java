package objectives.commonObj;
import game.*;
import objectives.*;
import java.util.*;

public class CommonObj0 extends Objective{
	private ArrayList<String> hasCompletedID;
	private static final int[][] DIRECTIONS = {{1, 0}, {0, -1}, {0, 1}}; // Directions: down, left, right. the top is exclduded

	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonObj0(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<String>();
		
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
                    
            	// Executes findAdjacent to find the group of adjacent tiles of the same type
                findAdjacent(shelf, i, j, targetType, currentGroup);
                // If the group is formed by two tiles, we store it in the set foundGroups
                if (currentGroup.size() == 2) {
                	foundGroups.addAll(currentGroup);
                   	System.out.println("Group found: " + currentGroup);
                }
            }
        }
        
        if(foundGroups.size() >= 6) {
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
		if (row < 0 || row >= rows || col < 0 || col >= cols || !grid[row][col].equals(targetType) || currentGroup.size() > 2) {
			return;
		}
	        
		String position = row + "-" + col; //the format of the position is the same in all the groups
	        
		// Check if the tile has already been found
		if (currentGroup.contains(position)) {
			return;
		}
		
		currentGroup.add(position);
	        
		// Explore adjacent tiles
		for (int[] direction : DIRECTIONS) {
			int newRow = row + direction[0];
			int newCol = col + direction[1];
	            
			findAdjacent(grid, newRow, newCol, targetType, currentGroup);
		}
	}

	

}