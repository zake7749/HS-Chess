<<<<<<< HEAD
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
	
=======

public class Point {
	
	//to simulate a struct in C.
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
	public int x;
	public int y;
	
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
<<<<<<< HEAD
	
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
	
=======
>>>>>>> 4023b0f014681d762cd04b517118f2508c45f24f
}
