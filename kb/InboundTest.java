import java.util.*;
import java.lang.*;
public class InboundTest {
    public static void main(String[] args) {
        Random rng = new Random();
        int[][] plane = new int[8][8];
        int counter = plane[0].length / 2 ;
        
        int xCreate[] = new int[counter];
        int yCreate[] = new int[counter];
        
        for( int i = 0 ; i < counter ; i++ ) {
            xCreate[i] = rng.nextInt( plane[0].length );
            yCreate[i] = rng.nextInt( plane[1].length );
        }
        
        int notPassing = 0;
        double currTest = 0;
        HashSet<Double> passTest = new HashSet<Double>();
        
        for( int i = 0 ; i < counter ; i++ ){
            currTest = xCreate[i] + ( yCreate[i] * 0.1 );
            if(passTest.contains(currTest)) notPassing++;
            else passTest.add(currTest);
        }
        
        while ( notPassing > 0) {

            int x = rng.nextInt( plane[0].length );
            int y = rng.nextInt( plane[0].length );
            currTest = x + ( y * 0.1 );
            if(passTest.contains(currTest)) notPassing++;
            else passTest.add(currTest);

        }

        for ( int i = 0 ; i < counter ; i++ ) {
            plane[xCreate[i]][yCreate[i]] = 1 ;
        }

        printArr(plane);
        System.out.println("-----------------------");

        for ( int i = 0 ; plane[0].length > i ; i++){
            for ( int j = 0 ; plane[1].length > j ; j++){
                if( plane[i][j] == 1 ){
                    if(isInBound( i,j,plane)){
                        plane[i][j] = 0; 
                        //remove from array for the testing since it will be there on the next creating of array for testing
                        //also do change rotation in object
        }}}}

        printArr(plane);
    }

    public static boolean isInBound(int x , int y , int[][] plane ){
        boolean isOutBounds = false;
        if( x == 0 || y == 0 || x == plane[0].length - 1 || y == plane[1].length - 1) isOutBounds = true;
        return isOutBounds;
    }

    public static void printArr(int[][] plane){
        for ( int i = 0 ; plane[0].length > i ; i++){
            for ( int j = 0 ; plane[1].length > j ; j++) System.out.print(plane[j][i]);
            System.out.println();
        }
    }
}