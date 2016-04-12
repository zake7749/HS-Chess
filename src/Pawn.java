import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Pawn extends Chess implements Cloneable{

	boolean isKing;
	
	public Pawn(String chessName,int x,int y,int camp){
		
		this.name = chessName;
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.critical = false;
		this.weight = 8;
		this.isKing = false;
		firstStep = true;
		this.status = true;

		setImage();
	}
	
	public Pawn clone(){
		Pawn k = new Pawn(this.name,this.x,this.y,this.camp);
		return k;
	}
	
	@Override
	public int getWeight(){
		if(isKing){
			return 16;
		}else{
			return 8;
		}
	}
	
	@Override
	public void setImage() {
		// TODO Auto-generated method stub
		if(camp==0){
			chessPic = new ImageIcon("asset/img/soldier_final.jpg");
			icon = new JLabel(chessPic);
		}
		else if(camp==1){
			chessPic = new ImageIcon("asset/img/littledrag_final.jpg");
			icon = new JLabel(chessPic);
		}
	}
	public void setMusic(){
		AudioPlayer.player.stop(audioStream);
		if(camp==0){
			String song = "soldier.wav";
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
			String song = "littledrag.wav";
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
			String song = "soldier_dead.wav";
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
			String song = "littledrag_dead_final.wav";
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

		if(!isKing){
			if(camp==0){
				if(y==0){
					isKing = true;
				}
				//Human
				if(x-1>=0&&y-1>=0){
					if(chessboard[x-1][y-1]!=null&&chessboard[x-1][y-1].camp!=camp){
						moves.push(new Point(x-1,y-1));
					}
				}
				if(x+1<8&&y-1>=0){
					if(chessboard[x+1][y-1]!=null&&chessboard[x+1][y-1].camp!=camp){
						moves.push(new Point(x+1,y-1));
					}
				}
				if(y-1>=0){
					if(chessboard[x][y-1]==null)
						moves.push(new Point(x,y-1));
				}
				if(firstStep){
					if(y-2>=0 && chessboard[x][y-1]==null && chessboard[x][y-2]==null)
						moves.push(new Point(x,y-2));
				}
			}
			else{
				if(y==7){
					isKing = true;
				}
				//Dragon
				if(x-1>=0&&y+1<8){
					if(chessboard[x-1][y+1]!=null&&chessboard[x-1][y+1].camp!=camp){
						moves.push(new Point(x-1,y+1));
					}
				}
				if(x+1<8&&y+1<8){
					if(chessboard[x+1][y+1]!=null&&chessboard[x+1][y+1].camp!=camp){
						moves.push(new Point(x+1,y+1));
					}
				}
				if(y+1<8){
					if(chessboard[x][y+1]==null)
						moves.push(new Point(x,y+1));
				}
				if(firstStep){
					if(y+2<8 && chessboard[x][y+1]==null && chessboard[x][y+2]==null)
						moves.push(new Point(x,y+2));

				}
			}
		}
		else{
			for(i=x-1;i<=x+1;i++){
				for(j=y-1;j<=y+1;j++){
					if(i>=0&&j>=0&&i<8&&j<8)
					{
						if(chessboard[i][j]==null)
							moves.push(new Point(i,j));
						else if(chessboard[i][j].camp!=camp)
							moves.push(new Point(i,j));
					}
				}
			}
		}
		return moves;
	}

	@Override
	public boolean isReachable(Chess[][] chessboard, int lx, int ly) {
		
		Stack<Point> m = getReachableGrid(chessboard);
        return m.contains(new Point(lx,ly));
	}

}
