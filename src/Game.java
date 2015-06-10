import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Graphics;//
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;//
import java.awt.event.ActionEvent;
import javax.swing.JButton;//

public class Game extends JFrame implements MouseListener , ActionListener{//test

	private JPanel contentPane;
	private JLabel chessBoardpic; 
	private JLabel DebugText;
	private JLabel MilesEdgeworth;
	private JTextPane textPane;
	private String debugMessage;
	private Chess[][] chessBoard;
	private JLabel testP;
	
	private JPanel panel_2,panel_3;
	//my code
	private int state;
	private int nowcamp;
	private int stateX, stateY;
	JPanel[][] color;
	//my code
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 875, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.addMouseListener(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DebugText = new JLabel("Debug Test :");
		DebugText.setBounds(5, 642, 824, 15);
		DebugText.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(DebugText);

		chessBoardpic = new JLabel("");
		chessBoardpic.setBounds(5, 5, 605, 637);
		chessBoardpic.setIcon(new ImageIcon("ChessBoard.png"));
		contentPane.add(chessBoardpic);		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		panel.setBounds(620, 21, 229, 360);
		contentPane.add(panel);
		panel.setLayout(null);
		
		MilesEdgeworth = new JLabel("");
		MilesEdgeworth.setBounds(10, 10, 209, 245);
		panel.add(MilesEdgeworth);
		
		textPane = new JTextPane();
		textPane.setForeground(new Color(0, 128, 0));
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setBounds(10, 265, 209, 85);
		panel.add(textPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(620, 390, 230, 230);
		panel_1.setLayout(null);
		contentPane.add(panel_1);
		
		panel_2 = new JPanel();		
		JTextArea campName = new JTextArea();
		campName.setBackground(Color.BLACK);
		Font font = new Font("Verdana", Font.BOLD, 20);
		campName.setFont(font);
		campName.setForeground(Color.white);
		campName.setText("Humans Alliance");
		panel_2.setBounds(10, 95, 210, 40);
		panel_2.add(campName);
		panel_1.add(panel_2);//
		
		panel_3 = new JPanel();//
		JTextArea campName2 = new JTextArea();
		campName2.setBackground(Color.BLACK);
		campName2.setFont(font);
		campName2.setForeground(Color.white);
		campName2.setText("Dark Dragon");
		panel_3.setBounds(10, 95, 210, 40);
		panel_3.add(campName2);
		panel_1.add(panel_3);//
		panel_3.setVisible(false);
		
		JMenu menu = new JMenu("Menu");
		JMenuItem newGame = new JMenuItem("Game Start");
	//	JMenuItem undo = new JMenuItem("");
	//	JMenuItem surrender = new JMenuItem("");
		newGame.addActionListener(this);//test
	//	item2.addActionListener(new MyButtonListener());
		menu.add(newGame);
	//	menu.add(undo);
	//	menu.add(surrender);
	//	JMenu mode = new JMenu("");
	//	JMenuItem one = new JMenuItem("");
	//	JMenuItem two = new JMenuItem("");
	//	mode.add(one);
	//	mode.add(two);
		JMenuBar bar = new JMenuBar();
		bar.add(menu);
	//	bar.add(mode);
		this.setJMenuBar(bar);
		this.setVisible(true);

		//my code
		
		chessBoard = new Chess[8][8];
		
		chessBoard[4][7] = new King("wKing",4,7,0);//test
		chessBoard[4][7].setImage();
		chessBoard[4][7].icon.setBounds((chessBoard[4][7].x)*70+19,(chessBoard[4][7].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[4][7].icon);
		
		chessBoard[3][0] = new King("bKing",3,0,1);//test
		chessBoard[3][0].setImage();
		chessBoard[3][0].icon.setBounds((chessBoard[3][0].x)*70+19,(chessBoard[3][0].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[3][0].icon);
		
		chessBoard[3][7] = new Queen("wQueen",3,7,0);//test
		chessBoard[3][7].setImage();
		chessBoard[3][7].icon.setBounds((chessBoard[3][7].x)*70+19,(chessBoard[3][7].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[3][7].icon);
		
		chessBoard[4][0] = new Queen("bQueen",4,0,1);//test
		chessBoard[4][0].setImage();
		chessBoard[4][0].icon.setBounds((chessBoard[4][0].x)*70+19,(chessBoard[4][0].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[4][0].icon);
		
		for(int i = 0; i < 8; i++){
			chessBoard[i][1] = new Pawn("bPawn",i,1,1);//test
			chessBoard[i][1].setImage();
			chessBoard[i][1].icon.setBounds((chessBoard[i][1].x)*70+19,(chessBoard[i][1].y)*70+39,70,70);
			chessBoardpic.add(chessBoard[i][1].icon);
		}
		
		for(int i = 0; i < 8; i++){
			chessBoard[i][6] = new Pawn("wPawn",i,6,0);//test
			chessBoard[i][6].setImage();
			chessBoard[i][6].icon.setBounds((chessBoard[i][6].x)*70+19,(chessBoard[i][6].y)*70+39,70,70);
			chessBoardpic.add(chessBoard[i][6].icon);
		}
		
		chessBoard[0][0] = new Rock("bRock",0,0,1);//test
		chessBoard[0][0].setImage();
		chessBoard[0][0].icon.setBounds((chessBoard[0][0].x)*70+19,(chessBoard[0][0].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[0][0].icon);
		chessBoard[7][0] = new Rock("bRock",7,0,1);//test
		chessBoard[7][0].setImage();
		chessBoard[7][0].icon.setBounds((chessBoard[7][0].x)*70+19,(chessBoard[7][0].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[7][0].icon);
		
		chessBoard[0][7] = new Rock("wRock",0,7,0);//test
		chessBoard[0][7].setImage();
		chessBoard[0][7].icon.setBounds((chessBoard[0][7].x)*70+19,(chessBoard[0][7].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[0][7].icon);
		chessBoard[7][7] = new Rock("wRock",7,7,0);//test
		chessBoard[7][7].setImage();
		chessBoard[7][7].icon.setBounds((chessBoard[7][7].x)*70+19,(chessBoard[7][7].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[7][7].icon);
		
		chessBoard[1][0] = new Knight("bKnight",1,0,1);//test
		chessBoard[1][0].setImage();
		chessBoard[1][0].icon.setBounds((chessBoard[1][0].x)*70+19,(chessBoard[1][0].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[1][0].icon);
		chessBoard[6][0] = new Knight("bKnight",6,0,1);//test
		chessBoard[6][0].setImage();
		chessBoard[6][0].icon.setBounds((chessBoard[6][0].x)*70+19,(chessBoard[6][0].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[6][0].icon);
		
		chessBoard[1][7] = new Knight("wKnight",1,7,0);//test
		chessBoard[1][7].setImage();
		chessBoard[1][7].icon.setBounds((chessBoard[1][7].x)*70+19,(chessBoard[1][7].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[1][7].icon);
		chessBoard[6][7] = new Knight("wKnight",6,7,0);//test
		chessBoard[6][7].setImage();
		chessBoard[6][7].icon.setBounds((chessBoard[6][7].x)*70+19,(chessBoard[6][7].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[6][7].icon);
		
		chessBoard[2][0] = new Bishop("bBishop",2,0,1);//test
		chessBoard[2][0].setImage();
		chessBoard[2][0].icon.setBounds((chessBoard[2][0].x)*70+19,(chessBoard[2][0].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[2][0].icon);
		chessBoard[5][0] = new Bishop("bBishop",5,0,1);//test
		chessBoard[5][0].setImage();
		chessBoard[5][0].icon.setBounds((chessBoard[5][0].x)*70+19,(chessBoard[5][0].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[5][0].icon);
		
		chessBoard[2][7] = new Bishop("wBishop",2,7,0);//test
		chessBoard[2][7].setImage();
		chessBoard[2][7].icon.setBounds((chessBoard[2][7].x)*70+19,(chessBoard[2][7].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[2][7].icon);
		chessBoard[5][7] = new Bishop("wBishop",5,7,0);//test
		chessBoard[5][7].setImage();
		chessBoard[5][7].icon.setBounds((chessBoard[5][7].x)*70+19,(chessBoard[5][7].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[5][7].icon);
		
		color = new JPanel[8][8];
		Color ncolor;//
		ncolor = new Color(150,150,0,130);
		for(int i = 0; i < 8; i ++){
			for(int j = 0; j < 8; j ++){
				
				color[i][j] = new JPanel();
				color[i][j].setLocation(20 + i * 70, 39 + j * 70);//
				color[i][j].setSize(70, 70);
				color[i][j].setBackground(ncolor);//
				chessBoardpic.add(color[i][j]); 
				color[i][j].setVisible(false);
			}
		}
		
		chessBoardpic.repaint();
		
		state = 2;//first state=2
		nowcamp = 0;//
		stateX = -1;
		stateY = -1;
		//my code ><
	}
	
	private Point determineGrid(int x,int y){ 
		int chessBoardX=24,chessBoardY=41;
		int gridWidth=70,gridHeight=70;
		
		int gx = (x - chessBoardX)/gridWidth;
		int gy = (y - chessBoardY)/gridHeight;
		Point xy = new Point(gx,gy);
		
		return xy;
	}

	public void mouseClicked(MouseEvent e) {
		
		Point p = determineGrid(e.getX(),e.getY());
		//my code:)
		
		if(state == 0){

			boolean[][] boardAvailable;
			if(p.x <=7 && p.y <= 7 && chessBoard[p.x][p.y] != null && chessBoard[p.x][p.y].camp() == nowcamp){
				
				boardAvailable = chessBoard[p.x][p.y].getReachableGrid(chessBoard);
				System.out.println(chessBoard[p.x][p.y].name);//test
				System.out.println("camp:"+nowcamp);//test
				
				chessBoard[p.x][p.y].setMusic();
				color[p.x][p.y].setVisible(true);
				
				for(int i = 0; i < 8; i ++){
					for(int j = 0; j < 8; j ++){
						//System.out.println("x:"+i+" y:"+j+" value:"+boardAvailable[i][j]);//test
						if(boardAvailable[i][j] == true){
							color[i][j].setVisible(true);
						}
					}
				}
				chessBoardpic.repaint();
				
				stateX = p.x;
				stateY = p.y;
				state = 1;
			}

		}else if(state == 1){
							System.out.println(chessBoard[stateX][stateY].isReachable(chessBoard,p.x,p.y));//
			if(chessBoard[stateX][stateY].isReachable(chessBoard,p.x,p.y)){
				if(chessBoard[p.x][p.y] != null && chessBoard[p.x][p.y].isCritical()){
					state = 2;
					GameOver G = new GameOver();
					G.setVisible(true);
				}
				else{
					state = 0;
				}
				
				for(int i = 0; i < 8; i ++){
					for(int j = 0; j < 8; j ++){	
						color[i][j].setVisible(false);//clear block
					}
				}
				if(chessBoard[p.x][p.y] != null){
					chessBoard[p.x][p.y].icon.setIcon(null);//clear picture
				}
				chessBoard[stateX][stateY].icon.setIcon(null);//clear picture
				
				chessBoard[stateX][stateY].moveXY(p.x,p.y);
				chessBoard[p.x][p.y] = chessBoard[stateX][stateY];
				chessBoard[stateX][stateY] = null;//
				
				chessBoard[p.x][p.y].setImage();//
				chessBoard[p.x][p.y].icon.setBounds((p.x)*70+19,(p.y)*70+39,70,70);
				chessBoardpic.add(chessBoard[p.x][p.y].icon);
				chessBoardpic.repaint();
				
				if(nowcamp == 0){
					nowcamp = 1;
					panel_2.setVisible(false);
					panel_3.setVisible(true);
				}
				else if(nowcamp == 1){
					nowcamp = 0;
					panel_2.setVisible(true);
					panel_3.setVisible(false);
				}
				
			}else if(stateX == p.x && stateY == p.y){
				for(int i = 0; i < 8; i ++){
					for(int j = 0; j < 8; j ++){	
						color[i][j].setVisible(false);//clear block
					}
				}
				state = 0;				
			}
		}
		//my code
		System.out.println("state="+state);//test
		//DEBUG
		debugMessage = new String("Clicked. X is: " + e.getX() + " Y is: " + e.getY() + ". Grid is :[" + p.x + "," + p.y +"]");
		DebugText.setText(debugMessage);
		//DEBUG
		
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	//mycode
	public void actionPerformed(ActionEvent e){
		state = 0;
    }
	//mycode
	private class GameOver extends JFrame implements ActionListener {
		public GameOver() {
			setSize(200, 100);
			setLocation(350,350);
			setLayout(new BorderLayout());
			JLabel confirmLabel = new JLabel("G A M E   O V E R");
			add(confirmLabel, BorderLayout.CENTER);
			JButton exitButton = new JButton("Yes");
			exitButton.addActionListener(this);
			add(exitButton, BorderLayout.SOUTH);
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}