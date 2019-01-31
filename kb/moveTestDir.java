import java.util.Random;

public class moveTestDir{
    //use as a teplate for collision testing
    private int x;
    private int y;
    private int vel; //only vel 1 has working out of bounds protection
    private int ori;
    /**
         * rotations explained :
         * currently we only want up right down left as orientations
         * but hey we maybe add up-right down-right down-leeft up-left
         * but probaly not since it is not going to add a lot of value and a lot more work, its not hard work just really boring calulations
         * 
         * up = 3
         * right = 0
         * donw = 1
         * left = 2
         * 
    */

    public moveTestDir(int x, int y , int ori , int vel){
        this.x = x;
        this.y = y;
        this.ori = ori;
        this.vel = vel;
    }

    public void move(){ //may change
        
        switch(this.ori){
            case 0 : 
                this.setX(this.getX() + 1);
                break;
            case 1 :
                this.setY(this.getY() + 1);
                break;
            case 2 :
                this.setX(this.getX() - 1);
                break;
            case 3 :
                this.setY(this.getY() - 1);
                break;
        }

    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * @param ori the ori to set
     */
    public void setOri(int ori) {
        this.ori = ori;
    }
    /**
     * @param vel the vel to set
     */
    public void setVel(int vel) {
        this.vel = vel;
    }
    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * @return the ori
     */
    public int getOri() {
        return ori;
    }
    /**
     * @return the vel
     */
    public int getVel() {
        return vel;
    }
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    public static void main(String args[]) throws InterruptedException {
        Random rng = new Random();
        moveTestDir testObj = new moveTestDir(1, 1, 0, 1);
        int[][] plane = new int[testObj.getX()*4][testObj.getY()*4];
        for ( int i = 0 ; i < 10 ; i++) moveAndPrint(plane, testObj, rng);
    }

    public static void moveAndPrint(int[][] planeSize, moveTestDir testObj, Random rng){
        int[][] plane = new int[planeSize.length][planeSize[0].length];
        //ADD RANDOM ORIENTATION BETWEEN 3 2 0 HERE FOR PRODUCTION
        int xm = plane.length - 1; // get x boundries
        int ym = plane[0].length - 1; //get y boundries
        System.out.println("curr pos " + testObj.getX() + " | " + testObj.getY());
//-----------------
        if(testObj.getX() == 0 ){ // x is 0 
            if(testObj.getY() == 0) { // y is 0 and x is 0 
                if(testObj.getOri() == 3) testObj.setOri(0);
                if(testObj.getOri() == 0) testObj.setOri(3);
                justPrint(plane, testObj);
            }
            if (testObj.getY() == ym) { // y is max and x is 0
                if(testObj.getOri() == 0) testObj.setOri(1);
                if(testObj.getOri() == 1) testObj.setOri(0);
                justPrint(plane, testObj);
            }
            if ( testObj.getY() != 0 && testObj.getY() != ym) { //y is in the middle and x is 0
                if(testObj.getOri() == 1){
                    switch(rng.nextInt(3-1)){
                        case 0:
                            testObj.setOri(0);
                            justPrint(plane, testObj);
                            return;
                        case 1:
                            testObj.setOri(2);
                            justPrint(plane, testObj);
                            return;
                        case 3:
                            testObj.setOri(3);
                            justPrint(plane, testObj);
                            return;
                    }
                }
            }
        }
//-------------

//-------------
        if (testObj.getX() == xm ) { // x is max 
            if(testObj.getY() == 0) { // y is 0 and x is max
                if(testObj.getOri() == 3) testObj.setOri(2);
                if(testObj.getOri() == 2) testObj.setOri(3);
                justPrint(plane, testObj);
            }
            if (testObj.getY() == ym) { // y is max and x is max
                if(testObj.getOri() == 1) testObj.setOri(2);
                if(testObj.getOri() == 2) testObj.setOri(1);
                justPrint(plane, testObj);
            }
            if ( testObj.getY() != 0 && testObj.getY() != ym) { // y is middle and x is max
                if(testObj.getOri() == 0){
                    switch(rng.nextInt(3-1)){
                        case 0:
                            testObj.setOri(2);
                            justPrint(plane, testObj);
                            return;
                        case 1:
                            testObj.setOri(1);
                            justPrint(plane, testObj);
                            return;
                        case 3:
                            testObj.setOri(3);
                            justPrint(plane, testObj);
                            return;
                    }
                } 
            }
        }
//------------------

//-------------------
        if(testObj.getX() != 0 && testObj.getX() != xm ) { //anything in the middle
            if(testObj.getY() == 0) { // y is 0 and x is middle
                if(testObj.getOri() == 1){
                    switch(rng.nextInt(3-1)){
                        case 0:
                            testObj.setOri(0);
                            justPrint(plane, testObj);
                            return;
                        case 1:
                            testObj.setOri(2);
                            justPrint(plane, testObj);
                            return;
                        case 3:
                            testObj.setOri(3);
                            justPrint(plane, testObj);
                            return;
                    }
                }
            } 
            if (testObj.getY() == ym) { // y is max and x is middle
                if(testObj.getOri() == 3){
                    switch(rng.nextInt(3-1)){
                        case 0:
                            testObj.setOri(0);
                            justPrint(plane, testObj);
                            return;
                        case 1:
                            testObj.setOri(2);
                            justPrint(plane, testObj);
                            return;
                        case 3:
                            testObj.setOri(1);
                            justPrint(plane, testObj);
                            return;
                    }
                }
            } 
            if ( testObj.getY() != 0 && testObj.getY() != ym) {  // y is middle and x is middle
                justPrint(plane, testObj);
            }
        }
//---------------

    }
    public static void justPrint(int[][] plane, moveTestDir testObj){
        System.out.println(testObj.getX() + " " + testObj.getY() + " " + testObj.getOri());
        plane[testObj.getX()][testObj.getY()] = 1 ;
        System.out.print("------\n");
        for( int iy = plane[0].length - 1; iy >= 0 ; iy-- ){
            System.out.print("|");
            for ( int ix = 0 ; ix < plane.length ; ix++ ){
                System.out.print(plane[ix][iy]);
            }
            System.out.println("|");
        }
        System.out.print("------\n");
        testObj.move();
    }


}