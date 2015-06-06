
public class Pawn extends Chess{

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
		if(x+1<8){
			if(chessboard[x+1][y]==null)
				reachable[x+1][y]=true;
			else if(chessboard[x+1][y].camp!=camp)
				reachable[x+1][y]=true;
		}
		if(x-1>=0){
			if(chessboard[x+1][y]==null)
				reachable[x+1][y]=true;
			else if(chessboard[x+1][y].camp!=camp)
				reachable[x+1][y]=true;
		}
		if(y+1<8){
			if(chessboard[x][y+1]==null)
				reachable[x][y+1]=true;
			else if(chessboard[x][y+1].camp!=camp)
				reachable[x][y+1]=true;
		}
		if(y-1>=0){
			if(chessboard[x][y-1]==null)
				reachable[x][y-1]=true;
			else if(chessboard[x][y-1].camp!=camp)
				reachable[x][y-1]=true;
		}
		return reachable;
	}

	@Override
	public boolean isReachable(Chess[][] chessboard, int lx, int ly) {
		
		boolean res = false;
		
		if(lx==x+1&&ly==y){
			if(chessboard[x+1][y]==null)
				res = true;
			else if(chessboard[x+1][y].camp!=camp)
				res = true;
		}
		else if(lx==x-1&&ly==y){
			if(chessboard[x-1][y]==null)
				res = true;
			else if(chessboard[x-1][y].camp!=camp)
				res = true;
		}
		else if(lx==x&&ly==y-1){
			if(chessboard[x][y-1]==null)
				res = true;
			else if(chessboard[x][y-1].camp!=camp)
				res = true;
		}
		else if(lx==x&&ly==y+1){
			if(chessboard[x][y+1]==null)
				res = true;
			else if(chessboard[x][y+1].camp!=camp)
				res = true;
		}
		
		return res;
	}

}
