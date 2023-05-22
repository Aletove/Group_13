package goals.commonGoal;
import game.*;
import goals.*;
import java.util.*;

public class CommonGoal3 extends Goal{
	private ArrayList<String> hasCompletedID;

	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonGoal3(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<String>();
		
	}
	
	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		HashSet<Tile> tileTypes;
		int rows, cols, validRows = 0;
		boolean isValidRow;
		Tile currentTile;
		shelf = currentPlayer.getShelf();
		rows = shelf.length;
        cols = shelf[0].length;
		isValidRow = true;

        

        // Check each row
        for (int i = 0; i < rows; i++) {
        	//After every row reset of the hashset and the flag isValidRow
        	tileTypes = new HashSet<>();
        	isValidRow = true;
        	// Check each column in the current row
    		for (int j = 0; j < cols && isValidRow; j++) {
    			currentTile = shelf[i][j];
    			if(!currentTile.equals(Tile.EMPTY) || tileTypes.size() < 4) {//If the row has one or more empty tiles, is not valid. 
    				tileTypes.add(currentTile);
    			}
    			else {
    				isValidRow = false;
    			}
    		}
    		if(isValidRow) {
    			validRows ++;
    		}
            
        }
        
        // Check if the goal was reached
        if (validRows > 3) {
        	if(super.notCompletedYet(currentPlayer, hasCompletedID)) {
        		return super.pointsMethod();
        	}
            System.out.println("Goal reached: Four or more rows formed by 5 tiles of one, two, or three different types.");
            
        }
        return 0;
	}

}