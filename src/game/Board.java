package game;

import java.util.ArrayList;

public class Board {

    private int SIZE = 9;
    private int[][] mold = {
        {0, 0, 0, 2, 3, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 3, 0, 0, 0},
        {0, 0, 2, 1, 1, 1, 2, 0, 0},
        {0, 3, 1, 1, 1, 1, 1, 1, 2},
        {3, 1, 1, 1, 1, 1, 1, 1, 3},
        {2, 1, 1, 1, 1, 1, 1, 3, 0},
        {0, 0, 2, 1, 1, 1, 2, 0, 0},
        {0, 0, 0, 3, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 3, 2, 0, 0, 0},};
    private Tile[][] matrix;
    private Bag boardBag = new Bag();
    private static final int[][] DIRECTIONS = {// Directions: top, down, left, right
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    /**
     *
     * @param nPlayer
     */
    public Board(int nPlayer) {
        matrix = new Tile[9][9];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mold[i][j] < nPlayer && mold[i][j] > 0) {
                    matrix[i][j] = Tile.EMPTY;
                }
            }
        }
        fillBoard();
    }

    /**
     * checks if the chosen tiles are allowed to be picked
     *
     * @param row
     * @param col
     * @return true if tiles can be picked
     */
    public boolean isPickable(ArrayList<Integer> row, ArrayList<Integer> col) {
        int pickRow = 0;
        int pickCol = 0;
        for (int i = 0; i < row.size(); i++) {
            for (int j = 0; j < col.size(); j++) {
                pickRow = row.get(i);
                pickCol = col.get(j);
                if (findAdjacent(pickRow, pickCol) || matrix[pickRow][pickCol] == null) {
                    return false;
                }
                if (matrix[pickRow][pickCol].equals(Tile.EMPTY)) {//splitted if to avoid exception when matrix[newRow][newCol] is null
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * the method automatically makes the calls to the methods to fill the board
     * as soon as it is empty
     *
     * @param pickAreaRows
     * @param pickAreaColumns
     * @return array with the selected tiles
     */
    public ArrayList<Tile> pickTiles(ArrayList<Integer> pickAreaRows, ArrayList<Integer> pickAreaColumns) {
        ArrayList<Tile> picked = new ArrayList<Tile>();
        Integer row, col;
        for (int i = 0; i < pickAreaRows.size(); i++) {
            row = pickAreaRows.get(i);
            col = pickAreaColumns.get(i);
            picked.add(matrix[row][col]);
            matrix[row][col] = Tile.EMPTY;
        }

        if (isEmpty()) {
            fillBoard();
        }

        return picked;
    }

    /**
     * fill the board with tiles from the bag
     *
     * @param boardBag
     */
    public void fillBoard() {
        Tile newTile = Tile.EMPTY;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matrix[i][j] != null) {
                    do {
                        newTile = boardBag.getTile();
                    } while (newTile.equals(Tile.EMPTY));
                    matrix[i][j] = newTile;
                }
            }
        }
    }

    /**
     *
     * @param row
     * @param col
     * @return true if the tile has adjacent elements
     */
    private boolean findAdjacent(int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow <= 0 || newRow > rows || newCol <= 0 || newCol > cols || matrix[newRow][newCol] == null) {
                //System.out.println("First if");
                return false; // Found an adjacent tile that is empty, or null
            }
            if (matrix[newRow][newCol].equals(Tile.EMPTY)) {//splitted if to avoid exception when matrix[newRow][newCol] is null
                //System.out.println("Second if");
                return false;
            }
        }

        return true; // Adjacent tiles found

    }

    /**
     * checks the remaining tiles on the board and refills it if there are no
     * adjacent tiles
     *
     * @return false if not empty
     */
    public boolean isEmpty() {
        boolean control = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE && !control; j++) {
                control = findAdjacent(i, j);
                //System.out.println("Is empty? " + control);
            }
        }

        return !control;

    }

    @Override
    public String toString() {
        String s = "";

        //build of the first row with all the indexs
        s += "\t";//offset
        for (int j = 0; j < matrix[0].length; j++) {
            s += j + "\t";
        }
        s += "\n";
        //build of the rest of the matrix in the string
        for (int i = 0; i < matrix.length; i++) {
            //puts the index of the row in the first element
            s += i + "\t";
            for (int j = 0; j < matrix[i].length; j++) {
                s += matrix[i][j] + "\t";
            }
            s += "\n";
        }
        return s;
    }

    public int getMaxRows() {
        return matrix.length;
    }

    public int getMaxColumns() {
        return matrix[0].length;
    }
    
    public Tile[][] getMatrix(){
        return matrix;
    }
}
