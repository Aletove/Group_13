package goals.commonGoal;
import game.*;
import goals.*;
import java.util.*;

public class CommonGoal5 extends Goal{
	private ArrayList<Integer> hasCompletedID;
	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @author Giuseppe Luisi
	 * @param nPlayers
	 */
	public CommonGoal5(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<Integer>();
		
	}
	
	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		HashSet<Tile> tileTypes;
		int rows, cols, validCols = 0;
		boolean isValidCol;
		Tile currentTile;
		shelf = currentPlayer.getShelf();
		cols = shelf.length; 
		rows = shelf[0].length;
		isValidCol = true;

		//check each column
		for(int i = 0; i < cols; i++) {
			tileTypes = new HashSet<Tile>();
			isValidCol = true;
			//check each row in the current column
			for(int j = 0; j < rows && isValidCol; j++) {
				currentTile = shelf[i][j];
				if(!currentTile.equals(Tile.EMPTY) || tileTypes.size()<7) {//If the row has one or more empty tiles, is not valid.
					tileTypes.add(currentTile);
				}else {
					isValidCol = false;
				}
				
			}
			if(isValidCol && tileTypes.size()==6) {
				validCols++;
			}
			
		}
		
		//check if the goal was reached
		if(validCols > 1) {
			if(super.notCompletedYet(currentPlayer, hasCompletedID)) {
				return super.pointsMethod();
			}
			System.out.println("Goal reached");
		}
		return 0;
	}
	

}
