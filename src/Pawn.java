import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Pawn extends Chess{

	
	public Pawn(String chessName,int x,int y,int camp){
		
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
		if(camp==0){
			chessPic = new ImageIcon("soldier_final.jpg");
			icon = new JLabel(chessPic);
		}
		else if(camp==1){
			chessPic = new ImageIcon("littledrag_final.jpg");
			icon = new JLabel(chessPic);
		}
	}
	public void setMusic(){
		if(camp==1){
			String song = "soldier.wav";
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
			String song = "littledrag.wav";
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
