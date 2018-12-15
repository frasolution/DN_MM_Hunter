import java.util.*;
import java.lang.*;

public class moveTestr2{
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        //---------- array point all movement
        int arr[][] = new int[sc.nextInt()][sc.nextInt()]; //decale 2d array of user input size
        int arrs = 0;
        if(arr[0].length < arr[0].length) arrs = arr[0].length / 2;
        else arrs = arr[1].length / 2;
        for(int i = 0 ; i < arrs ; i++ ){
            int i1 = rand.nextInt( arr[0].length - 1 ) ;
            int i2 = rand.nextInt( arr[1].length - 1 ) ;
            System.out.println(i1 + " " + i2);
            arr[ i1 ][ i2 ] = 1 ;
        }
        printDX(arr);
    }
    public static void moveLeft(int[][] arr){
        for ( int j = 0 ; j < arr[1].length ; j++ ) {

        }
    }
    public static void printDX(int[][] arr) throws InterruptedException{
        for( int i = 0 ; i < arr[0].length ; i++ ) {
            for( int j = 0 ; j < arr[1].length ; j++ ) {
                if( arr[i][j] == 1 ) System.out.print("+");
                else System.out.print("-");
            }
            System.out.println("");
        }
        clr();
    }

    //---------- CLEAR LINUX SHELL
    public static void clr() throws InterruptedException {
        Thread.sleep(1000);
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

}