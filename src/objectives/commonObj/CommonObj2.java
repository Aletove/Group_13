package objectives.commonObj;
import game.*;
import objectives.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CommonObj2 implements Objective{
	private ArrayList<Player> hasCompleted;
	private Integer[] points;
	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonObj2(int nPlayers) {
		hasCompleted = new ArrayList<Player>();
		//assign to points in each position the specific amount, based on the number of players.
		//the maximum points are equal to the double of the number of players
		for(int i = 0; i < nPlayers; i++) {
			points[i]=(i+1)*2;
		}
		
	}
	/**Method to verify the accomplishment of the common objective
	 * Card number 2
	 */
	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		boolean flag;//this flag is used to store if the player has not completed the objective yet
		shelf = currentPlayer.getShelf();
		Iterator<Player> it = hasCompleted.iterator();
		int maxColumns = shelf.length;
		int maxRows = shelf[0].length;//i used the element 0, since the matrix is static
		
		flag=true;//the base value is assigned to true
		//the following if statement verifies that all the elements in the four angles are equal
		if(shelf[0][0].getType().equals(shelf[0][maxColumns].getType()) && shelf[maxRows][0].getType().equals(shelf[0][maxColumns].getType()) && shelf[0][0].getType().equals(shelf[maxRows][maxColumns].getType()) && shelf[0][0].getType() != null) {
			while(it.hasNext()) {
				if(it.next().getId()==currentPlayer.getId()) {
					flag = false;
				}
			}
			if(flag) {
				hasCompleted.add(currentPlayer);
				return pointsMethod();
			}
		}
		
		return 0;
	}
	
	public Integer pointsMethod() {
		Integer point; 
		for(int i = points.length; i > points.length; i--) {
			if(points[i] != 0) {
				point=points[i];
				points[i]=0;
				return point;
			}
		}
		return 0;
	}
	

}