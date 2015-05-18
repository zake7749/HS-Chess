public abstract class Chess {
	
	public Chess(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public abstract int[] getReachableGrid();
	public abstract boolean isReachable(int x,int y);	
	
	private int x,y;
}
