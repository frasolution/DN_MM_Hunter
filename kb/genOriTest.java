import java.util.Scanner;
import java.util.Vector;
import java.util.HashSet;
import java.util.Random;

// custom import
import src.oriObj;

public class genOriTest {
	// ------------------------------
	public static void main(String[] args) {
		Random rng = new Random();

		// genrate valid coordinates
		Vector<oriObj> oriVec = new Vector<oriObj>();

		//correct the orientation of neighbouring objects
		oriVec = oriVecCreaVector(rng);
	}

	// ------------------------------
	// ------------------------------
	public static Vector<oriObj> oriVecCreaVector(Random rng) {
		// ------------------------------
		System.out.println("please enter x y objectCount");
		Scanner sc = new Scanner(System.in);
		int xLen = sc.nextInt();
		int yLen = sc.nextInt();
		int objNumber = sc.nextInt();
		sc.close();
		// ------------------------------
		int xArr[] = new int[objNumber];
		int yArr[] = new int[objNumber];
		// ------------------------------
		HashSet<Double> validSet = new HashSet<Double>();
		Vector<oriObj> oriVec = new Vector<oriObj>();
		// ------------------------------
		int x = 0;
		int y = 0;
		double testCord = 0;
		// ------------------------------
		for (int i = 0; i < objNumber; i++) {
			x = rng.nextInt(xLen - 1);
			y = rng.nextInt(yLen - 1);
			testCord = x + y * 0.1;
			if (validSet.contains(testCord))
				i--;
			else {
				xArr[i] = x;
				yArr[i] = y;
				oriVec.add(new oriObj(x, y, rng.nextInt(3), 1));
				validSet.add(testCord);
			}
		}
		// ------------------------------
		oriVec = verifVec(oriVec, xLen, yLen);
		return oriVec;
	}
	// ------------------------------

	// ------------------------------
	// ------------------------------
	public static Vector<oriObj> verifVec(Vector<oriObj> oriVec, int xLen, int yLen) {
		// ------------------------------
		Vector<oriObj> oriVecVerif = new Vector<oriObj>();
		// IMPORTANT OVERRIDE ARRAY OVERRIDE WITH VALUE oriVecsize() + 1;
		int[][] vecPlane = new int[xLen][yLen];
		int[][] oriPlane = new int[xLen][yLen];
		// ------------------------------
		int override = oriVec.size() + 1;
		vecPlane = overArr(vecPlane, override);
		override = 4; //orientations are 0-3 SO 4 IS A SAFE VALUE FOR ORIENTATION
		oriPlane = overArr(oriPlane, override);
		// ------------------------------
		for (int i = 0; i < oriVec.size(); i++) {
			oriPlane[oriVec.elementAt(i).getX()][oriVec.elementAt(i).getY()] = oriVec.elementAt(i).getOri();
			vecPlane[oriVec.elementAt(i).getX()][oriVec.elementAt(i).getY()] = i;
		}
		// ------------------------------
		int[][] oriPlane2 = oriVerif(oriPlane);
		//printArr(oriPlane2);
		// ------------------------------
		for (int i = 0; i < oriPlane[1].length - 1 ; i++) {
			for (int j = 0; j < oriPlane[0].length - 1 ; j++) {
				if(oriPlane[j][i] != oriPlane2[j][i]){
					oriVec.elementAt(vecPlane[j][i]).setOri(oriPlane2[j][i]);
				}
			}	
		}
		// ------------------------------
		return oriVecVerif;
	}
	// ------------------------------

	// ------------------------------
	// ------------------------------
	public static void printArr(int[][] plane) {
		for (int i = 0; i < plane[0].length; i++) {
			for (int j = 0; j < plane[1].length; j++) {
				System.out.print(plane[j][i]);
			}
			System.out.println("");
		}
		return;
	}
	// ------------------------------

	// ------------------------------
	// ------------------------------
	public static int[][] oriVerif(int[][] oriPlane) {
        Random rngRandom = new Random();
        for ( int i = 0; i < oriPlane[1].length; i++) {
            for ( int j = 0; j < oriPlane[0].length; j++) {
				if( i < oriPlane[1].length - 1){
					if ( j < oriPlane[0].length - 2 ) { //we test (x+1) therfore we need to -2 here already
						if(oriPlane[j][i] == oriPlane[j][i+1] && !(oriPlane[j][i] == 4) ) oriPlane[j][i+1] = reroll(oriPlane[j][i], rngRandom);
						if(oriPlane[j][i] == oriPlane[j+1][i] && !(oriPlane[j][i] == 4) ) oriPlane[j+1][i] = reroll(oriPlane[j][i], rngRandom);
					}else{
						if(oriPlane[j][i] == oriPlane[j][i+1] && !(oriPlane[j][i] == 4) ) oriPlane[j][i+1] = reroll(oriPlane[j][i], rngRandom);
					}
				}else{
					if ( j < oriPlane[0].length - 1) if(oriPlane[j][i] == oriPlane[j+1][i] && !(oriPlane[j][i] == 4) ) oriPlane[j+1][i] = reroll(oriPlane[j][i], rngRandom);
				}
            }
        }
        return oriPlane;
    }
	// ------------------------------

	// ------------------------------
	// ------------------------------
	public static int reroll(int except, Random rngRandom) {
		int returner = rngRandom.nextInt(3);
		if (except == returner)
			return reroll(except, rngRandom);
		else
			return returner;
	}
	// ------------------------------

	// ------------------------------
	// ------------------------------
	public static int[][] overArr(int[][] plane, int overValue) {
		for (int i = 0; i < plane[0].length; i++) {
			for (int j = 0; j < plane[1].length; j++) {
				plane[j][i] = overValue;
			}
		}
		return plane;
	}
	// ------------------------------

}