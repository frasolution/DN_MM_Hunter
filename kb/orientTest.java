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
        int[][] plane = new int [sc.nextInt()][sc.nextInt()];
        
        int shortSide;
        if ( plane[0].length > plane[1].length ) shortSide = plane[1].length;
        else shortSide = plane[0].length; 
        orientTest[] hunters = new orientTest[shortSide/2];
        
        int shortSideDiv2 = shortSide / 2;
        int[] gridNodeListX = new int[shortSideDiv2];
        int[] gridNodeListY = new int[shortSideDiv2];
        for( int i = 0 ; shortSideDiv2 > i ; i++ ) {
            int[] isLegitGridNodeArrPass = new int[3];
            isLegitGridNodeArrPass = genPairGridNode( plane , gridNodeListX , gridNodeListY); // no need to check after gen if checked while genration for points with the same coordinates
            
            hunters[i].setX( isLegitGridNodeArrPass[0] );
            hunters[i].setY( isLegitGridNodeArrPass[1] );
            hunters[i].setRot( isLegitGridNodeArrPass[2] );

        }
        
        /**
         * Now we need to check if the ther is another object near us and if so we rotate and move away
         * To ease up the comptational requests and for later ease of implementation of the gui we might use an array for this that will get upadated continously
         *  - this might be error prone
        */

        sc.close();
    }
    //-----------------------------
    public static int[] genPairGridNode(int[][] plane, int[] gridNodeListX, int[] gridNodeListY) {
        int[] locArr = new int[3];
        locArr = genNode(plane);
        boolean noPairFound = true;
        while(noPairFound){
            for(int i = 0 ; gridNodeListX.length > i ; i++ ){
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
    /*
    public static int[] genPairGridNode( int[][] plane , int[] gridNodeListX , int[] gridNodeListY , orientTest[] hunters ){
        Random rng = new Random();
        int locX = rng.nextInt( plane[0].length - 1 );
        int locY = rng.nextInt( plane[1].length - 1 );
        int[] ArrGenPairGridNode = new int[2];
        ArrGenPairGridNode = isLegitGridNode(locX, locY, gridNodeListX , gridNodeListY , hunters);
        return ArrGenPairGridNode;
    }
    public static int[] isLegitGridNode( int[][] plane , int[] gridNodeListX , int[] gridNodeListY , orientTest[] hunters){
        
        
        
        for(int i = 0 ; gridNodeListX.length > i ; i++ ){
            boolean noPairFound = true;
            int[] locArr = new int[2];
            locArr = genPoint(plane);
            while(noPairFound){
                for(int j = 0 ; gridNodeListX.length > j ; j++ ){
                    if (! locArr[0] == gridNodeListX[i] || locArr[1] == gridNodeListY[i] ){
                        
                    } else {
                        noPairFound = false;

                    }
                }
            }
        }
        return locArr;
    } */
    //-----------------------------
}
