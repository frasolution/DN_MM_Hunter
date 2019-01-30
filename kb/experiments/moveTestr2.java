package experiments;
import java.util.*;
public class moveTestr2{
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        //---------- array point all movement
        boolean arr[][] = new boolean[sc.nextInt()][sc.nextInt()]; //decale 2d array of user input size //[y][x]
        int arrs = 0;
        if(arr[0].length < arr[0].length) arrs = arr[0].length / 2;
        else arrs = arr[1].length / 2;
        for(int i = 0 ; i < arrs ; i++ ){
            arr[ rand.nextInt( arr[0].length -1 ) ][ rand.nextInt( arr[1].length - 1 ) ] = true ; //[y][x]
        }
        for(int iterationist = 0 ; iterationist < arr[0].length ; iterationist++ ) {
            printDX(arr);
            moveLeft(arr);
        }
        sc.close();
    }

    public static void moveLeft(boolean[][] arr) throws InterruptedException { //[y][x]
        for ( int i = 0 ; i < arr[0].length ; i++ ) { //y iteration
            for ( int j = 0 ; j < arr[1].length ; j++ ) { //x iteration
                if( arr[i][j] == true){
                    arr[i][j] = false;
                    if( ! ( j == 0 ) ){
                        arr[i][j-1] = true; 
                    }
                }
            }
        }
    }

    public static void printDX(boolean[][] arr) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(" ");
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        for( int i = 0 ; i < arr[0].length ; i++ ) { //[x][y]
            for( int j = 0 ; j < arr[1].length ; j++ ) {
                if( arr[i][j] == true ) System.out.print("+");
                else System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println(" /********************/");

    }

    /*
    //---------- CLEAR LINUX SHELL
    public static void clr() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(" ");
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    } */

}
