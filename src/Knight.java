import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Knight extends Chess{

	int[] moveX = {-2,-1,1,2,-2,-1,1,2};
	int[] moveY = {1,2,2,1,-1,-2,-2,-1};
	
	@Override
	public void setImage() {
		// TODO Auto-generated method stub
		if(camp==1){
			chessPic = new ImageIcon("faith_final.jpg");
			icon = new JLabel(chessPic);
		}
		else if(camp==2){
			chessPic = new ImageIcon("hungrydrag_final.jpg");
			icon = new JLabel(chessPic);
		}
	}
	public void setMusic(){
		if(camp==1){
			String song = "faith.wav";
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
			String song = "hungrydrag.wav";
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
		for(i=0;i<8;i++){
			if(x+moveX[i]>=0&&x+moveX[i]<8&&y+moveY[i]>=0&&y+moveY[i]<8){
				if(chessboard[x+moveX[i]][y+moveY[i]]==null)
					reachable[x+moveX[i]][y+moveY[i]] = true;
				else if(chessboard[x+moveX[i]][y+moveY[i]].camp!=camp){
					reachable[x+moveX[i]][y+moveY[i]] = true;
				}
			}
		}
		return reachable;
	}

	@Override
	public boolean isReachable(Chess[][] chessboard, int lx, int ly) {
		
		int i;
		boolean res;
		for(i=0;i<8;i++){
			if(x+moveX[i]>=0&&x+moveX[i]<8&&y+moveY[i]>=0&&y+moveY[i]<8){
				if(x+moveX[i]==lx&&y+moveY[i]==ly){
					if(chessboard[lx][ly]==null){
						res = true;
					}else if(chessboard[lx][ly].camp!=camp){
						res = true;
					}
				}
			}
		}
		return false;
	}

}
