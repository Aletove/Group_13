package game;

import java.util.ArrayList;
import java.util.Random;
/**
 * The bag class represents a bag 
 * containing six different types of tiles.
 * The tiles are randomly drawn from the bag
 */
public class Bag {
	
	private ArrayList<Tile> tileCats;
	private ArrayList<Tile> tileBooks;
	private ArrayList<Tile> tileGames;
	private ArrayList<Tile> tileFrames;
	private ArrayList<Tile> tileTrophies;
	private ArrayList<Tile> tilePlants;
	
	/**
	 * Constructs a Bag object		 
	 */
	public Bag() { 
		/**
		 * Initializes the tile arrays.
		 */
		tileCats = new ArrayList<Tile>();
		tileBooks = new ArrayList<Tile>();
		tileGames = new ArrayList<Tile>();
		tileFrames = new ArrayList<Tile>();
		tileTrophies = new ArrayList<Tile>();
		tilePlants = new ArrayList<Tile>();
		
		/**
		 * Create 22 tiles for each type and add them
		 * to the corresponding arrays.
		 */
		for(int i = 0 ; i<22; i++) { 
			tileCats.add(Tile.CATS);
			tileBooks.add(Tile.BOOKS);
			tileGames.add(Tile.GAMES);
			tileFrames.add(Tile.FRAMES);
			tileTrophies.add(Tile.TROPH);
			tilePlants.add(Tile.PLANTS);
		}
		
	}
	
	/**
	 * Extracts a random tile from the bag.
	 * @return A random tile
	 */
	public  Tile getTile() {
		
		Random rand = new Random(); 
		
		//Generate a random number (da 0 a 5) 
		//to indicate wich tile to draw on the switch
		int list = rand.nextInt(6); 	
		
		Tile tiles = Tile.EMPTY; 
		switch (list) {
		case 0:
			if(!tileCats.isEmpty()) {
				tiles = tileCats.remove(0);
			}
			break;
		case 1: 
			if(!tileBooks.isEmpty()) {
				tiles = tileBooks.remove(0);
			}			
			break;
		case 2: 
			if(!tileGames.isEmpty()) {
				tiles = tileGames.remove(0);
			}			
			break;
		case 3:
			if(!tileFrames.isEmpty()) {
				tiles = tileFrames.remove(0);
			}				
			break;
		case 4: 
			if(!tileTrophies.isEmpty()) {
				tiles = tileTrophies.remove(0);
			}	
			
			break;
		case 5: 
			if(!tilePlants.isEmpty()) {
				tiles = tilePlants.remove(0);
			}	
			
			break;

		default:
			System.out.println("Error: the bag is empty");
			break;
		}
		return tiles;
		
	}
}

