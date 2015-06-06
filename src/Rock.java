
public class Rock extends Chess{

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
		
		for(i=0;i<8;i++){
			reachable[x][i] = true;
			reachable[i][y] = true;
		}
		
		reachable[x][y] = false;
		
		return reachable;
	}

	@Override
	public boolean isReachable(Chess[][] chessboard, int lx, int ly) {
		
		boolean res = false;
		
		if(lx==x||ly==y)
			res = true;
		
		return res;
	}

}
