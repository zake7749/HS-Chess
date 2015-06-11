import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JTextPane;


public class AI {
	
	private boolean strikeFever;
	private int camp;
	private Stack bestChoices;
	private Point move;

	private int bestX,bestY;
	private int selectX,selectY;
	private int depth;
	private Chess[][] cloneBoard;
	
	public AI(int camp){
		this.camp = camp;
		depth = 4;
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
		move = new Point(bestX,bestY);
		return move;
	}
	
	public Point getSelected(){
		Point t = new Point(selectX,selectY);
		return t;
	}
	

	public int MiniMax(int d, boolean Computer){
	
		int i,j,k,l;
		int thiscamp = Computer ? 1 : 0;
		int score = 0;
		int bestChoiceforC = -9999999;
		int bestChoiceforP = 9999999;

		boolean[][] mr;
		if(d < depth){
			for(i=7;i>=0;i--){
				for(j=7;j>=0;j--){
					if(cloneBoard[i][j]!=null&&cloneBoard[i][j].camp == thiscamp){
						//There is a chess.
						//generate all steps of focused chess.
						mr = cloneBoard[i][j].getReachableGrid(cloneBoard);
						for(k=0;k<8;k++){
							for(l=0;l<8;l++){
								if(mr[k][l]){
									Chess tc = null;
									if(cloneBoard[k][l]!=null){
										//Store the chess is goind to remove.
											tc = cloneBoard[k][l];
									}
									//Store the chess I focused, i.e chess[i][j].
									Chess fc = cloneBoard[i][j];
									//Move focused chess from i,j to k,l;
									cloneBoard[k][l] = cloneBoard[i][j];
									cloneBoard[i][j] = null;
									if(Computer){
										score = MiniMax(d+1,false);
									}
									else{
										score = MiniMax(d+1,true);
									}
									
									if(tc!=null){
										cloneBoard[k][l] = tc;
									}
									else{
										cloneBoard[k][l] = null;
									}
									cloneBoard[i][j] = fc;
									
									if(Computer){
										if(score>bestChoiceforC){
											bestChoiceforC = score;
											if(d==0){
												System.out.println("GG");
												selectX = i;
												selectY = j;
												bestX = k;
												bestY = l;
											}
											//System.out.println("GG");
										}

									}
									else{
										if(score<bestChoiceforP){
											bestChoiceforP = score;
										}
									}
								}
							}
						}
					}
				}
			}
			if(Computer){
				return bestChoiceforC;
			}
			else{
				return bestChoiceforP;
			}
		}
		else{
			return survey(cloneBoard);
		}
	}
	

	
	private int survey(Chess[][] cB) {
		int i,j;
		int score = 0;
		for(i=0;i<8;i++){
			for(j=0;j<8;j++){
				if(cB[i][j]!=null){
					if(cB[i][j].camp==camp){
						score += cB[i][j].getWeight();
					}
					else{
						score -= cB[i][j].getWeight();
					}
				}
			}
		}
		return score;
	}

}
