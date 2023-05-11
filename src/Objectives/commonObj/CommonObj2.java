package objectives.commonObj;
import game.*;
import objectives.*;
import java.util.ArrayList;

public class CommonObj2 implements Objective{
	private ArrayList<Player> hasCompleted;
	private ArrayList<Integer> points;
	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonObj2(int nPlayers) {
		hasCompleted = new ArrayList<Player>();
		points=new ArrayList<Integer>();
		//assign to points in each position the specific amount, based on the number of players.
		for(int i = 1; i <= nPlayers; i++) {
			points.add(i-1*2);
		}
		
	}
	/**Method to verify the accomplishment of the common objective
	 * Card number 2
	 */
	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		shelf = currentPlayer.getShelf();
		
		if(shelf[0][0].getType() == shelf[shelf.length][0].getType()) {
			if(shelf[shelf.length][0].getType() == shelf[0][shelf[0].length].getType()) {
				if(shelf[0][0].getType()==shelf[shelf.length][shelf[shelf.length].length].getType()) {
					
				}
			}
			
		}
		
		return 0;
	}
	

}