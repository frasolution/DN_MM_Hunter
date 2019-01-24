import java.util.Random;
import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        
        // create Scanner and Random
        Scanner sc = new Scanner(System.in);
        Random rng = rngCreator(sc);
        
        // Create Plane
        int plane[][] = planeCreate(sc);
        
        // Create OBJ VEC 
        

        //CLOSE
        sc.close();
    }
//-------------------------------------------------
    public static Random rngCreator(Scanner sc) {
        System.out.print("Do you want to set a seed? / (yes/no) \n");
        String inString = sc.nextLine();
        if(inString.equals("yes")){
            Random rng = new Random(sc.nextInt());
            return rng;
        } else {
            Random rng = new Random();
            return rng;
        }
    }
//-------------------------------------------------
    public static int[][] planeCreate(Scanner sc) {
        System.out.print("How long should the X Field direction be");
        int xLenArr = sc.nextInt();
        System.out.print("How long should the Y Field direction be");
        int yLenArr = sc.nextInt();
        int publicPlane[][] = new int[xLenArr][yLenArr];
        return publicPlane;
    }
}
//-------------------------------------------------

