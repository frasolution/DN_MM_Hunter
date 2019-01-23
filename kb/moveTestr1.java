import java.util.*;
public class moveTestr1{
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        clr();
        int gridX = sc.nextInt();
        int gridY = sc.nextInt();
        int[][] arr = new int [gridX][gridY];
        Random rand = new Random();
        int arrs = 0;
        if(gridX < gridY) arrs = gridX / 2;
        else arrs = gridY / 2;
        int[] pointX = new int [arrs];
        int[] pointY = new int [arrs];
        for ( int i = 0 ;  i < arrs ; i++ ) {
            pointX[i] = rand.nextInt(gridX -1 );
            pointY[i] = rand.nextInt(gridY -1 );
        }
        arr[pointX[0]][pointY[0]] = 1;
        //----- Print
        clr();
        printDX(arr);
        //----- 
        clr();
        arr[pointX[0]][pointY[0]] = 0;
        arr[pointX[0]][pointY[0] + 1] = 1;
        printDX(arr);
        sc.close();
    }
    public static void printDX(int[][] arr){
        for( int i = 0 ; i < arr[0].length ; i++ ) {
            for( int j = 0 ; j < arr[1].length ; j++ ) {
                if( arr[i][j] == 0 ) System.out.print("-");
                if( arr[i][j] == 1 ) System.out.print("+");
            }
            System.out.println("");
        }
    }
    public static void clr() throws InterruptedException {
        Thread.sleep(1000);
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
}
