package game;

import java.util.*;
import goals.*;
import goals.commonGoal.*;
import goals.personalGoal.*;

public class Game {

    private ArrayList<Player> playerList;
    private ArrayList<Goal> commonGoals;
    private ArrayList<PersonalGoal> pGoalsTypes;
    private Board matchBoard;
    private int nPlayers;
    private int firstEndedPoint;
    private final Scanner sc = new Scanner(System.in);

    
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public Game() {
        playerList = new ArrayList<Player>();
        commonGoals = new ArrayList<Goal>();
        pGoalsTypes = new ArrayList<PersonalGoal>();
        firstEndedPoint  = 1;

    }

    /**
     * the constructor initialize a new game, using command line. In the near future could be added
     * a function to maintain players but reset all the other attributes.
     */
    public void initGame() {
        boolean stop;
        Random rand;
        int index;
        String name;
        ArrayList<Goal> allCommonGoals;

        nPlayers = 0;
        stop = false;
        rand = new Random();

        allCommonGoals = new ArrayList<Goal>();

        Collections.addAll(pGoalsTypes, PersonalGoal.values());
        do {

            System.out.println("Enter the name of the player number " + (nPlayers + 1));
            index = rand.nextInt(pGoalsTypes.size()); //Chooses a random index in the pGoalsTypes
            name = sc.next();
            playerList.add(new Player(nPlayers, name, pGoalsTypes.remove(index).getGoal())); //new istance of player added to playerList
            if (nPlayers > 0 && nPlayers < 4) {
                System.out.println("Would you like to add another player?");
                System.out.println("Yes or no?");
                if (!inputValidation()) {
                    stop = true;
                    //System.out.println(nPlayers);
                }
            }

            nPlayers++;
            //System.out.println(nPlayers);
        } while (nPlayers < 5 && !stop);

        matchBoard = new Board(nPlayers);

        //Initializing all the 12 commonGoals, to be able to choose randomly later.
        allCommonGoals.add(new CommonGoal0(nPlayers));
        allCommonGoals.add(new CommonGoal1(nPlayers));
        /*allCommonGoals.add(new CommonGoal2(nPlayers));
        allCommonGoals.add(new CommonGoal3(nPlayers));
	allCommonGoals.add(new CommonGoal4(nPlayers));
	allCommonGoals.add(new CommonGoal5(nPlayers));
	allCommonGoals.add(new CommonGoal6(nPlayers));
	allCommonGoals.add(new CommonGoal7(nPlayers));
	allCommonGoals.add(new CommonGoal8(nPlayers));
	allCommonGoals.add(new CommonGoal9(nPlayers));
	allCommonGoals.add(new CommonGoal10(nPlayers));
	allCommonGoals.add(new CommonGoal11(nPlayers));*/
        //mixes up all the common goals
        Collections.shuffle(allCommonGoals);
        System.out.println("Is this your first game and would like to use just a common goal, instead of two?");
        //everything different from Y, yes and Yes will be considered simply no
        if (inputValidation()) {
            commonGoals.add(allCommonGoals.remove(0));
        } else {
            commonGoals.add(allCommonGoals.remove(0));
            //the index is not changed, since the remove method removes the element specified in the index and shifts the array one position to the left
            commonGoals.add(allCommonGoals.remove(0));
        }

        Collections.shuffle(playerList);
        playerList.get(0).setIsFirst(true);
    }

    /**
     * method used for the GUI version of the project
     *
     * @param playerNames
     * @param oneGoal boolean variable that indicates if the game has to have
     * just one goal, or the standad quantity, two
     */
    public void initGame(ArrayList<String> playerNames, boolean oneGoal) {
        int index;
        Random rand;
        String name;
        ArrayList<Goal> allCommonGoals;
        Iterator<String> names = playerNames.iterator();
        rand = new Random();
        allCommonGoals = new ArrayList<Goal>();
        
        Collections.addAll(pGoalsTypes, PersonalGoal.values());
        
        //creating all the player objects
        while(names.hasNext()) {
            index = rand.nextInt(pGoalsTypes.size()); //Chooses a random index in the pGoalsTypes
            name = names.next();
            playerList.add(new Player(nPlayers, name, pGoalsTypes.remove(index).getGoal())); //new istance of player added to playerList
        }

        matchBoard = new Board(playerNames.size());

        //Initializing all the 12 commonGoals, to be able to choose randomly.
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
        if (oneGoal) {
            commonGoals.add(allCommonGoals.remove(0));
        } else {
            commonGoals.add(allCommonGoals.remove(0));
            //the index is not changed, since the remove method removes the element specified in the index and shifts the array one position to the left
            commonGoals.add(allCommonGoals.remove(0));
        }

        Collections.shuffle(playerList);
        playerList.get(0).setIsFirst(true);

    }

    /**
     * Method to manage the turn of the player with command line
     *
     * @param currentPlayer
     * @return true if the player has filled his shelf
     */
    public boolean turn(Player currentPlayer) {

        ArrayList<Integer> pickedRows, pickedColumns;
        int chosenCol, maxTiles, currentPoints = 0, suggestedCol;
        boolean inputSuccessful, canContinue;
        ArrayList<Tile> pickedTiles;
        pickedTiles = new ArrayList<Tile>();
        pickedRows = new ArrayList<Integer>();
        pickedColumns = new ArrayList<Integer>();

        System.out.println("It is the turn of the player " + currentPlayer.getName());
        System.out.println();
        System.out.println(matchBoard.toString());
        System.out.println();
        System.out.println("Enter the coordinates of the group of tiles you would like to pick");
        System.out.println("The tiles must have at least one free side, for each tile and be in a straight line");

        System.out.println("The area must be between 1 to 3 tiles, the start and end coordinate can be the same to keep the row, the column or to pick a single Tile");
        //maxTiles is based on the max number of empty tiles in the shelf
        maxTiles = currentPlayer.nMaxTiles()[1];

        do {
            pickedRows.clear();
            pickedColumns.clear();
            // Reset of the flag
            canContinue = true;
            for (int i = 0; i < maxTiles && canContinue; i++) {
                System.out.println((i + 1) + " row coordinate:");
                coordinateInput(pickedRows, i, matchBoard.getMaxRows());
                if (i < maxTiles - 1) {
                    System.out.println("Would you like to insert more tiles? Yes or no");
                    canContinue = inputValidation();
                }

            }

            for (int j = 0; j < pickedRows.size(); j++) {
                System.out.println((j + 1) + " column coordinate:");
                coordinateInput(pickedColumns, j, matchBoard.getMaxColumns());
            }
            inputSuccessful = matchBoard.isPickable(pickedRows, pickedColumns);
            if (!inputSuccessful) {
                System.out.println("The tiles aren't in a straight line, or they haven't got a free side, or you picked too many tiles, or invalid index. The max number of tiles is " + maxTiles);
            }
        } while (!inputSuccessful);

        pickedTiles = matchBoard.pickTiles(pickedRows, pickedColumns);
        if (pickedTiles.size() > 1) {
            //System.out.println(pickedTiles.toString());
            System.out.println("Would you like to sort the tiles? Yes or no");
            //If the answer is yes, all the tiles will be rearranged and returned from here
            if (inputValidation()) {
                pickedTiles = sortTiles(pickedTiles);
            }

        }
        System.out.println(currentPlayer.printShelf());
        suggestedCol = currentPlayer.nMaxTiles()[0];
        do {
            if (maxTiles > 2) {
                System.out.println("Enter the index of the column you would like to fill");
            } else {
                System.out.println("Since the columns of the shelf are almost filled, the suggested column to be filled is " + suggestedCol);
            }
            chosenCol = integerInput(0, currentPlayer.getShelf()[0].length);

        } while (!currentPlayer.fillShelfColumn(chosenCol, pickedTiles));

        for (Goal commonGoal : commonGoals) {
            currentPoints = currentPlayer.getPoints() + currentPlayer.getPoints();
            commonGoal.isCompleted(currentPlayer);
            currentPlayer.setPoints(currentPoints);
        }
        //if the shelf of the player is full
        if (currentPlayer.checkShelf()) {
            if (firstEndedPoint > 0) {
                currentPoints = currentPlayer.getPoints();
                currentPoints += firstEndedPoint;
                currentPlayer.setPoints(currentPoints);
            }
            return true;
        }
        return false;
    }

    /**
     * Does the basic work to have a valid input from the user . The valid
     * inputs are: 'Y', 'Yes', 'yes', 'N', 'No', or 'no'
     *
     * @return true if the answer is yes, otherwise false
     */
    public boolean inputValidation() {
        String choice;
        boolean flag;

        choice = sc.next();
        //while(!choice.contains("y") || !choice.equals("Yes") || !choice.equals("yes") || !choice.equals("N") || !choice.equals("No") || !choice.equals("no")) 
        while (!choice.startsWith("y") && !choice.startsWith("Y") && !choice.startsWith("n") && !choice.startsWith("N")) {
            System.out.println("The answer is incorrect, please reply with: 'Y', 'Yes', 'yes', 'N', 'No', or 'no'");
            choice = sc.next();

        }
        flag = choice.startsWith("y") || choice.startsWith("Y");

        return flag;

    }
    /**
     * turn to use with the GUI
     * the picked rows and columns and chosen column have to be already checked in the GUI with the given methods
     * @param currentPlayer
     * @return true if the game has ended
     */
    public boolean turn(Player currentPlayer, ArrayList<Integer> pickedRows, ArrayList<Integer> pickedColumns, int chosenCol) {
        int currentPoints = 0;
        
        ArrayList<Tile> pickedTiles;
        pickedTiles = matchBoard.pickTiles(pickedRows, pickedColumns);
        currentPlayer.fillShelfColumn(chosenCol, pickedTiles);        
        for (Goal commonGoal : commonGoals) {
            currentPoints = currentPlayer.getPoints() + currentPlayer.getPoints();
            commonGoal.isCompleted(currentPlayer);
            currentPlayer.setPoints(currentPoints);
        }
        //if the shelf of the player is full
        if (currentPlayer.checkShelf()) {
            if (firstEndedPoint > 0) {
                currentPoints = currentPlayer.getPoints();
                currentPoints += firstEndedPoint;
                currentPlayer.setPoints(currentPoints);
            }
            return true;
        }
        return false;
    }

    /**
     * Does the basic work to have a valid input from the user . The valid
     * inputs are: 'Y', 'Yes', 'yes', 'N', 'No', or 'no'
     *
     * @return true if the answer is yes, otherwise false
     */
    

    public void coordinateInput(ArrayList<Integer> area, int index, int maxIndex) {
        Integer num = 0;
        boolean inputFlag = false;
        do {
            num = integerInput(0, maxIndex);
            if (index > 0) {
                if (!area.get(index - 1).equals(num) && !area.get(index - 1).equals(num - 1)) {
                    System.out.println("The number must be equal or greater than the previous number");
                    inputFlag = true;
                } else {
                    inputFlag = false;
                    area.add(num);
                }
            } else {
                inputFlag = false;
                area.add(num);
            }
        } while (inputFlag);

    }

    /**
     * Manages the input of an integer
     *
     * @param min minimum of the number in input from the user, included.
     * @param max maximum of the number in input from the user, excluded.
     * @return
     */
    public Integer integerInput(int min, int max) {
        Integer num = 0;
        boolean inputFlag = false;
        //new interaction every time the number is too great, too small or wrong format.

        do {

            try {
                System.out.println("Please insert a number between " + min + ", included and " + max + " excluded");
                num = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Error, the number has to be an integer");

            }
        } while (num < min || num >= max);
        return num;
    }

    /**
     *
     * @param notSorted not sorted tiles
     * @return the tiles sorted by the user
     */
    public ArrayList<Tile> sortTiles(ArrayList<Tile> notSorted) {
        ArrayList<Tile> sortedTiles = new ArrayList<Tile>();
        int tileIndex;
        int index = 0;
        while (!notSorted.isEmpty()) {
            printTileArrayList(notSorted);

            System.out.println("Insert the number of the tile number " + index);
            
            tileIndex = integerInput(0, notSorted.size());
            sortedTiles.add(notSorted.remove(tileIndex));
        }

        return sortedTiles;
    }
    public ArrayList<Player> rankings(){
        ArrayList<Player> sortedRanking;
        sortedRanking = playerList;
        // Setting up the comparator, the reversed flag is to have a decrescent order
        Comparator<Player> scoreComparator = Comparator.comparingInt(Player :: totalPoints).reversed();

        // Sorting the ArrayList with the Comparator
        Collections.sort(sortedRanking, scoreComparator);
        return sortedRanking;
    }

    /**
     * Fast way to print an arraylist of tiles with an index on top of the row
     *
     * @param genericTiles
     */
    public void printTileArrayList(ArrayList<Tile> genericTiles) {
        //print of the index for every element present in the arraylist
        for (int i = 0; i < genericTiles.size(); i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        //print of the elements contained in the arraylist
        for (int i = 0; i < genericTiles.size(); i++) {
            System.out.print(genericTiles.get(i) + "\t");
        }
        System.out.println();
    }

    public Board getBoard() {
        return matchBoard;
    }

}

