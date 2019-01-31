
import java.util.Vector;
import src.oriObj;
/*
 * fight
 */
public class fight {

    public static void main(String[] args) {
        Vector<oriObj> objVec = new Vector<oriObj>();
        //testing small to hunter
        objVec.add(new oriObj(1, 1, 0, 3, 0));
        objVec.add(new oriObj(1, 1, 0, 2, 0));
        //testing big to hunter
        objVec.add(new oriObj(1, 1, 0, 3, 0));
        objVec.add(new oriObj(1, 1, 0, 2, 0));
        

        int[][] hunterPlane = new int[4][4];
        int[][] hunterPlaneVec = new int[4][4];
        int hunterAmount = 0;
        int[][] prey1Plane = new int[4][4];
        int[][] prey1PlaneVec = new int[4][4];
        int prey1amount = 0;
        int[][] prey2Plane = new int[4][4];
        int[][] prey2PlaneVec = new int[4][4];
        int prey2Amount = 0;

        int maxValueOnPlane = (1 + (hunterPlane.length * hunterPlaneVec[0].length));

        for (int i = 0; i < hunterPlaneVec.length; i++) {
            for (int j = 0; j < hunterPlaneVec[0].length; j++) {

                hunterPlaneVec[j][i] = maxValueOnPlane;
                prey1PlaneVec[j][i] = maxValueOnPlane;
                prey2PlaneVec[j][i] = maxValueOnPlane;
            }
        }

        for (int i = 0; i < objVec.size(); i++) {
            switch (objVec.elementAt(i).getFaction()) {
                case 2:
                    prey1Plane[objVec.elementAt(i).getX()][objVec.elementAt(i).getY()] = 1;
                    prey1PlaneVec[objVec.elementAt(i).getX()][objVec.elementAt(i).getY()] = i;
                    break;
                case 3:
                    hunterPlane[objVec.elementAt(i).getX()][objVec.elementAt(i).getY()] = 1;
                    hunterPlaneVec[objVec.elementAt(i).getX()][objVec.elementAt(i).getY()] = 1;
                    break;
                case 4:
                    prey2Plane[objVec.elementAt(i).getX()][objVec.elementAt(i).getY()] = 1;
                    prey2PlaneVec[objVec.elementAt(i).getX()][objVec.elementAt(i).getY()] = 1;
                    break;
            }
        }
        
        for (int i = 0; i < prey1Plane.length; i++) {
            for (int j = 0; j <prey1Plane[0].length; j++) {
                if(hunterPlaneVec[j][i] != maxValueOnPlane){
                    objVec.elementAt(hunterPlaneVec[j][i]).attack)
                }
            }
        }
    }
}
