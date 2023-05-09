package Game;

public class Cell {
	
	public int x, y, index;
	//index: 0=unused, 1=2 players, 2=3 players, 3=4 players 
	
	public boolean state;
	
	Cell cells = new Cell(x, y, state, index);
	public Cell(int x, int y, boolean state, int index) {
		this.x=x;
		this.y=y;
		this.state=state;
		this.index=index;
	}
	
	public boolean isFree(){
		
		if (this.cells == null && state == true) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
	public void setIndex(int index) {
		this.index = index;
		
	}
	
	public void setState(boolean state) {
		this.state= state;
	}
	
}
