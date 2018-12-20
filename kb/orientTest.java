package kb;

import java.util.*;
import java.lang.*;
/**
 * rotations explained :
 * currently we only want up right down left as orientations
 * but hey we maybe add up-right down-right down-leeft up-left
 * but probaly not since it is not going to add a lot of value and a lot more work, its not hard work just really boring calulations
 * 
 * up = 3
 * right = 0
 * donw = 1
 * left = 2
 * 
 */
public class orientTest {
    //-----------------------------
    //use object capsulation for the productions code
    private int x;
    private int y;
    private int rot;
    //--------------
    public void setX (int inX) { x = inX ; }
    public void setY (int inY) { y = inY ; }
    public void setRot (int inRot) { rot = inRot; }
    /**
     * rotations explained :
     * currently we only want up right down left as orientations
     * but hey we maybe add up-right down-right down-leeft up-left
     * but probaly not since it is not going to add a lot of value and a lot more work, its not hard work just really boring calulations
     * 
     * up = 3
     * right = 0
     * donw = 1
     * left = 2
     * 
     */
    //--------------
    public int getX(){ return x; }
    public int getY(){ return y; }
    public int getRot(){ return rot; }
    //-----------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();
        int[][] plane = new int [sc.nextInt()][sc.nextInt()];
        int shortSide;
        if ( plane[0].length > plane[1].length ) shortSide = plane[1].length;
        else shortSide = plane[0].length; 
        orientTest[] hunters = new orientTest[shortSide/2];
        for( int i = 0 ; shortSide/2 > i ; i++ ) {
            hunters[i].setX( rng.nextInt( plane[0].length - 1 ) );
            hunters[i].setY( rng.nextInt( plane[1].length - 1 ) );
            hunters[i].setRot( rng.nextInt( 3 ) );
        }
        
        /**
         * Now we need to check if the ther is another object near us and if so we rotate and move away
         * To ease up the comptational requests and for later ease of implementation of the gui we might use an array for this that will get upadated continously
         *  - this might be error prone
        */
        sc.close();
    }
    //-----------------------------
}
