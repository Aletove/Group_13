package Objectives.commonObj;
import game.*;
import goals.*;
import java.util.*;

import Game.Tile;

public class CommonGoal9 extends Goal{
	private ArrayList<Integer> hasCompletedID;
	private static final int [][] XDIRECTIONS = {//directions to use, assuming that the element is in the center of the shape.
					{-1,-1},
					{-1,1},
					{1,-1},
					{1,1}
		};
  
  
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonGoal9(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<Integer>();
    
	}
  
	@Override
  	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		int rows, cols;
		shelf = currentPlayer.getShelf();
		rows = shelf.length;
		cols = shelf[0].length;
		int cont = 0;
		
		 // Iterate through all the cells of the shelf
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               
            	Tile targetType = shelf[i][j]; // Tile type that we are looking for
            	
            	for (int[] direction : XDIRECTIONS) {
            			int newRow = i + direction[0];
            			int newCol = j + direction[1];
            			if (newRow >= 0 && newRow < 6 && newCol >= 0 && newCol < 5) {
            				if(targetType.equals(shelf[newRow][newCol])) {
            					cont++;
            					//checking if there are 5 Tiles forming an X
            					if(cont == 5 && super.notCompletedYet(currentPlayer, hasCompletedID)) {
            						return super.pointsMethod();
            					}
            				}
            			}
            	}
            	
            	//cont to 0 for new check 
            	cont = 0;
            	
                }
            }
        }
        
        return 0;
    }
}