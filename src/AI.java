import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JTextPane;


public class AI {
	
	private int camp;
	private Point move;

	private Chess[] com,player;
	
	private int bestX,bestY;
	private int selectX,selectY;
	private int depth;
	private Chess[][] cloneBoard;
	
	public AI(int camp){
		this.camp = camp;
		depth = 7;
		com = new Chess[16];
		player = new Chess[16];
		cloneBoard = new Chess[8][8];
	}
	
	public void setChessBoard(Chess[][] chessBoard){
		
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
	}
	
	
	public Point getChoice(){
		move = new Point(bestX,bestY);
		System.out.println("Best X:"+bestX+"\tY:"+bestY);
		return move;
	}
	
	public Point getSelected(){
		Point t = new Point(selectX,selectY);
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
	}
	

	
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
		}
		return score;
	}

}
