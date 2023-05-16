package objectives.commonObj;
import game.*;
import objectives.*;
import java.util.*;

public class CommonObj3 extends Objective{
	private ArrayList<String> hasCompletedID;
	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonObj3(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<String>();
		
	}
	
	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		Set<Tile> tileTypes;
		int rows, cols;
		boolean isValidRow;
		boolean objectiveReached;
		shelf = currentPlayer.getShelf();
		tileTypes = new HashSet<>();
		rows = shelf.length;
        cols = shelf[0].length;
		isValidRow = true;
		objectiveReached = false;

        

        // Check each row
        for (int i = 0; i < rows; i++) {
        	// Check each column in the current row
    		for (int j = 0; j < cols; j++) {
    			Tile currentTile = grid[i][j];
    			tileTypes.add(currentTile);

    			// Check if the current row has more than three unique tile types
    			if (tileTypes.size() > 3) {
    				isValidRow = false;
    			}
    		}
            // Check if the current row has exactly five tiles and is valid
            if (&& cols == 5) {
                System.out.println("Found a valid row: " + i);
                objectiveReached = true;
            }
        }

        // Check if the objective was reached
        if (objectiveReached) {
            System.out.println("Objective reached: Four rows formed by 5 tiles of one, two, or three different types.");
        } else {
            System.out.println("Objective not reached.");
        }
	}

}