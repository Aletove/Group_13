package goals.commonGoal;
import game.*;
import goals.*;
import java.util.*;

public class CommonGoal6 extends Goal{
	private ArrayList<String> hasCompletedID;

	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonGoal6(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<String>();
		
	}
	
	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		shelf = currentPlayer.getShelf();

		
		for(int i = shelf.length; i > 0; i--) {
			for(int j = shelf[i].length; j > 0; i--) {
				
			}
		}
		return 0;
	}
	public String getDescription() {
		return "Two groups each containing 4 tiles of the same type in a 2x2 square. The tiles of one square can be different from those of the other square";
	}

}