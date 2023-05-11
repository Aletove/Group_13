package objectives.commonObj;
import game.Player;
import objectives.*;
import java.util.ArrayList;

public class CommonObj10 implements Objective{
	private Player[] hasCompleted;
	private ArrayList<Integer> points;
	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonObj10(int nPlayers) {
		hasCompleted = new Player[nPlayers];
		points=new ArrayList<Integer>();
		//assign to points in each position the specific amount, based on the number of players.
		for(int i = 1; i <= nPlayers; i++) {
			points.add(i-1*2);
		}
		
	}
	
	@Override
	public int isCompleted(Player currentPlayer) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}