package game;

import java.util.Random;

public class bag {
	//dichiaro gli attributi
	private Tile[] tileCats;
	private Tile[] tileBooks;
	private Tile[] tileGames;
	private Tile[] tileTrophies;
	private Tile[] tilePlants;
	
		 
	public bag() {
		//costruisco la classe
		this.tileCats = new Tile[22];
		this.tileBooks = new Tile[22];
		this.tileGames = new Tile[22];
		this.tileTrophies = new Tile[22];
		this.tileTrophies = new Tile[22];
		
	}
	public  void getTile() {
		Random rand = new Random(); //creo random per generare numeri casuali
		int list = rand.nextInt(5); // genera un numero (da 1 a 5) che indica quale tile pescare
		Tile[] Tiles; //dichiaro la variabile Tile
		switch (list) {
		case 1:
			Tiles = tileCats;
			break;
		case 2: 
			Tiles = tileBooks;
			break;
		case 3: 
			Tiles = tileGames;
			break;
		case 4: 
			Tiles = tileTrophies;
			break;
		case 5: 
			Tiles = tilePlants;
			break;

		default:
			//mettere un exception in caso di bag vuota?
			break;
		}
	}
}


