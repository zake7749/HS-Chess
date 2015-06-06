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
			if(x-i >= 0 && y-i >= 0 && x+i < 8 && y+i < 8)
			{
				if(chessboard[x-i][y-i] != null)
					reachable[x-i][y-i] = true;
				
				if(chessboard[x+i][y-i] != null)
					reachable[x+i][y-i] = true;
				
				if(chessboard[x-i][y+i] != null)
					reachable[x-i][y+i] = true;
				
				if(chessboard[x+i][y+i] != null)
					reachable[x+i][y+i] = true;
			}
		}
		
		
		
		return reachable;
	}
	public boolean isReachable(Chess[][]chessboard,int x,int y)
	{
		
	}
 
	public JLabel icon;
	public ImageIcon chessPic;
	
	protected int x,y;
	protected String name;
	protected boolean critical;
	protected int weight;
	protected int camp;
}
