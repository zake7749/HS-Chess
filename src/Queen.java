import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Queen extends Chess implements Cloneable{

	public Queen(String chessName,int x,int y,int camp){
		
		this.name = chessName;
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.critical = false;
		this.weight = 28;
		
		setImage();
	}
	
	public Queen clone(){
		Queen k = new Queen(this.name,this.x,this.y,this.camp);
		return k;
	}
	
	public void setImage()
	{
		if(camp==0){
			chessPic = new ImageIcon("sv_final.jpg");
			icon = new JLabel(chessPic);
		}
		else if(camp==1){
			chessPic = new ImageIcon("daughter_final.jpg");
			icon = new JLabel(chessPic);
		}
	}
	public void setMusic(){
		AudioPlayer.player.stop(audioStream);
		if(camp==0){
			String song = "sv.wav";
			InputStream in;
			try {
				in = new FileInputStream(song);
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
			String song = "daughter.wav";
			InputStream in;
			try {
				in = new FileInputStream(song);
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
			String song = "sv_dead.wav";
			InputStream in;
			try {
				in = new FileInputStream(song);
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
			String song = "daughter_dead.wav";
			InputStream in;
			try {
				in = new FileInputStream(song);
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
	public boolean[][] getReachableGrid(Chess[][] chessboard)
	{
		boolean reachable[][] = new boolean[8][8];
		
		int i = 0,j = 0;
		for(i=0;i<8;i++)
			for(j=0;j<8;j++)
				reachable[i][j] = false;
		
		//Rook
		for(i=y+1;i<8;i++){
			if(chessboard[x][i]==null){
				reachable[x][i] = true;
			}
			else if(chessboard[x][i].camp!=camp){
				System.out.println("I SHOCK YOU!");
				reachable[x][i] = true;
				break;
			}
			else{
				System.out.println("I SHOCK YOU!");
				break;
			}
		}

		for(i=y-1;i>=0;i--){
			if(chessboard[x][i]==null)
				reachable[x][i] = true;
			else if(chessboard[x][i].camp!=camp){
				reachable[x][i] = true;
				break;
			}
			else break;
		}

		for(i=x+1;i<8;i++){
			if(chessboard[i][y]==null)
				reachable[i][y] = true;
			else if(chessboard[i][y].camp!=camp){
				reachable[i][y] = true;
				break;
			}
			else break;
		}

		for(i=x-1;i>=0;i--){
			if(chessboard[i][y]==null)
				reachable[i][y] = true;
			else if(chessboard[i][y].camp!=camp){
				reachable[i][y] = true;
				break;
			}
			else break;
		}
		
		//Bishop		
		
		for(i=1; i<8; i++)
		{
			if(x-i >= 0 && y-i>=0) //in the range
			{
				if(chessboard[x-i][y-i] == null) // reachable
				{
					reachable[x-i][y-i] = true;
				}
				else if(chessboard[x-i][y-i].camp != camp) // enemy chess
				{
					reachable[x-i][y-i] = true;
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
					reachable[x-i][y+i] = true;
				}	
				else if (chessboard[x-i][y+i].camp != camp) // enemy chess
				{
					reachable[x-i][y+i] = true;
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
					reachable[x+i][y-i] = true;
				}	
				else if (chessboard[x+i][y-i].camp != camp) // enemy chess
				{	
					reachable[x+i][y-i] = true;
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
					reachable[x+i][y+i] = true;
				}
				else if (chessboard[x+i][y+i].camp != camp) // enemy chess
				{
					reachable[x+i][y+i] = true;
					break;
				}
				else	break;
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
