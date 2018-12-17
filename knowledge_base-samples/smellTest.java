
import java.util.*;
import java.lang.*;

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
    }
    //----------------------------------------------------
    public static void canSmell( int[][] plane ) {
        
    }
    //----------------------------------------------------
    public static void canSmell2(int x, int y){
    
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
                switch(plane[i][j]){
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
