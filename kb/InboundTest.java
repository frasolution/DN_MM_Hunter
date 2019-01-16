import java.util.Random;

public class InboundTest {
    public static void main(String[] args) {
        //Random rng = new Random();
        //boolean thisOne = false;
        int[][] plane = new int[8][8];
        //int counter = plane[0].length / 2 ;
        /*
        for ( int i = 0 ; plane[0].length > i ; i++){
            for ( int j = 0 ; plane[1].length > j ; j++){
                thisOne = rng.nextBoolean();
                if(thisOne) plane[i][j] = 1; 
                counter--;
                if(counter < 1) break;
            }

        }
        */
        plane[0][0] = 1;
        plane[7][7] = 1;
        plane[4][4] = 1;
        for ( int i = 0 ; plane[0].length > i ; i++){
            for ( int j = 0 ; plane[1].length > j ; j++){
                if( plane[i][j] == 1 ){
                    if(isInBound( i,j,plane)){
                        plane[i][j] = 0; //remove from array for the testing since it will be there on the next creating of array for testing
                        //also do change rotation in object
        }}}}
        printArr(plane);
    }
    public static boolean isInBound(int x , int y , int[][] plane ){
        boolean isOutBounds = false;
        if( x == 0 || y == 0 || x == plane[0].length - 1 || y == plane[1].length - 1)  isOutBounds = true;
        return isOutBounds;
    }

    public static void printArr(int[][] plane){
        for ( int i = 0 ; plane[0].length > i ; i++){
            for ( int j = 0 ; plane[1].length > j ; j++){
                System.out.print(plane[j][i]);
            }
            System.out.println();
        }
    }
}