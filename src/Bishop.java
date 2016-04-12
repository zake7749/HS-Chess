import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
<<<<<<< HEAD
import java.util.Stack;
=======
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f

import javax.swing.ImageIcon;
import javax.swing.JLabel;




import sun.audio.*;

public class Bishop extends Chess {
	
	public Bishop(String chessName,int x,int y,int camp){
		
		this.name = chessName;
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.critical = false;
		this.weight = 16;
<<<<<<< HEAD
		this.status = true;

=======
		
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
		setImage();
	}
	
	public void setImage()
	{
		if(camp==0){
			chessPic = new ImageIcon("asset/img/hero_final.jpg");
			icon = new JLabel(chessPic);
		}
		else if(camp==1){
			chessPic = new ImageIcon("asset/img/nafarian_final.jpg");
			icon = new JLabel(chessPic);
		}
		
	}
	public void setMusic(){
		AudioPlayer.player.stop(audioStream);
		if(camp==0){
			String song = "hero.wav";
			InputStream in;
			try {
				in = new FileInputStream(rootPath+song);
				audioStream = new AudioStream(in);
				AudioPlayer.player.start(audioStream);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(camp==1){
			String song = "nafarian.wav";
			InputStream in;
			try {
				in = new FileInputStream(rootPath+song);
				audioStream = new AudioStream(in);
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
	public void setMusicDead(){
		AudioPlayer.player.stop(audioStream);
		if(camp==0){
			String song = "hero_dead.wav";
			InputStream in;
			try {
				in = new FileInputStream(rootPath+song);
				audioStream = new AudioStream(in);
				AudioPlayer.player.start(audioStream);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(camp==1){
			String song = "nafarian_dead_final.wav";
			InputStream in;
			try {
				in = new FileInputStream(rootPath+song);
				audioStream = new AudioStream(in);
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
<<<<<<< HEAD
	public Stack<Point> getReachableGrid(Chess[][] chessboard)
	{
		Stack<Point> moves = new Stack<Point>();

		int i,j;
=======
	public boolean[][] getReachableGrid(Chess[][] chessboard)
	{
		boolean reachable[][] = new boolean[8][8];
		
		int i = 0,j = 0;
		for(i=0;i<8;i++)
			for(j=0;j<8;j++)
				reachable[i][j] = false;
		
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
		for(i=1; i<8; i++)
		{
			if(x-i >= 0 && y-i>=0) //in the range
			{
				if(chessboard[x-i][y-i] == null) // reachable
				{
<<<<<<< HEAD
					moves.push(new Point(x-i,y-i));
				}
				else if(chessboard[x-i][y-i].camp != camp) // enemy chess
				{
					moves.push(new Point(x-i,y-i));
=======
					reachable[x-i][y-i] = true;
				}
				else if(chessboard[x-i][y-i].camp != camp) // enemy chess
				{
					reachable[x-i][y-i] = true;
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
					break;
				}
				else	break; 
			}
			
			else	break;
		}
		
		for(i=1; i<8; i++)
		{
			if(x-i >= 0 && y+i < 8 ) // in the range
			{
				if(chessboard[x-i][y+i] == null) //reachable
				{
<<<<<<< HEAD
					moves.push(new Point(x-i,y+i));
				}	
				else if (chessboard[x-i][y+i].camp != camp) // enemy chess
				{
					moves.push(new Point(x-i,y+i));
=======
					reachable[x-i][y+i] = true;
				}	
				else if (chessboard[x-i][y+i].camp != camp) // enemy chess
				{
					reachable[x-i][y+i] = true;
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
					break;
				}	
				else	break;
			}
			
			else	break;
		}
		
		for(i=1; i<8; i++)
		{
			if(x+i < 8 && y-i>=0) //in the range
			{
				if(chessboard[x+i][y-i] == null) // reachable
				{
<<<<<<< HEAD
					moves.push(new Point(x+i,y-i));
				}	
				else if (chessboard[x+i][y-i].camp != camp) // enemy chess
				{	
					moves.push(new Point(x+i,y-i));
=======
					reachable[x+i][y-i] = true;
				}	
				else if (chessboard[x+i][y-i].camp != camp) // enemy chess
				{	
					reachable[x+i][y-i] = true;
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
					break;
				}
				else break;
			}
			
			else	break;
		}
		
		for(i=1; i<8; i++)
		{
			if(x+i < 8 && y+i < 8) //in the range
			{
				if(chessboard[x+i][y+i] == null) // reachable
				{
<<<<<<< HEAD
					moves.push(new Point(x+i,y+i));
				}
				else if (chessboard[x+i][y+i].camp != camp) // enemy chess
				{
					moves.push(new Point(x+i,y+i));
=======
					reachable[x+i][y+i] = true;
				}
				else if (chessboard[x+i][y+i].camp != camp) // enemy chess
				{
					reachable[x+i][y+i] = true;
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
					break;
				}
				else	break;
			}
					
			else break;
		}
		
		
<<<<<<< HEAD
		moves.remove(new Point(x,y));
		
		return moves;
	}
	
	public boolean isReachable(Chess[][]chessboard,int Ix,int Iy)
	{
		Stack<Point> m = getReachableGrid(chessboard);
        return m.contains(new Point(Ix,Iy));
=======
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
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
	}
}
