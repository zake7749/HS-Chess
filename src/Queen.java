import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

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
		this.status = true;

		setImage();
	}
	
	public Queen clone(){
		Queen k = new Queen(this.name,this.x,this.y,this.camp);
		return k;
	}
	
	public void setImage()
	{
		if(camp==0){
			chessPic = new ImageIcon("asset/img/sv_final.jpg");
			icon = new JLabel(chessPic);
		}
		else if(camp==1){
			chessPic = new ImageIcon("asset/img/daughter_final.jpg");
			icon = new JLabel(chessPic);
		}
	}
	public void setMusic(){
		AudioPlayer.player.stop(audioStream);
		if(camp==0){
			String song = "sv.wav";
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
			String song = "daughter.wav";
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
			String song = "sv_dead.wav";
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
			String song = "daughter_dead.wav";
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
	public Stack<Point> getReachableGrid(Chess[][] chessboard)
	{
		Stack<Point> moves = new Stack<Point>();
		
		int i = 0,j = 0;

		//Rook
		for(i=y+1;i<8;i++){
			if(chessboard[x][i]==null){
				moves.push(new Point(x,i));
			}
			else if(chessboard[x][i].camp!=camp){
				moves.push(new Point(x,i));
				break;
			}
			else{
				break;
			}
		}

		for(i=y-1;i>=0;i--){
			if(chessboard[x][i]==null)
				moves.push(new Point(x,i));
			else if(chessboard[x][i].camp!=camp){
				moves.push(new Point(x,i));
				break;
			}
			else break;
		}

		for(i=x+1;i<8;i++){
			if(chessboard[i][y]==null)
				moves.push(new Point(i,y));
			else if(chessboard[i][y].camp!=camp){
				moves.push(new Point(i,y));
				break;
			}
			else break;
		}

		for(i=x-1;i>=0;i--){
			if(chessboard[i][y]==null)
				moves.push(new Point(i,y));
			else if(chessboard[i][y].camp!=camp){
				moves.push(new Point(i,y));
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
					moves.push(new Point(x-i,y-i));
				}
				else if(chessboard[x-i][y-i].camp != camp) // enemy chess
				{
					moves.push(new Point(x-i,y-i));
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
					moves.push(new Point(x-i,y+i));
				}	
				else if (chessboard[x-i][y+i].camp != camp) // enemy chess
				{
					moves.push(new Point(x-i,y+i));
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
					moves.push(new Point(x+i,y-i));
				}	
				else if (chessboard[x+i][y-i].camp != camp) // enemy chess
				{	
					moves.push(new Point(x+i,y-i));
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
					moves.push(new Point(x+i,y+i));
				}
				else if (chessboard[x+i][y+i].camp != camp) // enemy chess
				{
					moves.push(new Point(x+i,y+i));
					break;
				}
				else	break;
			}
					
			else break;
		}
		
		
		moves.remove(new Point(x,y));
		
		return moves;
	}
	
	public boolean isReachable(Chess[][]chessboard,int Ix,int Iy)
	{
		Stack<Point> m = getReachableGrid(chessboard);
        return m.contains(new Point(Ix,Iy));
	}
}
