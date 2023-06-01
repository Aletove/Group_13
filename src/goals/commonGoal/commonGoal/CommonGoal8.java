package goals.commonGoal;
import game.*;
import goals.*;
import java.util.*;

public class CommonGoal8 extends Goal{
	private ArrayList<String> hasCompletedID;

	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonGoal8(int nPlayers) {
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
		return "Three columns each formed by 6 tiles of maximum three different types. One column can show the same or a different combination of another column";
	}


}