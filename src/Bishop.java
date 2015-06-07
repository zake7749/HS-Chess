import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

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
		if(camp==1){
			chessPic = new ImageIcon("hero_final.jpg");
			icon = new JLabel(chessPic);
		}
		else if(camp==2){
			chessPic = new ImageIcon("nafarian_final.jpg");
			icon = new JLabel(chessPic);
		}
		
	}
	public void setMusic(){
		if(camp==1){
			String song = "hero.wav";
			InputStream in;
			try {
				in = new FileInputStream(song);
				AudioStream audioStream = new AudioStream(in);
				AudioPlayer.player.start(audioStream);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(camp==2){
			String song = "nafarian.wav";
			InputStream in;
			try {
				in = new FileInputStream(song);
				AudioStream audioStream = new AudioStream(in);
				AudioPlayer.player.start(audioStream);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
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
}
