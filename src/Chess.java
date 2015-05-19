public abstract class Chess {
	
	public Chess(String chessName,int x,int y,int camp){
		this.name = chessName;
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.critical = false;
		this.weight = 0;
	}
	
	public void moveX(int x){
		this.x = x;
	}
	
	public void moveY(int y){
		this.y = y;
	}
	
	public void moveXY(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getWeight(){
		return this.weight;
	}
	
	public int camp(){
		return this.camp;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean isCritical(){
		return this.critical;
	}
	
	
	public abstract boolean[] getReachableGrid(int[] chessboard);
	public abstract boolean isReachable(int[]chessboard,int x,int y);	
	
	private int x,y;
	private String name;
	private boolean critical;
	private int weight;
	private int camp;
}
