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

    //using IDE HELP FROM A CODE EDITOR FOR THE FIRST TIME
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
        moveTestDir testObj = new moveTestDir(1, 1, 0, 1);
        int[][] plane = new int[testObj.getX()*4][testObj.getY()*4];
        for ( int i = 0 ; i < 10 ; i++) moveAndPrint(plane, testObj);
    }

    public static void moveAndPrint(int[][] planeSize, moveTestDir testObj){
        int[][] plane = new int[planeSize[0].length][planeSize[1].length];
        //ADD RANDOM ORIENTATION BETWEEN 3 2 0 HERE FOR PRODUCTION
        if(testObj.getX() == 0 ){
            if(testObj.getY() == 0) {
                if(testObj.getOri() == 3) testObj.setOri(0);
                if(testObj.getOri() == 0) testObj.setOri(3);
                justPrint(plane, testObj);
            } else if (testObj.getY() == plane[1].length) {
                if(testObj.getOri() == 0) testObj.setOri(1);
                if(testObj.getOri() == 1) testObj.setOri(0);
                justPrint(plane, testObj);
            } else { 
                if(testObj.getOri() == 0) testObj.setOri(1);
                if(testObj.getOri() == 1) testObj.setOri(3);
                if(testObj.getOri() == 3) testObj.setOri(0);
                justPrint(plane, testObj);
            }
        } else if (testObj.getX() == plane[0].length ) {
            if(testObj.getY() == 0) {
                if(testObj.getOri() == 3) testObj.setOri(2);
                if(testObj.getOri() == 2) testObj.setOri(3);
                justPrint(plane, testObj);
            } else if (testObj.getY() == plane[1].length) {
                if(testObj.getOri() == 1) testObj.setOri(2);
                if(testObj.getOri() == 2) testObj.setOri(1);
                justPrint(plane, testObj);
            } else {
                if(testObj.getOri() == 1) testObj.setOri(2);
                if(testObj.getOri() == 2) testObj.setOri(3);
                if(testObj.getOri() == 3) testObj.setOri(1);
                justPrint(plane, testObj);
            }
        } else {
            if(testObj.getY() == 0) {
                if(testObj.getOri() == 0) testObj.setOri(2);
                if(testObj.getOri() == 2) testObj.setOri(3);
                if(testObj.getOri() == 3) testObj.setOri(0);
                justPrint(plane, testObj);
            } else if (testObj.getY() == plane[1].length) {
                if(testObj.getOri() == 0) testObj.setOri(1);
                if(testObj.getOri() == 1) testObj.setOri(2);
                if(testObj.getOri() == 2) testObj.setOri(0);
                justPrint(plane, testObj);
            } else {
                justPrint(plane, testObj);
            }
        } 

    }
    
    public static void justPrint(int[][] plane, moveTestDir testObj){
        plane[testObj.getX()][testObj.getY()] = 1 ;
        System.out.print("------\n");
        for( int iy = 0 ; iy < plane[1].length ; iy++ ){
            System.out.print("|");
            for ( int ix = 0 ; ix < plane[0].length ; ix++ ){
                System.out.print(plane[ix][iy]);
            }
            System.out.println("|");
        }
        System.out.print("------\n");
        testObj.move();
    }

}