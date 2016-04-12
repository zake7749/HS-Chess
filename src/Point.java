import java.util.Objects;

/*
 * Description : 
 * 	a simple implementation of struct in C.
 * 
 * Member :
 * 	- private
 * 		- x : int
 * 		- y : int
 */


public class Point {
	
	public int x;
	public int y;
	
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return Objects.equals(p.x, x) && Objects.equals(p.y, y);
    }
    
    @Override
    public int hashCode() {
    	Integer a = x;
    	Integer b = y;
        return a.hashCode() ^ b.hashCode();
    }
	
}
