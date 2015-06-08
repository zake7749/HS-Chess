import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Rock extends Chess{
	
	
	public Rock(String chessName,int x,int y,int camp){
		
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
			chessPic = new ImageIcon("druid_final.jpg");
			icon = new JLabel(chessPic);
		}
		else if(camp==1){
			chessPic = new ImageIcon("volcanicdrag_final.jpg");
			icon = new JLabel(chessPic);
		}
	}
	public void setMusic(){
		if(camp==1){
			String song = "druid.wav";
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
			String song = "volcanodrag.wav";
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

		reachable[x][y] = false;
		
		return reachable;
	}

	@Override
	public boolean isReachable(Chess[][] chessboard, int lx, int ly) {
		
		boolean res = false;
		int i;
		
		if(x==lx||y==ly){
			if(x==lx){
				for(i=lx;i<8;i++){
					if((chessboard[x][i]==null)){
						if(i==ly)
							res = true;
					}else if(chessboard[x][i].camp!=camp){
						if(i==ly){
							res = true;
							break;
						}
					}else break;
				}
			}
			else{
				for(i=ly;i<8;i++){
					if((chessboard[i][y]==null)){
						if(i==lx)
							res = true;
					}else if(chessboard[i][y].camp!=camp){
						if(i==lx){
							res = true;
							break;
						}
					}else break;
				}
			}
		}
		
		return res;
	}

}
