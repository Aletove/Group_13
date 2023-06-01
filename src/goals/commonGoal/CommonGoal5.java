package goals.commonGoal;
import game.*;
import goals.*;
import java.util.*;

public class CommonGoal5 extends Goal{
	private ArrayList<String> hasCompletedID;

	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonGoal5(int nPlayers) {
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
	

}