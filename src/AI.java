import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
=======
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JTextPane;


public class AI {
	
<<<<<<< HEAD
	private int camp;
	private Point move;

	private Chess[] com,player;
	
=======
	private boolean strikeFever;
	private int camp;
	private Stack bestChoices;
	private Point move;

>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
	private int bestX,bestY;
	private int selectX,selectY;
	private int depth;
	private Chess[][] cloneBoard;
	
	public AI(int camp){
		this.camp = camp;
<<<<<<< HEAD
		depth = 7;
		com = new Chess[16];
		player = new Chess[16];
=======
		depth = 4;
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
		cloneBoard = new Chess[8][8];
	}
	
	public void setChessBoard(Chess[][] chessBoard){
<<<<<<< HEAD
		
		int i,j;
		
		for(i=0;i<16;i++){
			com[i] = null;
			player[i] = null;
		}

		
		int ti=0,tj=0;
		for(i=0;i<8;i++){
			for(j=0;j<8;j++){
				if(chessBoard[i][j]!=null && chessBoard[i][j].camp == this.camp){
					cloneBoard[i][j] = chessBoard[i][j].clone();
					com[ti++] = cloneBoard[i][j];
				}
				else if(chessBoard[i][j]!=null){
					cloneBoard[i][j] = chessBoard[i][j].clone();
					player[tj++] = cloneBoard[i][j];

				}
			}
		}

		/* Sort by weight */
		Chess tp = null; 

	    for(i = 1; i < 16; i++){
	    	tp = com[i];
	        for( j=i; j > 0 && tp.weight > com[j-1].weight; j-- )
	        	com[j] = com[j-1];        
	        com[j] = tp;
	    }
	    
	    for(i = 1; i < 16; i++){
	    	tp = player[i];
	        for( j=i; j > 0 && tp.weight > player[j-1].weight; j-- )
	        	player[j] = player[j-1];        
	        player[j] = tp;
	    }

	    for(i=0;i<16;i++){
	    	System.out.println(com[i].name);
	    }
	    
	}
	
	
	public Point getChoice(){
		move = new Point(bestX,bestY);
		System.out.println("Best X:"+bestX+"\tY:"+bestY);
=======
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
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
		return move;
	}
	
	public Point getSelected(){
		Point t = new Point(selectX,selectY);
<<<<<<< HEAD
		System.out.println("Select X:"+selectX+"\tY:"+selectY);

		return t;
	}
	
	private void moveAChessTo(Chess c,int i,int j){
		int oldx = c.getX();
		int oldy = c.getY();
		c.moveXY(i, j, 1);
		cloneBoard[i][j] = c;
		cloneBoard[oldx][oldy] = null;
	}
	
	private Chess removeAChess(int i,int j){
		
		if(cloneBoard[i][j]!=null){

			Chess c = cloneBoard[i][j];
			cloneBoard[i][j] = null;
			c.removed();
			return c;
		}
		return null;
	}
	
	private void restoreAChess(Chess c,int i,int j){
		
		if(c != null){
			c.alive();
			c.moveXY(i, j, 1);
			cloneBoard[i][j] = c;
		}else{
			cloneBoard[i][j] = null;
		}
	}
	
	/*
	 * Camp:
	 * 	0 : Player's turn
	 * 	1 : Computer's turn
	 */
	
	
	int alphaBetaMax( int alpha, int beta, int d ) {
		
		if(d == depth)
			return survey();
		
		int score = 0;
		Stack<Point> moves;//store all available steps for the selected chess.
		Chess c = null;
	
		for(int li=0;li<16;li++){
			c = com[li];
			if(c == null || !c.status)
				continue;

			moves = c.getReachableGrid(cloneBoard);
			for(Point mr : moves){
				
				int i = c.getX();
				int j = c.getY();
				
				/* Store the chess has removed. */
				Chess tc = removeAChess(mr.x,mr.y);

				/* move chess C from (i,j) -> (mr.x,mr.y) */
				moveAChessTo(c,mr.x,mr.y);
				/* if target is the king. No need to cont. */
				if(tc!=null && tc.critical){
					score += tc.weight;
				}else{
					/* dfs */
					score =  alphaBetaMin(alpha, beta, d+1);
				}
				/* Back-tracking */
				moveAChessTo(c,i,j);
				restoreAChess(tc,mr.x,mr.y);
				if(score >= beta){
					return beta;
				}
				if(score > alpha){
					alpha = score;
					if(d==0){
						selectX = i;
						selectY = j;
						bestX = mr.x;
						bestY = mr.y;
					}
				}
			}
		}
		return alpha;
	}
	
	int alphaBetaMin( int alpha, int beta, int d ) {
		
	   if ( d == depth )
		   return survey();
	   
	   Chess c = null;
	   Stack<Point> moves;//store all available steps for the selected chess.
	   int score = 0;
	   
	   for(int li=0;li<16;li++){
		   c = player[li];
		   if(c == null || !c.status)
			   continue;

		   moves = c.getReachableGrid(cloneBoard);
		   for(Point mr : moves){
				
				int i = c.getX();
				int j = c.getY();
				
				/* Store the chess has removed. */
				Chess tc = removeAChess(mr.x,mr.y);
				/* move chess C from (i,j) -> (mr.x,mr.y) */
				moveAChessTo(c,mr.x,mr.y);
				
				/* if target is the king. No need to cont. */
				if(tc!=null && tc.critical){
					score -=  tc.weight;
				}else{
					/* dfs */
					score =  alphaBetaMax(alpha, beta, d+1);
				}
				/* Back-tracking */
				moveAChessTo(c,i,j);
				restoreAChess(tc,mr.x,mr.y);
				
				if(score <= alpha){
					return alpha;
				}
				if(score < beta)
					beta = score;
			}
	   }
	   return beta;
=======
		return t;
	}
	

	public int MiniMax(int d, boolean Computer){
	
		int i,j,k,l;
		int thiscamp = Computer ? 1 : 0;
		int score = 0;
		int bestChoiceforC = -9999999;
		int bestChoiceforP = 9999999;

		boolean[][] mr;//store all available steps for the selected chess.
		if(d < depth){
			for(i=7;i>=0;i--){
				for(j=7;j>=0;j--){
					if(cloneBoard[i][j]!=null&&cloneBoard[i][j].camp == thiscamp){
						//generate all steps of the focused chess.
						mr = cloneBoard[i][j].getReachableGrid(cloneBoard);
						for(k=0;k<8;k++){
							for(l=0;l<8;l++){
								if(mr[k][l]){
									//(i,j) -> (k,l)
									
									//Store the chess is going to remove.
									Chess tc = null;
									if(cloneBoard[k][l]!=null){
										tc = cloneBoard[k][l];
									}
									
									//if target is king. No need to cont.
									if(tc!=null&&tc.weight>999998){
										score = Computer ? 9999999 : -9999999;
									}else{

										Chess fc = cloneBoard[i][j];
										//Move focused chess from i,j to k,l;
										cloneBoard[k][l] = cloneBoard[i][j];
										cloneBoard[i][j] = null;
										
										/* dfs */
										score = Computer ? MiniMax(d+1,false) : MiniMax(d+1,true);

										/* back-tracking */
										cloneBoard[k][l] = (tc!=null) ? tc : null;
										cloneBoard[i][j] = fc;
									}
									
									if(Computer){
										if(score>=bestChoiceforC){
											bestChoiceforC = score;
											if(d==0){
												//System.out.println("GG");
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
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
	}
	

	
<<<<<<< HEAD
	private int survey() {
		
		int score = 0;
		for (int i=0;i<16;i++) {
			if(com[i]==null || !com[i].status)
				continue;
			score += com[i].weight;
		}
		for (int i=0;i<16;i++) {
			if(player[i]==null || !player[i].status)
				continue;
			score -= player[i].weight;
=======
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
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
		}
		return score;
	}

}
