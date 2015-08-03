import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Description : 
 * 	Display all the movable steps of each selected chess by color(JPanel).
 * 
 * Member :
 * 	- private
 * 		- color : JPanel[][]
 * 
 * Method :
 * 	- public
 * 		- addColor(layoutPic : JLabel) : void
 *  	- showPath(reachableGrid : boolean[][]) : void
 *  	- clearPath(void) : void
 */

public class ColorPanel {
	
	private JPanel[][] color;

	public ColorPanel(){
		
		color = new JPanel[8][8];
		Color ncolor;
		ncolor = new Color(150,150,0,130);
		for(int i = 0; i < 8; i ++){
			for(int j = 0; j < 8; j ++){
				color[i][j] = new JPanel();
				color[i][j].setLocation(20 + i * 70, 39 + j * 70);
				color[i][j].setSize(70, 70);
				color[i][j].setBackground(ncolor);
				color[i][j].setVisible(false);
			}
		}
	}
	
	public void addColor(JLabel layoutPic){
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				layoutPic.add(color[i][j]);
			}
		}
	}
	
	public void showPath(boolean[][] reachableGrid){
		
		for(int i = 0; i < 8; i ++){
			for(int j = 0; j < 8; j ++){
				if(reachableGrid[i][j]){
					color[i][j].setVisible(true);
				}
			}
		}
		
	}
	
	public void clearPath(){
		
		for(int i = 0; i < 8; i ++){
			for(int j = 0; j < 8; j ++){	
				color[i][j].setVisible(false);
			}
		}
		
	}

}
