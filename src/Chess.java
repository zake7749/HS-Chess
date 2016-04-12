<<<<<<< HEAD
import java.util.Objects;
import java.util.Stack;

=======
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import sun.audio.*;

public abstract class Chess implements Cloneable{
	
	public Chess(){
		this.rootPath = "asset/music/";
	}
	
	public Chess(String chessName,int x,int y,int camp){
		
		this.name = chessName;
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.critical = false;
		this.weight = 0;
<<<<<<< HEAD
		this.status = false;
=======

>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
		this.rootPath = "asset/music/";
		
		setImage();
	}
	
<<<<<<< HEAD
	public void flip(){
		status = !status;
	}
	
	public void removed(){
		status = false;
	}
	
	public void alive(){
		status = true;
	}
	
	
=======
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
	public void moveX(int x){
		this.x = x;
	}
	
	public void moveY(int y){
		this.y = y;
	}
	
	public void moveXY(int x,int y){
		this.x = x;
		this.y = y;
		this.firstStep = false;
	}
	
<<<<<<< HEAD
	public void moveXY(int x,int y,int flag){
		if(flag == 1){
			this.x = x;
			this.y = y;
		}else{
			this.x = x;
			this.y = y;
			this.firstStep = false;
		}
	}
	
=======
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getWeight(){
		if(camp==1)
			return weight;
		else{
			return weight+2;
		}
	}
	
	public int camp(){
		return this.camp;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean getFirstStep(){
		return this.firstStep;
	}
	
	public boolean isCritical(){
		return this.critical;
	}
	
	public void setFirstStep(boolean b) {
		firstStep = b;
	}
	
	public Chess clone(){
		return this;
	}
	public abstract void setImage();
	public abstract void setMusic();
	public abstract void setMusicDead();
<<<<<<< HEAD
	public abstract Stack<Point> getReachableGrid(Chess[][] chessboard);
=======
	public abstract boolean[][] getReachableGrid(Chess[][] chessboard);
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
	public abstract boolean isReachable(Chess[][]chessboard,int x,int y);	
 
	public AudioStream audioStream;
	public JLabel icon;
	public ImageIcon chessPic;
	
	protected int x,y;
	protected String name;
	protected boolean critical;
	protected boolean firstStep;
	protected int weight;
	protected int camp;
	protected final String rootPath;
<<<<<<< HEAD
	
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Chess)) {
            return false;
        }
        Chess c = (Chess) o;
        return Objects.equals(c.x, x) && Objects.equals(c.y, y);
    }
    
    @Override
    public int hashCode() {
    	Integer a = x;
    	Integer b = y;
        return a.hashCode() ^ b.hashCode();
    }
	
    public boolean status;
	
=======
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
}
