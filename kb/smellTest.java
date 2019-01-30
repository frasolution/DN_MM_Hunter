
import java.util.*;
//----------------------------------------------------
//----------------------------------------------------
public class smellTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] plane = new int [sc.nextInt()][sc.nextInt()];
        sc.close();
        //fill the plane with only zeroes to be sure there can only be zeroes used for placement later
        for ( int planeFillerI = 0 ; plane[0].length > planeFillerI ; planeFillerI++ ){
            for ( int planeFillerJ = 0 ; plane[1].length > planeFillerJ ; planeFillerJ++ ) {
                plane[planeFillerI][planeFillerJ] = 0; 
            }
        }
        
        // compute shortSide
        int shortSide = 0 ; 
        if (plane[0].length > plane[1].length) shortSide = plane[1].length/2;
        else shortSide = plane[0].length / 2; 
        // end shortSide

        //create Hunter and Prey lists
        int[] hunterX = new int [shortSide] ;
        int[] hunterY = new int [shortSide] ;
        //end lists

        fil(plane, shortSide);
        printDX(plane);
        fillList(plane, hunterX, hunterY);
        printU(shortSide, hunterX, hunterY);
        canSmell(plane, hunterX, hunterY);
    }
    //----------------------------------------------------
    //----------------------------------------------------
    public static void canSmell( int[][] plane , int[] hunterX, int[] hunterY ) throws ArrayIndexOutOfBoundsException {
        //int pl0 = plane[0].length; // required once so no compute effext can be seen
        int pl1 = plane[1].length;
        for ( int i = 0 ; i < hunterX.length ; i++ ) {
            int x = hunterY[i];
            int y = hunterX[i];
            if( x == 0 ) {
                if( y == 0 ) canSmellDL(plane, x, y);
                else if ( y == pl1) canSmellUL(plane, x, y);
                else canSmellL(plane, x, y);
            }
            else if ( x == plane[0].length ) {
                if( y == 0 ) canSmellDR(plane, x, y);
                else if ( y == pl1 ) canSmellUR(plane, x, y);
                else canSmellR(plane, x, y);
            }
            else {
                if( y == 0 ) canSmellD(plane, x, y);
                else if ( y == pl1) canSmellU(plane, x, y);
                else canSmellM(plane, x, y);
            }
        }
    }
    /**
     * if ( plane[x + 1][y] == 1 ) break;
            else if ( plane[x - 1][y] == 1 ) break;
            else if ( plane[x][y + 1] == 1 ) break;
            else if ( plane[x][y - 1] == 1 ) break;
            else return;
     * It's dangerous to go alone take this
     */
    //----------------------------------------------------
    public static void canSmellM(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) right();
            else if ( plane[x - 1][y] == 1 ) left();
            else if ( plane[x][y + 1] == 1 ) below();
            else if ( plane[x][y - 1] == 1 ) above();
            else return;
    }
    //----------------------------------------------------
    public static void canSmellU(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) right();
            else if ( plane[x - 1][y] == 1 ) left();
            else if ( plane[x][y + 1] == 1 ) below();
            else return;
    }
    //----------------------------------------------------
    public static void canSmellUL(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) right();
            else if ( plane[x][y + 1] == 1 ) below();
            else return;
    }
    //----------------------------------------------------
    public static void canSmellUR(int[][] plane, int x, int y){
        if ( plane[x - 1][y] == 1 ) left();
            else if ( plane[x][y - 1] == 1 ) below();
            else return;
    }
    //----------------------------------------------------
    public static void canSmellD(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) right();
            else if ( plane[x - 1][y] == 1 ) left();
            else if ( plane[x][y + 1] == 1 ) above();
            else return;
    }
    //----------------------------------------------------
    public static void canSmellDR(int[][] plane, int x, int y){
        if ( plane[x - 1][y] == 1 ) left();
            else if ( plane[x][y + 1] == 1 ) above();
            else return;
    }
    //----------------------------------------------------
    public static void canSmellDL(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) right();
            else if ( plane[x][y + 1] == 1 ) above();
            else return;
    }
    //----------------------------------------------------
    public static void canSmellR(int[][] plane, int x, int y){
        if ( plane[x - 1][y] == 1 ) left();
            else if ( plane[x][y - 1] == 1 ) below();
            else if ( plane[x][y + 1] == 1 ) above();
            else return;
    }
    //----------------------------------------------------
    public static void canSmellL(int[][] plane, int x, int y){
        if ( plane[x + 1][y] == 1 ) right();
            else if ( plane[x][y - 1] == 1 ) below();
            else if ( plane[x][y + 1] == 1 ) above();
            else return;
    }
    //----------------------------------------------------
    public static void below() {
        System.out.print("Below\n---------------\n");        
    }
    public static void above() {
        System.out.print("above\n---------------\n");        
    }
    public static void left() {
        System.out.print("left\n---------------\n");        
    }
    public static void right() {
        System.out.print("right\n---------------\n");
    }
    //----------------------------------------------------
    public static void printU(int shortSide , int[] hunterX, int[] hunterY) {
        for( int i = 0 ; shortSide > i ; i++ ) { 
            System.out.println(i + " : ( " + hunterX[i] + " | " + hunterY[i] + " )");
        }
    }
    //----------------------------------------------------
    public static void fillList (int[][] plane, int[] hunterX, int[] hunterY ) { 
        int counter = 0;
        for ( int i = 0 ; plane[0].length > i ; i++ ) {
            for ( int j = 0 ; plane[1].length > j ; j++ ) {
                if(plane[i][j] == 1){
                    hunterX[counter] = i ;
                    hunterY[counter] = j ;
                    counter++;
                }
            }
        }
    }
    //----------------------------------------------------
    public static void fil ( int[][] plane , int shortSide) {
        Random rng = new Random();
        for ( int o = 0 ; shortSide > o ; o++ ){
            boolean isNotFilled = true;
            while(isNotFilled){                         //used to have it rerolled until a hunter can be placed
                int x = rng.nextInt( plane[0].length - 1 );
                int y = rng.nextInt( plane[1].length - 1 );
                if ( ! (plane[x][y] == 1) ){            // do not fill the same space with more than one onject
                    plane[x][y] = 1 ;
                    isNotFilled = false;
                }
            }
        }
    }
    //----------------------------------------------------
    public static void printDX( int[][] plane ) {
        for( int i = 0 ; i < plane[0].length ; i++ ) { //[x][y]
            for( int j = 0 ; j < plane[1].length ; j++ ) { 
                //x iteration do not forget about this !!!important!!! DO NOT FORGET AGAIN
                //No srs don't look for the a non existing logic issue just go [j][i] again and not [i][j]
                switch(plane[j][i]){
                    case 1:
                        System.out.print("h");
                        break;
                    case 2:
                        System.out.print("p");
                        break;
                    default : 
                        System.out.print("0");
                        break;
                }
            }
            System.out.println("");
        }
    }
    //----------------------------------------------------
    //----------------------------------------------------
}
