import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class King extends Chess implements Cloneable{

	public King(String chessName, int x, int y, int camp) {
		
		this.name = chessName;
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.critical = true;
		this.weight = 99999;
		this.status = true;

		setImage();
	}

	public King clone(){
		King k = new King(this.name,this.x,this.y,this.camp);
		return k;
	}
	
	
	@Override
	public void setImage() {
		// TODO Auto-generated method stub
		if(camp==0){
			chessPic = new ImageIcon("asset/img/kyan_final.jpg");
			icon = new JLabel(chessPic);
		}
		else if(camp==1){
			chessPic = new ImageIcon("asset/img/deadwing_final.jpg");
			icon = new JLabel(chessPic);
		}
		
	}
	public void setMusic(){
		AudioPlayer.player.stop(audioStream);
		if(camp==0){
			String song = "kyan.wav";
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
			String song = "deadwing.wav";
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
			String song = "kyan_dead.wav";
			InputStream in;
			try {
				in = new FileInputStream(rootPath+song);
				System.out.println(rootPath+song);
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
			String song = "deadwing_dead.wav";
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

	@Override
	public Stack<Point> getReachableGrid(Chess[][] chessboard) {
		
		Stack<Point> moves = new Stack<Point>();
		
		int i = 0,j = 0;
		
		for(i=x-1;i<=x+1;i++){
			for(j=y-1;j<=y+1;j++){
				if(i>=0&&j>=0&&i<8&&j<8)
				{
					if(chessboard[i][j]==null)
						moves.add(new Point(i,j));
					else if(chessboard[i][j].camp!=camp)
						moves.add(new Point(i,j));
				}
			}
		}
		moves.remove(new Point(i,j));
		
		return moves;
	}

	@Override
	public boolean isReachable(Chess[][] chessboard, int dx, int dy) {
		
		int i,j;
		boolean res = false;
		
		for(i=x-1;i<=x+1;i++){
			for(j=y-1;j<=y+1;j++){
				if((i>=0&&j>=0&&i<8&&j<8)&&(i==dx&&j==dy)){
					if(chessboard[i][j]==null)
						res = true;
					else if(chessboard[i][j].camp!=camp)
						res = true;
				}
			}
		}
		return res;
	}
	
}
