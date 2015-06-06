
public class King extends Chess{

	public King(String chessName, int x, int y, int camp) {
		
		this.name = chessName;
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.critical = false;
		this.weight = 0;
		
		setImage();
	}

	@Override
	public void setImage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean[][] getReachableGrid(Chess[][] chessboard) {
		
		boolean reachable[][] = new boolean[8][8];
		
		int i = 0,j = 0;
		for(i=0;i<8;i++)
			for(j=0;j<8;j++)
				reachable[i][j] = false;
		
		for(i=x-1;i<=x+1;x++){
			for(j=y-1;j<=j+1;j++){
				if(i>=0&&j>=0&&i<8&&j<8)
					reachable[i][j] = true;
			}
		}
		reachable[i][j] = false;
		
		return reachable;
	}

	@Override
	public boolean isReachable(Chess[][] chessboard, int dx, int dy) {
		
		int i,j;
		boolean res = false;
		
		for(i=x-1;i<=x+1;x++){
			for(j=y-1;j<=j+1;j++){
				if((i>=0&&j>=0&&i<8&&j<8)&&(i==dx&&j==dy)){
					res = true;
					break;
				}
			}
		}
		return res;
	}
	
}
