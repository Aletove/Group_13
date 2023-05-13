


package Game;

import java.util.ArrayList;
import java.util.Random;

public class Bag {
	//dichiaro gli attributi
	private ArrayList<Tile> tileCats;
	private ArrayList<Tile> tileBooks;
	private ArrayList<Tile> tileGames;
	private ArrayList<Tile> tileFrames;
	private ArrayList<Tile> tileTrophies;
	private ArrayList<Tile> tilePlants;
	
		 
	public Bag() { //costruttore
		//inizializzo gli array
		tileCats = new ArrayList<Tile>();
		tileBooks = new ArrayList<Tile>();
		tileGames = new ArrayList<Tile>();
		tileFrames = new ArrayList<Tile>();
		tileTrophies = new ArrayList<Tile>();
		tilePlants = new ArrayList<Tile>();
		
		for(int i = 0 ; i<22; i++) { //creo le 22 carte, da inserire nell'array, per ogni tipo di Tile
			tileCats.add(Tile.CATS);
			tileBooks.add(Tile.BOOKS);
			tileGames.add(Tile.GAMES);
			tileFrames.add(Tile.FRAMES);
			tileTrophies.add(Tile.TROPHIES);
			tilePlants.add(Tile.PLANTS);
		}
		
	}
	public  Tile getTile() {
		Random rand = new Random(); //creo random per generare numeri casuali
		int list = rand.nextInt(6); // genera un numero (da 1 a 5) che indica quale tile pescare
		
		ArrayList<Tile> tiles; //per selezionare la tile scelta
		switch (list) {
		case 1:
			tiles = tileCats;
			break;
		case 2: 
			tiles = tileBooks;
			break;
		case 3: 
			tiles = tileGames;
			break;
		case 4:
			tiles = tileFrames;
			break;
		case 5: 
			tiles = tileTrophies;
			break;
		case 6: 
			tiles = tilePlants;
			break;

		default:
			System.out.println("errore bag vuota");
			break;
		}
		return null;
	}
}


