package objectives.commonObj;
import game.Player;
import game.Tile;
import objectives.*;
import java.util.ArrayList;

public class CommonObj1 extends Objective{
	private ArrayList<Player> hasCompleted;
	
	
	/**The constructor generates the array list hasCompleted,
	 * to store the players that have already completed the common objective
	 * @param nPlayers
	 */
	public CommonObj1(int nPlayers) {
		super(nPlayers);
		hasCompleted = new ArrayList<Player>();
		
		
	}
	
	
	/**This method verifies that the CommonObj1 is completed
	 * the objective is completed if all the tiles in diagonal from top to bottom are the same,
	 * also from left to right and viceversa
	 */
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		String tmp;
		boolean flagPossible;//this flag is used to store if the player has not completed the objective yet
		shelf = currentPlayer.getShelf();
		int maxRows = shelf.length;
		int maxColumns = shelf[0].length;//i used the element 0, since the matrix is static
		
		flagPossible = true;
		tmp = shelf[0][0].getLogicType();
		
		//The following cycle verifies from top to bottom, from right to left.
		//the tile in the top left corner is excluded from the cycle, since it is the temporary logic type extracted from shelf
		for(int i = 0; i  < maxRows && flagPossible; i--) {//I added a second condition to avoid useless cycles, since it has to be used at the and of every player turn
			for(int j = maxColumns; j >= 0 && flagPossible; j--) {
				if(i == (j-1)) {
					if(!shelf[i][j].getLogicType().equals(tmp)) {
						flagPossible=false;
					}
				}
				
			}
		}
		
		//tmp = shelf[maxRows][].getLogicType(); //for the next cycle, verifying from top to bottom i have to change this to the last tile
		//The following cycle verifies from top to bottom, from right to left
		flagPossible = true; //reset of the flag
		for(int i = 0; i < maxColumns; i++) {
			
		}
		
		if(flagPossible) {
			if(super.notCompletedYet(currentPlayer, hasCompleted)) {
				return super.pointsMethod();
			}
		}
		return 0;
	}
	

}