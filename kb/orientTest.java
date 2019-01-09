//package kb;

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

public class OrientTest {
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
        int[][] plane = new int [sc.nextInt()][sc.nextInt()];
        int shortSide;
        if ( plane[0].length > plane[1].length ) shortSide = plane[1].length;
        else shortSide = plane[0].length; 
        OrientTest[] hunters = new OrientTest[shortSide/2];
        
        int shortSideDiv2 = shortSide / 2;
        int[] gridNodeListX = new int[shortSideDiv2];
        int[] gridNodeListY = new int[shortSideDiv2];
        int nullExepExpcept = 1;
        for( int i = 0 ; shortSideDiv2 > i ; i++ ){
            gridNodeListX[i] = 0;
            gridNodeListY[i] = 0;
        }
        int[] isLegitGridNodeArrPass = new int[3];
        for( int i = 0 ; shortSideDiv2 > i ; i++ ) {
            isLegitGridNodeArrPass = genPairGridNode ( plane , gridNodeListX , gridNodeListY, nullExepExpcept ); // no need to check after gen if checked while genration for points with the same coordinates
                      
            hunters[i].setX( isLegitGridNodeArrPass[0] );
            hunters[i].setY( isLegitGridNodeArrPass[1] );
            hunters[i].setRot( isLegitGridNodeArrPass[2] );
            
        }
        printPile(hunters, plane);
        /**
         * Now we need to check if the ther is another object near us and if so we rotate and move away
         * To ease up the comptational requests and for later ease of implementation of the gui we might use an array for this that will get upadated continously
         *  - this might be error prone
        */

        sc.close();
    }
    //-----------------------------
    public static int[] genPairGridNode(int[][] plane, int[] gridNodeListX, int[] gridNodeListY, int nullExepExpcept) {
        int[] locArr = new int[3];
        locArr = genNode( plane );
        boolean noPairFound = true;
        while(noPairFound){
            for(int i = 0 ; nullExepExpcept > i ; i++ ){
                if (locArr[0] == gridNodeListX[i] || locArr[1] == gridNodeListY[i] ) locArr = genNode(plane);
                else noPairFound = false;
            }
        }
        return locArr;
    }
    //-----------------------------
    public static int[] genNode( int[][] plane ){
        Random rng = new Random();
        int[] locArr = new int[3];
        locArr[0] = rng.nextInt( plane[0].length - 1 );
        locArr[1] = rng.nextInt( plane[1].length - 1 );
        locArr[2] = rng.nextInt(3);
        return locArr;
    }
    //-----------------------------
    public static void printPile(OrientTest[] hunters, int[][] plane  ){
        for(int i = 0 ; hunters.length > i ; i++){
            plane[ hunters[i].getX() ][ hunters[i].getY() ] = hunters[i].getRot();
        }
        for ( int ichi = 0 ; plane[0].length > ichi ; ichi++ ) { // ichi, ni, san GOOO!!!
            for ( int ni = 0 ; plane[1].length > ni ; ni++ ) {
                switch(plane[ichi][ni]){
                    case 1:
                        System.out.print("v");
                        break;
                    case 2:
                        System.out.print("<");
                        break;                        
                    case 3:
                        System.out.print("^");
                        break;                        
                    case 4:
                        System.out.print(">");
                        break;
                    default:
                        break;
                }
            }
            System.out.println("");
        }
    }
    //-----------------------------
}
