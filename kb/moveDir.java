
import src.*;
import java.util.Random;
import java.util.Vector;
/**
 * moveDir
 */
public class moveDir {

    public static void main(String[] args) {
        Random rng = new Random();
    Vector<oriObj> objVec = new Vector<oriObj>();
    objVec.add(new oriObj(1, 1, 0, 1, 1 ));
    int[][] genericPlane = new int[4][4];
    const int[] arrMaxSize = { genericPlane.length - 1, genericPlane[0].length -1};
    objVec = moverOriObjs(objVec, genericPlane, rng, arrMaxSize);
    System.out.println(" exit");
    }

    public static Vector<oriObj> moverOriObjs(Vector<oriObj> objVec, int[][] genericPlane, Random rng, int[] arrMaxSize) {
        Vector<oriObj> returnrVector = new Vector<oriObj>();
        System.out.println("moverOriObjs Starting");
        returnrVector = objVec;
        for (int i = 0; i < objVec.size(); i++) {
            int[] posi = {objVec.elementAt(i).getX(), objVec.elementAt(i).getY(), objVec.elementAt(i).getOri(), objVec.elementAt(i).getVel()};
            posi = moveObjHandler(posi, genericPlane, rng, arrMaxSize);
            objVec.elementAt(i).setX(posi[0]);
            objVec.elementAt(i).setY(posi[1]);
            objVec.elementAt(i).setOri(posi[2]);
        }
        System.out.println("moverOriObjs EXIT");
        return objVec;
    }

    public static int[] moveObjHandler(int[] posi, int[][] genericPlane, Random rng, int[] arrMaxSize) {
        int stepsLeft = posi[3];
        for (int i = 0; i < stepsLeft ; i++) {
            System.out.println("stepsLeft " + stepsLeft);

            System.out.println("pos before " + posi[0] + " | " + posi[1] + " | " + posi[2]);

//x is 0
//-------
            if (posi[0] == 0) {
                
//y is 0 and x is 
//-------
                if (posi[1] == 0) { 
                        switch(rng.nextInt(2 - 1)){
                            case 1:
                                posi[2] = 3;
                                break;
                            case 0:
                                posi[2] = 0;
                                break;
                        }   
                }

//y is max and x is 
//-------
                if (posi[1] == arrMaxSize[1]) {
                    switch(rng.nextInt(2 - 1)){
                        case 1:
                            posi[2] = 1;
                            break;
                        case 0:
                            posi[2] = 0;
                            break;
                    }
                }
//-------

//y is mid and x is 
//-------
                if (posi[1] != arrMaxSize[1] && posi[1] == 0) { //randomly move if somewhere else if walk on the y axis up
                    switch(rng.nextInt(2)){
                        case 2:
                            posi[2] = 0;
                            break;
                        case 1:
                            posi[2] = 1;
                            break;
                        case 0:
                            posi[2] = 3;
                            break;
                    }  
                }
//-------

            }
//-------
//x = 0 end

// x is max
//-------
            if (posi[0] == arrMaxSize[0]) {
// y is 0 and x is max
//------
                if (posi[1] == 0) {
                    switch(rng.nextInt(2 - 1)){
                        case 1:
                            posi[2] = 3;
                            break;
                        case 0:
                            posi[2] = 2;
                            break;
                    }   
                }
//------

//y is max and x is max
//------
                if(posi[1] == arrMaxSize[1]){
                    switch(rng.nextInt(2 - 1)){
                        case 1:
                            posi[2] = 2;
                            break;
                        case 0:
                            posi[2] = 1;
                            break;
                    }   
                }
//------

//y is mid and x is max
//------
                if (posi[1] != 0 && posi[1] != arrMaxSize[1]) {
                    switch(rng.nextInt(2)){
                        case 2:
                            posi[2] = 3;
                            break;
                        case 1:
                            posi[2] = 2;
                            break;
                        case 0:
                            posi[2] = 1;
                            break;
                    }   
                }
//------

            }
//-------
// x is max

// x is mid
//-------
            if (posi[0] != arrMaxSize[0] && posi[0] != 0) {
// y is 0 and x is mid
//------
                if (posi[1] == 0) {
                    switch(rng.nextInt(2)){
                        case 2:
                            posi[2] = 3;
                            break;
                        case 1:
                            posi[2] = 2;
                            break;
                        case 0:
                            posi[2] = 0;
                            break;
                    }
                }
//------

//y is max and x is mid
//------
                if(posi[1] == arrMaxSize[1]){
                    switch(rng.nextInt(2)){
                        case 2:
                            posi[2] = 2;
                            break;
                        case 1:
                            posi[2] = 1;
                            break;
                        case 0:
                            posi[2] = 0;
                            break;
                    }
                }
//------

//y is mid and x is mid
//------
                if (posi[1] != 0 && posi[1] != arrMaxSize[1]) {

                }
//------
            }
//-------
// x is mid

            switch(posi[2]){
                case 0 : 
                    posi[0] = posi[0] ++;
                    break;
                case 1 :
                    posi[1] = posi[1] ++;
                    break;
                case 2 :
                    posi[0] = posi[0] --;
                    break;
                case 3 :
                    posi[1] = posi[1] --;
                    break;
            }

            System.out.println("pos after " + posi[0] + " | " + posi[1] + " | " + posi[2]);
            int[][] genericPlaneLocal = new int[genericPlane.length][genericPlane[0].length];
            genericPlaneLocal[posi[0]][posi[1]] = 1;
            for (int iy = arrMaxSize[1]; i > 0 ; i--) {
                for (int ix = 0; i < arrMaxSize[0]; ix++) {
                    System.out.print(genericPlaneLocal[ix][iy]);
                }
                System.out.println();
            }
        }
// for end
        return posi;
    }
}
