package objectives.commonObj;
import game.*;
import objectives.*;
import java.util.ArrayList;

public class CommonObj3 implements Objective{
	private Player[] hasCompleted;
	private ArrayList<Integer> points;
	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonObj3(int nPlayers) {
		hasCompleted = new Player[nPlayers];
		points=new ArrayList<Integer>();
		//assign to points in each position the specific amount, based on the number of players.
		for(int i = 1; i <= nPlayers; i++) {
			points.add(i-1*2);
		}
		
	}
	/**Method to verify the accomplishment of the common objective
	 * Card number 3
	 */
	@Override
	public int isCompleted(Player currentPlayer) {
		Shelf[] shelf;
		shelf = currentPlayer.getShelf();
		for(int i = 0; i < shelf.length; i++) {
			for(int j = 0; j < shelf[i].length; j++) {
				
			}
			
		}
		
		return 0;
	}
	

}