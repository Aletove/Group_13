package goals.personalGoal;

import game.Tile;

public enum PersonalGoal{
	GOAL0(new Tile[][] {
		{Tile.PLANTS, Tile.EMPTY, Tile.FRAMES, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.CATS},
		{Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,Tile.BOOKS,Tile.EMPTY,},
		{Tile.EMPTY,Tile.GAMES, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY,},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY, Tile.EMPTY, Tile.TROPHIES, Tile.EMPTY, Tile.EMPTY,},
	}),
	GOAL1(new Tile[][] {
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY, Tile.PLANTS, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.CATS,Tile.EMPTY,Tile.GAMES,Tile.EMPTY,Tile.EMPTY,},
		{Tile.EMPTY,Tile.GAMES, Tile.EMPTY, Tile.EMPTY, Tile.BOOKS,},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.TROPHIES, Tile.EMPTY},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.FRAMES,},
	}),
	GOAL2(new Tile[][] {
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.FRAMES, Tile.EMPTY, Tile.EMPTY, Tile.GAMES, Tile.EMPTY},
		{Tile.EMPTY,Tile.EMPTY,Tile.PLANTS,Tile.EMPTY,Tile.EMPTY,},
		{Tile.EMPTY,Tile.CATS, Tile.EMPTY, Tile.EMPTY, Tile.TROPHIES,},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.BOOKS, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY,},
	}),
	GOAL3(new Tile[][] {
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.GAMES},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,},
		{Tile.EMPTY,Tile.CATS, Tile.EMPTY, Tile.EMPTY, Tile.TROPHIES,},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.BOOKS, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY,},
	}),
	GOAL4(new Tile[][] {
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY, Tile.TROPHIES, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,},
		{Tile.EMPTY,Tile.FRAMES, Tile.BOOKS, Tile.EMPTY, Tile.EMPTY,},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.PLANTS},
		{Tile.GAMES, Tile.EMPTY, Tile.EMPTY, Tile.CATS, Tile.EMPTY,},
	}),
	GOAL5(new Tile[][] {
		{Tile.EMPTY, Tile.EMPTY, Tile.TROPHIES, Tile.EMPTY, Tile.CATS},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,Tile.BOOKS,Tile.EMPTY,},
		{Tile.EMPTY,Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY,},
		{Tile.EMPTY, Tile.GAMES, Tile.EMPTY, Tile.FRAMES, Tile.EMPTY},
		{Tile.PLANTS, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY,},
	}),
	GOAL6(new Tile[][] {
		{Tile.CATS, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.FRAMES, Tile.EMPTY},
		{Tile.EMPTY,Tile.PLANTS,Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,},
		{Tile.TROPHIES,Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY,},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.GAMES},
		{Tile.EMPTY, Tile.EMPTY, Tile.BOOKS, Tile.EMPTY, Tile.EMPTY,},
	}),
	GOAL7(new Tile[][] {
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.FRAMES},
		{Tile.EMPTY, Tile.CATS, Tile.EMPTY, Tile.FRAMES, Tile.EMPTY},
		{Tile.EMPTY,Tile.EMPTY,Tile.TROPHIES,Tile.EMPTY,Tile.EMPTY,},
		{Tile.PLANTS,Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY,},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.BOOKS, Tile.EMPTY},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.GAMES, Tile.EMPTY,},
	}),
	GOAL8(new Tile[][] {
		{Tile.EMPTY, Tile.EMPTY, Tile.GAMES, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.FRAMES, Tile.EMPTY},
		{Tile.EMPTY,Tile.EMPTY,Tile.CATS,Tile.EMPTY,Tile.EMPTY,},
		{Tile.EMPTY,Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.BOOKS,},
		{Tile.EMPTY, Tile.TROPHIES, Tile.EMPTY, Tile.EMPTY, Tile.PLANTS},
		{Tile.FRAMES, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY,},
	}),
	GOAL9(new Tile[][] {
		{Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY, Tile.TROPHIES},
		{Tile.EMPTY, Tile.GAMES, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.BOOKS,Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,},
		{Tile.EMPTY,Tile.EMPTY, Tile.EMPTY, Tile.CATS, Tile.EMPTY,},
		{Tile.EMPTY, Tile.FRAMES, Tile.EMPTY, Tile.EMPTY, Tile.PLANTS},
		{Tile.FRAMES, Tile.EMPTY, Tile.EMPTY, Tile.PLANTS, Tile.EMPTY,},
	}),
	GOAL10(new Tile[][] {
		{Tile.EMPTY, Tile.EMPTY, Tile.PLANTS, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY, Tile.BOOKS, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.GAMES,Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,Tile.EMPTY,},
		{Tile.EMPTY,Tile.EMPTY, Tile.FRAMES, Tile.EMPTY, Tile.EMPTY,},
		{Tile.EMPTY, Tile.FRAMES, Tile.EMPTY, Tile.EMPTY, Tile.CATS},
		{Tile.FRAMES, Tile.EMPTY, Tile.EMPTY, Tile.TROPHIES, Tile.EMPTY,},
	}),
	GOAL11(new Tile[][] {
		{Tile.EMPTY, Tile.EMPTY, Tile.BOOKS, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY, Tile.PLANTS, Tile.EMPTY, Tile.EMPTY, Tile.EMPTY},
		{Tile.EMPTY,Tile.EMPTY,Tile.FRAMES,Tile.EMPTY,Tile.EMPTY,},
		{Tile.EMPTY,Tile.EMPTY, Tile.EMPTY, Tile.TROPHIES, Tile.EMPTY,},
		{Tile.EMPTY, Tile.FRAMES, Tile.EMPTY, Tile.EMPTY, Tile.GAMES},
		{Tile.CATS, Tile.EMPTY, Tile.EMPTY, Tile.PLANTS, Tile.EMPTY,},
	}),;

	PersonalGoal(Tile[][] tiles) {
		
	}
	
	

	

}