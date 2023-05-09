package objectives.commonObj;
import game.Player;
import game.Tile;
import objectives.*;
import java.util.ArrayList;

public class CommonObj4 extends Objective{
	private ArrayList<Player> hasCompleted;
	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonObj4(int nPlayers) {
		super(nPlayers);
		hasCompleted = new ArrayList<Player>();
		
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