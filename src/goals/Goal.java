package goals;

import java.util.ArrayList;
import java.util.Iterator;

import game.Player;

public abstract class Goal {
	private Integer[] points;
	
	/**assigns to the array points in each position the specific amount, based on the number of players.
	 * the number of points is equal to the number of players, the value of each positions is equal to the double
	 * of the position+1 (e.g. position 0+1*2-> 2 points. the maximum number is 4)
	 * 
	 * @param nPlayers
	 */
	public Goal(int nPlayers) {
		for(int i = 0; i < nPlayers; i++) {
			points[i]=(i+1)*2;
		}
		
	}
	/**
	 * 
	 * @param currentPlayer
	 * @return true if the player has not completed the common objective yet
	 */
	public abstract int isCompleted(Player currentPlayer);
	
	/**This method verifies that the player ID has not been added to the arraylist "hasCompleted"
	 * If the player has not completed yet the method add the ID to the arrayliist "hasCompleted"
	 * 
	 * @param currentPlayer
	 * @param hasCompletedID arraylist, contains the players ID that have completed the common objective
	 * @return true if the player has not completed the common objective yet
	 */
	public boolean notCompletedYet(Player currentPlayer, ArrayList<String> hasCompletedID) {
		Iterator<String> it = hasCompletedID.iterator();
		boolean flag = false;
		while(it.hasNext() && flag) {
			if(it.next().equals(currentPlayer.getId())) {
				flag = false;
			}
		}
		if(flag) {
			hasCompletedID.add(currentPlayer.getId());
			return true;
		}
		return false;
	}
	
	/**This methods returns the first non-zero in the array points and
	 * every time the non-zero position is found,it is set to zero.
	 * @return points made by the player
	 */
	
	public Integer pointsMethod() {
		Integer point; 
		//The following for cycle searches for a non-zero value, from the tail of the array to assign the points
		for(int i = points.length-1; i >= 0; i--) {
			if(points[i] != 0) {
				point=points[i];
				points[i]=0;
				return point;
			}
		}
		return 0;
	}
}
