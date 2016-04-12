import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Knight extends Chess implements Cloneable{

	int[] moveX = {-2,-1,1,2,-2,-1,1,2};
	int[] moveY = {1,2,2,1,-1,-2,-2,-1};
	
	public Knight(String chessName, int x, int y, int camp) {
		
		this.name = chessName;
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.critical = false;
		this.weight = 12;
		this.status = true;
		setImage();
	}
	
	public Knight clone(){
		Knight k = new Knight(this.name,this.x,this.y,this.camp);
		return k;
	}
	
	@Override
	public void setImage() {
		// TODO Auto-generated method stub
		if(camp==0){
			chessPic = new ImageIcon("asset/img/faith_final.jpg");
			icon = new JLabel(chessPic);
		}
		else if(camp==1){
			chessPic = new ImageIcon("asset/img/hungrydrag_final.jpg");
			icon = new JLabel(chessPic);
		}
	}
	public void setMusic(){
		AudioPlayer.player.stop(audioStream);
		if(camp==0){
			String song = "faith.wav";
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
			String song = "hungrydrag.wav";
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
			String song = "faith_dead.wav";
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
			String song = "hungrydrag_dead_final.wav";
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
	
		for(i=0;i<8;i++){
			if(x+moveX[i]>=0&&x+moveX[i]<8&&y+moveY[i]>=0&&y+moveY[i]<8){
				if(chessboard[x+moveX[i]][y+moveY[i]]==null)
					moves.push(new Point(x+moveX[i],y+moveY[i]));
				else if(chessboard[x+moveX[i]][y+moveY[i]].camp!=camp){
					moves.push(new Point(x+moveX[i],y+moveY[i]));
				}
			}
		}
		return moves;
	}

	@Override
	public boolean isReachable(Chess[][]chessboard,int Ix,int Iy)
	{
		Stack<Point> m = getReachableGrid(chessboard);
        return m.contains(new Point(Ix,Iy));
	}

}
