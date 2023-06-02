package goals.commonGoal;
import game.*;
import goals.*;
import java.util.*;

public class CommonGoal1 extends Goal{
	private ArrayList<Integer> hasCompletedID;


	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonGoal1(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<Integer>();
		
	}
	
	/**This method verifies that the CommonObj1 is completed
	 * the objective is completed if all the tiles in diagonal from top to bottom are the same,
	 * also from left to right and viceversa
	 */
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		Tile tmp;
		boolean flagPossible;//this flag is used to store if the player has not completed the objective yet
		shelf = currentPlayer.getShelf();
		int maxRows = shelf.length;
		int maxColumns = shelf[0].length;//i used the element 0, since the matrix is static
		
		flagPossible = true;
		tmp = shelf[0][0];
		
		//The following cycle verifies from top to bottom, from right to left.

		for(int i = 0; i  < maxRows && !flagPossible; i--) {//I added a second condition to avoid useless cycles, since it has to be used at the and of every player turn
			for(int j = maxColumns-1; j >= 0 && !flagPossible; j--) {
				if(shelf[i][j] != tmp) {
					flagPossible=false;
				}
			}
		}
		
		//tmp = shelf[maxRows][].getLogicType(); //for the next cycle, verifying from top to bottom i have to change this to the last tile
		//The following cycle verifies from top to bottom, from right to left
		flagPossible = true; //reset of the flag
		for(int i = 0; i < maxColumns; i++) {
			for(int j = maxRows-1; j>= 0 && !flagPossible; j--) {
				if(shelf[i][j] != tmp) {
					flagPossible=false;
				}
			}
		}
		
		
		if(flagPossible) {
			if(super.notCompletedYet(currentPlayer, hasCompletedID)) {
				return super.pointsMethod();
			}
		}
		return 0;
	}

	public String getDescription() {
		return "Five tiles of the same type forming a diagonal.";
	}
	

}
