import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Game extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JLabel DebugText;
	private String debugMessage;
	
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
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.addMouseListener(this);
		setContentPane(contentPane);
		
		DebugText = new JLabel("Debug Test :");
		DebugText.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(DebugText, BorderLayout.SOUTH);
		
	}
	
	private Point determineGrid(int x,int y){
		
		int chessBoardX=30,chessBoardY=50;
		int gridWidth=40,gridHeight=40;
		
		int gx = (x - chessBoardX)/gridWidth;
		int gy = (y - chessBoardY)/gridHeight;
		Point xy = new Point(gx,gy);
		
		return xy;
	}

	public void mouseClicked(MouseEvent e) {
		
		determineGrid(e.getX(),e.getY());
		//DEBUG
		debugMessage = new String("Clicked. X is: " + e.getX() + " Y is: " + e.getY());
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
