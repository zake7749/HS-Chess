
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

public class Game extends JFrame implements MouseListener , ActionListener{//test

	private JPanel contentPane;
	private JLabel chessBoardpic; 
	private JLabel DebugText;
	private JLabel MilesEdgeworth;
	private JTextPane textPane;
	private String debugMessage;
	private Chess[][] chessBoard;
	private JLabel testP;
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
		panel_1.setBounds(620, 391, 229, 230);
		contentPane.add(panel_1);
		
		JTextArea history = new JTextArea();
		history.setBounds(620, 391, 229, 230);
		Font font = new Font("Verdana", Font.BOLD, 20);
		history.setFont(font);
		history.setForeground(Color.BLUE);
		history.setText("A1 -> A2");
		panel_1.add(history);
		

		
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
		
		chessBoard[0][6] = new King("bKing",0,6,1);//test
		chessBoard[0][6].setImage();
		chessBoard[0][6].icon.setBounds((chessBoard[0][6].x)*70+19,(chessBoard[0][6].y)*70+39,70,70);
		chessBoardpic.add(chessBoard[0][6].icon);
		
		color = new JPanel[8][8];
		for(int i = 0; i < 8; i ++){
			for(int j = 0; j < 8; j ++){
				color[i][j] = new JPanel();
				color[i][j].setLocation(20 + i * 70, 39 + j * 70);//
				color[i][j].setSize(70, 70);
				color[i][j].setBackground(Color.YELLOW);
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
			if(chessBoard[stateX][stateY].isReachable(chessBoard,p.x,p.y)){
				if(chessBoard[p.x][p.y] != null && chessBoard[p.x][p.y].isCritical()){
					state = 2;
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
				}
				else if(nowcamp == 1){
					nowcamp = 0;
				}
				
			}else if(stateX == p.x && stateY == p.y){
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
	public void actionPerformed(ActionEvent e) {
		state = 0;
    }
	//mycode
}