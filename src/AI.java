import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JTextPane;


public class AI {
	
	private boolean strikeFever;
	private int camp;
	private Chess tc;
	private Stack bestChoices;
	private Point move;
	private int score;
	private int bestX,bestY;
	private int depth;
	private int thiscamp;
	private Chess[][] cloneBoard;
	
	public AI(int camp){
		score = 0;
		this.camp = camp;
		thiscamp = camp;
		depth = 8;
		cloneBoard = new Chess[8][8];
	}
	
	public void setChessBoard(Chess[][] chessBoard){
		int i,j;
		for(i=0;i<8;i++){
			for(j=0;j<8;j++){
				if(chessBoard[i][j]!=null){
					cloneBoard[i][j] = chessBoard[i][j].clone();
				}
				else{
					cloneBoard[i][j] = null;
				}
			}
		}
	}
	
	public Point getChoice(){
		return move;
	}
	
	private int MiniMax(int d){
	
		int i,j,k,l;
		boolean[][] mr;
		if(d < depth){
			if(thiscamp == camp){//Get MAX
				thiscamp++;
				int max = -9999;
				for(i=0;i<8;i++){
					for(j=0;j<8;j++){
						if(cloneBoard[i][j]!=null&&cloneBoard[i][j].camp==camp){
							mr = cloneBoard[i][j].getReachableGrid(cloneBoard);
							for(k=0;k<8;k++){
								for(l=0;l<8;l++){
									if(mr[k][l]==true){
										if(cloneBoard[k][l]!=null){
											score = MiniMax(d-1);
										}

									}
								}
							}
							
						}
					}
				}
			}
			else{//Get Min
				thiscamp--;
				int Min = 9999;
				for(i=0;i<8;i++){
					for(j=0;j<8;j++){
						if(cloneBoard[i][j]!=null&&cloneBoard[i][j].camp!=camp){
							mr = cloneBoard[i][j].getReachableGrid(cloneBoard);
							for(k=0;k<8;k++){
								for(l=0;l<8;l++){
									if(mr[k][l]==true){
										
									}
								}
							}
						}
					}
				}	
			}
		}
		else{
			return score;
		}
		return 1;
		
	}
	
	public void changeImage(JLabel lbl){
		
	}
	
	public void say(JTextPane txt){
		
	}
	

}
