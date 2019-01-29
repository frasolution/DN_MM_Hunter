package src;

/**
 * goalPost
 */
public class goalPost {
    public int x;
    public int y;
    public int patern;
    
    public goalPost(int x, int y, int patern){
        this.patern = patern;
        this.x = x;
        this.y = y;
    }
    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * @param patern the patern to set
     */
    public void setPatern(int patern) {
        this.patern = patern;
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
    /**
     * @return the patern
     */
    public int getPatern() {
        return patern;
    }
}