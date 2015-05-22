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
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;


public class Game extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JLabel DebugText;
	private JLabel MilesEdgeworth;
	private JTextPane textPane;
	private String debugMessage;
	private Chess[][] chessBoard;
	
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
		
		JLabel chessBoardpic = new JLabel("");
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
		//DEBUG
		debugMessage = new String("Clicked. X is: " + e.getX() + " Y is: " + e.getY() + ". Grid is :[" + p.y + "," + p.x +"]");
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
}
