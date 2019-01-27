import java.util.Scanner;
import java.util.Vector;
import java.util.HashSet;
import java.util.Random;

// custom import
import src.oriObj;

public class genOriTest{
    //------------------------------
    public static void main(String[] args) {
        Random rng = new Random();

        //genrate valid coordinates
        Vector<oriObj> oriVec = new Vector<oriObj>();
        
        //
        oriVec = oriVecCreaVector(rng);
    }
    
    //------------------------------
    public static Vector oriVecCreaVector(Random rng) {
        System.out.println("please enter x y objectCount");
        Scanner sc = new Scanner(System.in);
//------------------------------        
        int xLen = sc.nextInt();
        int yLen = sc.nextInt();
        int objNumber = sc.nextInt();
//------------------------------
        int xArr[] = new int[objNumber];
        int yArr[] = new int[objNumber];
//------------------------------       
        HashSet<Double> validSet = new HashSet<Double>(); 
        Vector<oriObj> oriVec = new Vector<oriObj>();
//------------------------------
        int x = 0;
        int y = 0;
        double testCord = 0;
//------------------------------
        for (int i = 0; i < objNumber; i++) {
            x = sc.nextInt( xLen - 1 );
            y = sc.nextInt( yLen - 1 );
            testCord = x + y*0.1;
            if(validSet.contains(testCord)) i--;
            else {
                xArr[i] = x;
                yArr[i] = y;
                oriVec.add(new oriObj(x, y, rng.nextInt(3), 1 ) );
                validSet.add(testCord);
            }
        }
//------------------------------
        oriVec = verifVec(oriVec, xLen, yLen);
        return oriVec;
    }

    public static Vector verifVec(Vector oriVec, int xLen, int yLen) {
//------------------------------        
        Vector<oriObj> oriVecVerif = new Vector<oriObj>();
        int[][] vecPlane = new int[xLen][yLen];
        int[][] oriPlane = new int[xLen][yLen];
//------------------------------
        for (int i = 0; i < oriVec.size() ; i++) {
            vecPlane[oriVec.elementAt(i).getX()][oriVec.elementAt(i).getY()] = i;
            oriPlane[oriVec.elementAt(i).getX()][oriVec.elementAt(i).getY()] = oriVec.elementAt(i).getOri();
        }
//------------------------------

//------------------------------
        return oriVecVerif;
    }

    /** RE-USE THIS FOR TO PRINT AND READ ARRAY
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                
            }
            
        }
        //------------------------------
     */

}