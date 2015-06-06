import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bishop extends Chess {
	
	public Bishop(String chessName,int x,int y,int camp){
		
		this.name = chessName;
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.critical = false;
		this.weight = 0;
		
		setImage();
	}
	
	public void setImage()
	{
		
	}
	public boolean[][] getReachableGrid(Chess[][] chessboard)
	{
		boolean reachable[][] = new boolean[8][8];
		
		int i = 0,j = 0;
		for(i=0;i<8;i++)
			for(j=0;j<8;j++)
				reachable[i][j] = false;
		
		for(i=0; i<8; i++)
		{
			if(x-i >= 0 && y-i>=0 && chessboard[x-i][y-i] == null)
			{
				reachable[x-i][y-i] = true;
			}
			else if (chessboard[x-i][y-i].camp != camp)
			{
				reachable[x-i][y-i] = true;
				break;
			}
			
			else break;
		}
		
		for(i=0; i<8; i++)
		{
			if(x-i >= 0 && y+i < 8 && chessboard[x-i][y+i] == null)
			{
				reachable[x-i][y+i] = true;
			}
			else if (chessboard[x-i][y+i].camp != camp)
			{
				reachable[x-i][y+i] = true;
				break;
			}
			
			else break;
		}
		
		for(i=0; i<8; i++)
		{
			if(x+i < 8 && y-i>=0 && chessboard[x+i][y-i] == null)
			{
				reachable[x+i][y-i] = true;
			}
			else if (chessboard[x+i][y-i].camp != camp)
			{
				reachable[x+i][y-i] = true;
				break;
			}
			
			else break;
		}
		
		for(i=0; i<8; i++)
		{
			if(x+i < 8 && y+i < 8 && chessboard[x+i][y+i] == null)
			{
				reachable[x+i][y+i] = true;
			}
			else if (chessboard[x+i][y+i].camp != camp)
			{
				reachable[x+i][y+i] = true;
				break;
			}
			
			else break;
		}
		
		
		reachable[x][y] = false;
		
		return reachable;
	}
	public boolean isReachable(Chess[][]chessboard,int Ix,int Iy)
	{
		boolean reach = false;
		boolean[][] reachable;
		int i, j;
		
		reachable = getReachableGrid(chessboard);
		
		for(i=0; i<8; i++)
		{
			for(j=0; j<8; j++)
			{
				if (reachable[i][j] == true && Ix == i && Iy == j)
					reach = true;
			}
		}
		
		return reach;
	}
 
	public JLabel icon;
	public ImageIcon chessPic;
	
	protected int x,y;
	protected String name;
	protected boolean critical;
	protected int weight;
	protected int camp;
}
