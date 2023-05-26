package game;
import java.util.*;
import goals.*;
import goals.commonGoal.*;
import goals.personalGoal.*;

public class MainGame {
	    private ArrayList<Player> playerList;
	    private ArrayList<Goal> commonGoals;
	    private ArrayList<PersonalGoal> pGoalsTypes;
	    private Board matchBoard;
	    private int nPlayers;
	    private int firstEndedPoint = 1;
	    
	    
	    public static void main(String [] args) {
	    	MainGame match = new MainGame();
	    	ArrayList<Player> players;
	    	boolean gameNotEnded = true;
	    	match.initGame();
	    	
	    	
	    	players = match.getPlayerList();
	    	
	    	do {
	    		for(Player currentPlayer : players) {
		    		if(match.turn(currentPlayer)) {
		    			gameNotEnded = false;
		    			
		    		}
		    	}
	    		
	    	}while(gameNotEnded);
	    	
	    }
	    
	    public ArrayList<Player> getPlayerList(){
	    	return playerList;
	    }
	    
	    MainGame(){
	    	playerList = new ArrayList<Player>();
	    	commonGoals = new ArrayList<Goal>();
	    	pGoalsTypes = new ArrayList<PersonalGoal>();
	    	
	    }
	    
	    
	    /**
	     * the constructor initialize a new game, 
	     * in the near future could be added a function to maintain players but reset all the other attributes.
	     */
	    public void initGame() {
	    	boolean stop;
	    	Random rand;
	    	int index;
			Scanner sc;
			
			ArrayList<Goal> allCommonGoals;
			
			nPlayers = 0;
	    	stop = false;
	    	rand = new Random();
	    	sc = new Scanner(System.in);
	    	allCommonGoals = new ArrayList<Goal>();
	    	
	    	
	    	Collections.addAll(pGoalsTypes, PersonalGoal.values());
	    	do {
	    		System.out.println("Enter the name of the player number " + (nPlayers+1));
	    		index = rand.nextInt(pGoalsTypes.size()); //Chooses a random index in the pGoalsTypes
	    		playerList.add(new Player(nPlayers, sc.next(), pGoalsTypes.remove(index).getGoal())); //new istance of player added to playerList
	    		System.out.println("Would you like to add another player?");
	    		System.out.println("Yes or no?");
	    		if(inputValidation() && nPlayers > 1) {
	    			stop = true;
	    		}
	    		nPlayers++;
	    	}
	    	while(nPlayers < 5 || !stop);
	    	
	    	matchBoard = new Board(nPlayers);
	    	
	    	//Initializing all the 12 commonGoals, to be able to choose randomly later.
	    	allCommonGoals.add(new CommonGoal0(nPlayers));
	    	allCommonGoals.add(new CommonGoal1(nPlayers));
	    	allCommonGoals.add(new CommonGoal2(nPlayers));
	    	allCommonGoals.add(new CommonGoal3(nPlayers));
	    	allCommonGoals.add(new CommonGoal4(nPlayers));
	    	allCommonGoals.add(new CommonGoal5(nPlayers));
	    	allCommonGoals.add(new CommonGoal6(nPlayers));
	    	allCommonGoals.add(new CommonGoal7(nPlayers));
	    	allCommonGoals.add(new CommonGoal8(nPlayers));
	    	allCommonGoals.add(new CommonGoal9(nPlayers));
	    	allCommonGoals.add(new CommonGoal10(nPlayers));
	    	allCommonGoals.add(new CommonGoal11(nPlayers));
	    	//mixes up all the common goals
	    	Collections.shuffle(allCommonGoals);
	    	System.out.println("Is this your first game and would like to use just a common goal, instead of two?");
	    	//everything different from Y, yes and Yes will be considered simply no
	    	if(inputValidation()) {
    			commonGoals.add(allCommonGoals.remove(0));
    		}
    		else {
    			commonGoals.add(allCommonGoals.remove(0));
    			//the index is not changed, since the remove method removes the element specified in the index and shifts the array one position to the left
    			commonGoals.add(allCommonGoals.remove(0));
    		}

	    	
	    	Collections.shuffle(playerList);
	    	playerList.get(0).setIsFirst(true);
	    	sc.close();
	    }
	    
	    /**
	     * game logic to manage the turn of the player
	     * @param currentPlayer
	     * @return true if the player has filled his shelf
	     */
	    public boolean turn(Player currentPlayer) {
	    	
	    	int[] pickedRows , pickedColumns;
	    	int chosenCol, maxTiles, currentPoints = 0;
	    	boolean inputSuccessful, canContinue;
	    	ArrayList<Tile> pickedTiles;
	    	pickedRows = new int[3];
	    	pickedColumns = new int[3];
	    	
	    	System.out.println("It is the turn of the player " + currentPlayer.getName());
	    	System.out.println(matchBoard.toString());
	    	System.out.println("Enter the coordinates of the group of tiles you would like to pick");
	    	System.out.println("The tiles must have at least one free side, for each tile and be in a straight line");
	    	
	    	System.out.println("The area must be between 1 to 3 tiles, the start and end coordinate can be the same to keep the row, the column or to pick a single Tile");
	    	maxTiles = currentPlayer.nMaxTiles()[1];
	    	if(maxTiles >= 4) {
	    		maxTiles = 3;
	    	}
	    	do {
	    		// Reset of the flag
	    		canContinue = true;
		    	for(int i = 0; i < maxTiles && canContinue; i++) {
		    		System.out.println((i+1) + " row coordinate:");
		    		coordinateInput(pickedRows, i, matchBoard.getMaxRows());
		    		if(i < maxTiles) {
		    			System.out.println("Would you like to insert more tiles? Yes or no");
		    			canContinue = inputValidation();
		    		}
		    		
		    	}
		    	// Reset of the flag
		    	canContinue = true;
		    	for(int j = 0; j < maxTiles && canContinue; j++) {
		    		System.out.println((j+1) + " column coordinate:");
		    		coordinateInput(pickedColumns, j, matchBoard.getMaxColumns());
		    		if(j < maxTiles) {
		    			System.out.println("Would you like to insert more tiles? Yes or no");
		    			canContinue = inputValidation();
		    		}
		    	}
		    	inputSuccessful = matchBoard.isPickable(pickedRows, pickedColumns);
		    	if(!inputSuccessful) {
		    		System.out.println("The tiles aren't in a straight line or you picked too many tiles. The max number is " + maxTiles);
		    	}
	    	}
	    	
	    	while(!inputSuccessful);    	
	    	do {
	    		pickedTiles = matchBoard.pickTiles(pickedRows, pickedColumns);
	    		currentPlayer.printShelf();
	    		System.out.println("Enter the index of the column you would like to fill");
	    		chosenCol = integerInput(0, currentPlayer.getShelf()[0].length);
	    		
	    	}
	    	while(!currentPlayer.fillShelfColumn(chosenCol, pickedTiles));
	    	
	    	for(Goal commonGoal : commonGoals) {
	    		currentPoints = currentPlayer.getCGoalPoints() + currentPlayer.getCGoalPoints();
	    		commonGoal.isCompleted(currentPlayer);
	    		currentPlayer.setCGoalPoints(currentPoints);
	    	}
	    	//if the shelf of the player is full
	    	if(currentPlayer.checkShelf()) {
	    		if(firstEndedPoint > 0) {
	    			currentPoints = currentPlayer.getCGoalPoints();
	    			currentPoints += firstEndedPoint;
	    			currentPlayer.setCGoalPoints(currentPoints);
	    		}
	    		return true;
	    	}
	    	return false;
	    }
	    /**
	     * Does the basic work to have a valid input from the user .
	     * The valid inputs are: 'Y', 'Yes', 'yes', 'N', 'No', or 'no'
	     * @return true if the answer is yes, otherwise false
	     */
	    public boolean inputValidation() {
	    	Scanner sc;
	    	String choice = null;
	    	boolean flag;
	    	sc = new Scanner(System.in);
	    	choice = sc.next();
	    	while(!choice.contains("y") || !choice.equals("Yes") || !choice.equals("yes") || !choice.equals("N") || !choice.equals("No") || !choice.equals("no")) {
	    		System.out.println("The answer is incorrect, please reply with: 'Y', 'Yes', 'yes', 'N', 'No', or 'no'");
	    		choice = sc.next();
	    	}
    		if(choice.equals("Y") || choice.equals("Yes") || choice.equals("yes")) {
    			flag = true;
    		}
    		else {
    			flag = false;
    		}
    		sc.close();
    		return flag;

	    }
	    public void coordinateInput(int [] area, int index, int maxIndex) {
	    	Integer num = 0;
	    	boolean inputFlag = false;
	    	do {
	    		num = integerInput(0, maxIndex);
	    		if(index>0) {
	    			if(area[index-1] != num && area[index-1] != num-1) {
	    				inputFlag = true;
	    			}
	    			else {
	    				inputFlag = false;
	    				area[index] = num;
	    			}
	    		}
	    		else {
	    			inputFlag = false;
	    			area[index] = num;
	    		}
	    	}
	    	while(inputFlag);
	    	
	    	
	    }
	    /**
	     * Manages the input of an integer
	     * @param min minimum of the number in input from the user, included.
	     * @param max maximum of the number in input from the user, excluded.
	     * @return
	     */
	    public Integer integerInput(int min, int max) {
	    	Scanner sc = new Scanner(System.in);
	    	Integer num = 0;
	    	boolean inputFlag = false;
	    	//new interaction every time the number is too great, too small or wrong format.
	    	do {
    			try {
    				num = sc.nextInt();
    				if(num <= min || num > max) {
    					System.out.println("Please insert a number between" + min +", included and " + max +" excluded");
    				}
    			}
    			catch(InputMismatchException e){
    				e.printStackTrace();
    				System.out.println("Error, the number has to be an integer");
    				sc.nextLine();//cleaning input buffer
    				inputFlag = true;
    			}
    		}
    		while(inputFlag);
	    	sc.close();
	    	
	    	return num;
	    }
	    
	    /**
	     * 
	     * @param notSorted not sorted tiles
	     * @return if the user wants to sort the tiles, the newly sorted arraylist will be returned or the arraylist notSorted if the user doesn't want the rearrangement.
	     */
	    public ArrayList<Tile> sortTiles(ArrayList<Tile> notSorted){
	    	ArrayList<Tile> sortedTiles = new ArrayList<Tile>();
	    	int tileIndex = 0;
	    	int index = 0;
	    	
	    	System.out.println("Would you like to rearrange the tiles? Yes or no");
	    	//If the answer is yes, all the tiles will be rearranged and returned from here
	    	if(inputValidation()) {
	    		while(notSorted.size()>0); {
	    			System.out.println("Insert the number of the tile number 0" +index);
	    			System.out.println("The number must be in between" + 0 +", included and " + notSorted.size() +" excluded");
	    			tileIndex = integerInput(0,notSorted.size());
	    			sortedTiles.add(notSorted.remove(tileIndex));
	    		}
	    		
	    		return sortedTiles;
	    	}
		    
	    	//If in the input validation the answer is no, the tiles will be returned without any changes.
	    	return notSorted;
	    }
	    /**
	     * Fast way to print an arraylist of tiles with an index on top of the row 
	     * @param genericTiles
	     */
	    public void printTileArrayList (ArrayList<Tile> genericTiles) {
	    	//print of the index for every element present in the arraylist
	    	for(int i = 0; i < genericTiles.size(); i++) {
	    		System.out.print(i + "\t");
	    	}
	    	System.out.println();
	    	//print of the elements contained in the arraylist
	    	for(int i = 0; i < genericTiles.size(); i++) {
	    		System.out.print(genericTiles.get(i) + "\t");
	    	}
	    	System.out.println();
	    }
	    
		
	    
	}
