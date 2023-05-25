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
	    		System.out.println("Enter the name of" + (nPlayers+1) + "player");
	    		index = rand.nextInt(pGoalsTypes.size()); //Chooses a random index in the pGoalsTypes
	    		playerList.add(new Player(sc.next(), nPlayers, pGoalsTypes.remove(index))); //new istance of player added to playerList
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
	    	
	    	Integer[] pickedRows , pickedColumns;
	    	boolean inputSuccessful;
	    	ArrayList<Tile> pickedTiles;
	    	pickedRows = new Integer[3];
	    	pickedColumns = new Integer[3];
	    	
	    	System.out.println("It is the turn of the player " + currentPlayer.getName());
	    	System.out.println("Enter the coordinates of the group of tiles you would like to pick");
	    	System.out.println("The tiles must have at least one free side, for each tile and be in a straight line");
	    	matchBoard.toString();
	    	System.out.println("The area must be between 1 to 3 tiles, the start and end coordinate can be the same to keep the row, the column or to pick a single Tile");
	    	
	    	do {
	    		
		    	for(int i = 0; i < 3; i++) {
		    		System.out.println( (i+1) + " row coordinate:");
		    		coordinateInput(pickedRows, i, matchBoard.getMaxRows());
		    	}
		    	for(int j = 0; j < 3; j++) {
		    		System.out.println( (j+1) + " column coordinate:");
		    		coordinateInput(pickedColumns, j, matchBoard.getMaxColumns());
		    	}
		    	inputSuccessful = matchBoard.isPickable(pickedRows, pickedColumns);
		    	if(!inputSuccessful) {
		    		System.out.println("The tiles must be in a straight line, repeat the input from the first element");
		    	}
	    	}
	    	
	    	while(!inputSuccessful);    	
	    	
	    	pickedTiles = matchBoard.pickTiles(pickedRows, pickedColumns);
	    	
	    	return true;
	    }
	    /**
	     * Does the basic work to have a valid input from the user .
	     * The valid inputs are: 'Y', 'Yes', 'yes', 'N', 'No', or 'no'
	     * @return true if the answer is yes, otherwise false
	     */
	    public boolean inputValidation() {
	    	Scanner sc;
	    	String tmp;
	    	boolean flag;
	    	sc = new Scanner(System.in);
	    	tmp = sc.next();
	    	
	    	while(!tmp.equals("Y") || !tmp.equals("Yes") || !tmp.equals("yes") || !tmp.equals("N") || !tmp.equals("No") || !tmp.equals("no")) {
	    		System.out.println("The answer is incorrect, please reply with: 'Y', 'Yes', 'yes', 'N', 'No', or 'no'");
	    		tmp = sc.next();
	    	}
    		if(tmp.contentEquals("Y") || tmp.contentEquals("Yes") || tmp.contentEquals("yes")) {
    			flag = true;
    		}
    		else {
    			flag = false;
    		}
    		sc.close();
    		return flag;

	    }
	    public void coordinateInput(Integer[] area, int index, int maxIndex) {
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
	    public Integer integerInput(int min, int max) {
	    	Scanner sc = new Scanner(System.in);
	    	Integer num = 0;
	    	boolean inputFlag = false;
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
	    
	    public Tile[] sortTiles(Tile[] notSorted){
	    	Tile[] sortedTiles;
	    	Integer tileIndex = 0;
	    	System.out.println("How would you like to order the tiles?");
	    	System.out.println("the sequence must contain the numbers indicated by the following statement");
	    	//Cycle used to print the index of every tile present in the array
	    	for(int i = 0; i < notSorted.length; i++) {
	    		System.out.print(i + "\t");
	    	}
	    	System.out.println();//new line
	    	//Cycle to print every element of the array notSorted
	    	for(int i = 0; i < notSorted.length; i++) {
	    		System.out.print(notSorted[i] + "\t");
	    	}
	    	System.out.println();
	    	System.out.println("How would you like to rearrange the tiles?");
	    	for(int i = 0; i < notSorted.length; i++) {
		    	System.out.println("Insert of the " + (i+1) + "tile");
		    	while(true) {
		    		tileIndex = integerInput(0,notSorted.length);
		    	}
		    	
		    	
	    	}
	    	
	    	
	    	
	    	return sortedTiles;
	    }
	    
		
	    
	}
