import java.util.*;
import java.lang.*;

public class OrientTest {
    //-----------------------------
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

        int shortSideDiv2 = shortSide / 2;
        System.out.println("ShoDiv2 :" + shortSideDiv2);

        OrientTest[] hunters = new OrientTest[shortSideDiv2];
        int[] gridNodeListX = new int[shortSideDiv2];
        int[] gridNodeListY = new int[shortSideDiv2];
        int[] isLegitGridNodeArrPass = new int[3];
        int nullExepExpcept = 1;

        for( int i = 0 ; shortSideDiv2 > i ; i++ ){
            gridNodeListX[i] = 0;
            gridNodeListY[i] = 0;
        }

        for( int i = 0 ; shortSideDiv2 > i ; i++ ) {
            isLegitGridNodeArrPass = genPairGridNode ( plane , gridNodeListX , gridNodeListY, nullExepExpcept ); // no need to check after gen if checked while genration for points with the same coordinates
            hunters[i] = new OrientTest();
            hunters[i].setX( isLegitGridNodeArrPass[0] ); 
            hunters[i].setY( isLegitGridNodeArrPass[1] );
            hunters[i].setRot( isLegitGridNodeArrPass[2] );
            System.out.println( isLegitGridNodeArrPass[0] + " " + isLegitGridNodeArrPass[1] + " " + isLegitGridNodeArrPass[2]);

            gridNodeListX[i] = isLegitGridNodeArrPass[0];
            gridNodeListY[i] = isLegitGridNodeArrPass[1];

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
        nullExepExpcept++;
        return locArr;
    }
    //-----------------------------
    public static int[] genNode( int[][] plane ){
        Random rng = new Random();
        int[] locArr = new int[3];
        locArr[0] = rng.nextInt( plane[0].length - 1 );
        locArr[1] = rng.nextInt( plane[1].length - 1 );
        locArr[2] = rng.nextInt(4);
        return locArr;
    }
    //-----------------------------
    public static void printPile(OrientTest[] hunters, int[][] plane  ){
        for ( int ichi = 0 ; plane[0].length > ichi ; ichi++ ) { // ichi, ni, san GOOO!!!
            for ( int ni = 0 ; plane[1].length > ni ; ni++ ) {
                plane[ichi][ni] = 4;
            }
        }
        for(int i = 0 ; hunters.length > i ; i++){
            plane[ hunters[i].getX() ][ hunters[i].getY() ] = hunters[i].getRot();
        }
        
        for ( int ichi = 0 ; plane[0].length > ichi ; ichi++ ) { // ichi, ni, san GOOO!!!
            for ( int ni = 0 ; plane[1].length > ni ; ni++ ) {
                switch(plane[ichi][ni]){
                    case 0:
                        System.out.print(">");
                        break;
                    case 1:
                        System.out.print("v");
                        break;
                    case 2:
                        System.out.print("<");
                        break;                        
                    case 3:
                        System.out.print("^");
                        break;                        
                    default:
                        System.out.print("*");
                }
            }
            System.out.println("");
        }
    }
    //-----------------------------
    //-----------------------------
    //public static OrientTest[] rotTest(OrientTest[] hunters, int[][] plane){
    public static void rotTest(OrientTest[] hunters, int[][] plane){
        int[] hunterX = new int[hunters.length];
        int[] hunterY = new int[hunters.length];
        for ( int i = 0 ; hunters.length > i ; i++ ) { 
            hunterX[i] = hunters[i].getX();
            hunterY[i] = hunters[i].getY();
        }

    }
    //-----------------------------
    //-----------------------------
    //public static OrientTest[] proxTest(int[] hunterX, int[] hunterY, int[][] plane){
    public static void proxTest(int[] hunterX, int[] hunterY, int[][] plane){
        //int pl0 = plane[0].length; // required once so no compute effext can be seen
        int pl1 = plane[1].length;
        for ( int i = 0 ; i < hunterX.length ; i++ ) {
            int x = hunterY[i];
            int y = hunterX[i];
            if( x == 0 ) {
                if( y == 0 ) needToTurnTestDL(plane, x, y);
                else if ( y == pl1) needToTurnTestDR(plane, x, y);
                else needToTurnTestD(plane, x, y);
            }
            else if ( x == plane[0].length ) {
                if( y == 0 ) needToTurnTestUL(plane, x, y);
                else if ( y == pl1 ) needToTurnTestUR(plane, x, y);
                else needToTurnTestU(plane, x, y);
            }
            else {
                if( y == 0 ) needToTurnTestU(plane, x, y);
                else if ( y == pl1) needToTurnTestD(plane, x, y);
                else needToTurnTestM(plane, x, y);
            }
        }
   }
   //-----------------------------
    public static void needToTurnTestM(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x - 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x][y + 1] == 1 ) needToTurnTestFin();
            else if ( plane[x][y - 1] == 1 ) needToTurnTestFin();
            else return;
    }
    public static void needToTurnTestU(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x - 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x][y + 1] == 1 ) needToTurnTestFin();
            else return;
    }
    public static void needToTurnTestUL(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x][y + 1] == 1 ) needToTurnTestFin();
            else return;
    }
    public static void needToTurnTestUR(int[][] plane, int x, int y){
        if ( plane[x - 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x][y + 1] == 1 ) needToTurnTestFin();
            else return;
    }
    public static void needToTurnTestD(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x - 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x][y - 1] == 1 ) needToTurnTestFin();
            else return;
    }
    public static void needToTurnTestDR(int[][] plane, int x, int y){
        if ( plane[x - 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x][y - 1] == 1 ) needToTurnTestFin();
            else return;
    }
    public static void needToTurnTestDL(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x][y - 1] == 1 ) needToTurnTestFin();
            else return;
    }
    public static void needToTurnTestR(int[][] plane, int x, int y){
        if ( plane[x - 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x][y + 1] == 1 ) needToTurnTestFin();
            else if ( plane[x][y - 1] == 1 ) needToTurnTestFin();
            else return;
    }
    public static void needToTurnTestL(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) needToTurnTestFin();
            else if ( plane[x][y + 1] == 1 ) needToTurnTestFin();
            else if ( plane[x][y - 1] == 1 ) needToTurnTestFin();
            else return;
    }
    //----------------------------------------------------
    public static void needToTurnTestFin() {
        System.out.print("Below\n---------------\n");        
    }
    //-----------------------------

}
