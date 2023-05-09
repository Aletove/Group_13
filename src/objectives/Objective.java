package objectives;

import java.util.ArrayList;
import java.util.Iterator;

import game.Player;

public abstract class Objective {
	private Integer[] points;
	
	public Objective(int nPlayers) {
		//assign to points in each position the specific amount, based on the number of players.
		//the maximum points are equal to the double of the number of players
		for(int i = 0; i < nPlayers; i++) {
			points[i]=(i+1)*2;
		}
		
	}
	/**
	 * 
	 * @param currentPlayer
	 * @return
	 */
	public abstract int isCompleted(Player currentPlayer);
	
	
	public boolean notCompletedYet(Player currentPlayer, ArrayList<Player> hasCompleted) {
		Iterator<Player> it = hasCompleted.iterator();
		boolean flag = false;
		while(it.hasNext()) {
			if(it.next().getId()==currentPlayer.getId()) {
				flag = false;
			}
		}
		if(flag) {
			hasCompleted.add(currentPlayer);
			return true;
		}
		return false;
	}
	
	/**This methods returns the first non-zero in the array points
	 * every time the non-zero position is found, the method sets it to zero.
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
