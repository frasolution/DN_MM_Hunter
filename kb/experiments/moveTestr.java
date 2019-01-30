
package experiments;
import java.util.*;
public class moveTestr{
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int gridX = sc.nextInt();
        int gridY = sc.nextInt();
        int[][] arr = new int [gridX][gridY];
        Random rand = new Random();
        int pointX = rand.nextInt(gridX);
        int pointY = rand.nextInt(gridY);
        arr[pointX][pointY] = 1;
        //----- Print
        clr();
        printDX(arr, gridX, gridY);
        //----- 
        arr[pointX][pointY] = 0;
        arr[pointX][pointY + 1] = 1;
        
        printDX(arr, gridX, gridY);

        sc.close();
    }
    public static void printDX(int[][] arr, int gridX, int gridY){
        for( int i = 0 ; i < gridX ; i++ ) {
            for( int j = 0 ; j < gridY ; j++ ) {
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
