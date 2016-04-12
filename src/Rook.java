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

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Rook extends Chess implements Cloneable{
	
	public Rook(String chessName,int x,int y,int camp){
		
		this.name = chessName;
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.critical = false;
		this.weight = 20;
<<<<<<< HEAD
		this.status = true;

=======
		
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
		setImage();
	}
	
	public Rook clone(){
		Rook k = new Rook(this.name,this.x,this.y,this.camp);
		return k;
	}
	
	@Override
	public void setImage() {
		// TODO Auto-generated method stub
		if(camp==0){
			chessPic = new ImageIcon("asset/img/druid_final.jpg");
			icon = new JLabel(chessPic);
		}
		else if(camp==1){
			chessPic = new ImageIcon("asset/img/volcanicdrag_final.jpg");
			icon = new JLabel(chessPic);
		}
	}
	public void setMusic(){
		AudioPlayer.player.stop(audioStream);
		if(camp==0){
			String song = "druid.wav";
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
			String song = "volcanodrag.wav";
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
			String song = "druid_dead.wav";
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
			String song = "volcanodrag_dead_final.wav";
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
<<<<<<< HEAD
	public Stack<Point> getReachableGrid(Chess[][] chessboard) {
		
		Stack<Point> moves = new Stack<Point>();
			
		int i = 0,j = 0;


		for(i=y+1;i<8;i++){
			if(chessboard[x][i]==null){
				moves.push(new Point(x,i));
			}
			else if(chessboard[x][i].camp!=camp){
				moves.push(new Point(x,i));
=======
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
				reachable[x][i] = true;
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
				break;
			}
			else{
				break;
			}
		}

		for(i=y-1;i>=0;i--){
			if(chessboard[x][i]==null)
<<<<<<< HEAD
				moves.push(new Point(x,i));
			else if(chessboard[x][i].camp!=camp){
				moves.push(new Point(x,i));
=======
				reachable[x][i] = true;
			else if(chessboard[x][i].camp!=camp){
				reachable[x][i] = true;
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
				break;
			}
			else break;
		}

		for(i=x+1;i<8;i++){
			if(chessboard[i][y]==null)
<<<<<<< HEAD
				moves.push(new Point(i,y));
			else if(chessboard[i][y].camp!=camp){
				moves.push(new Point(i,y));
=======
				reachable[i][y] = true;
			else if(chessboard[i][y].camp!=camp){
				reachable[i][y] = true;
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
				break;
			}
			else break;
		}

		for(i=x-1;i>=0;i--){
			if(chessboard[i][y]==null)
<<<<<<< HEAD
				moves.push(new Point(i,y));
			else if(chessboard[i][y].camp!=camp){
				moves.push(new Point(i,y));
=======
				reachable[i][y] = true;
			else if(chessboard[i][y].camp!=camp){
				reachable[i][y] = true;
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
				break;
			}
			else break;
		}

<<<<<<< HEAD
		moves.remove(new Point(x,y));
		
		return moves;
	}

	@Override
	public boolean isReachable(Chess[][]chessboard,int Ix,int Iy){
		Stack<Point> m = getReachableGrid(chessboard);
        return m.contains(new Point(Ix,Iy));
=======
		reachable[x][y] = false;
		
		return reachable;
	}

	@Override
	public boolean isReachable(Chess[][]chessboard,int Ix,int Iy)
	{
		boolean reach = false;
		boolean[][] reachable;
		int i, j;
		
		reachable = getReachableGrid(chessboard);
		return reachable[Ix][Iy];
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
	}

}
