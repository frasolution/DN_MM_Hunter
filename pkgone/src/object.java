/**
 * object
 */
public class object {

    private int faction;
    private int x;
    private int y;
    private int rotation;
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
    public object(int faction, int x, int y, int rotation){
        this.faction = faction;
        this.rotation = rotation;
        this.x = x;
        this.y = y;
    }
    /**
     * @param faction the faction to set
     */
    public void setFaction(int faction) {
        this.faction = faction;
    }
    /**
     * @param rotation the rotation to set
     */
    public void setRotation(int rotation) {
        this.rotation = rotation;
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
     * @return the faction
     */
    public int getFaction() {
        return faction;
    }/**
     * @return the rotation
     */
    public int getRotation() {
        return rotation;
    }/**
     * @return the x
     */
    public int getX() {
        return x;
    }/**
     * @return the y
     */
    public int getY() {
        return y;
    }
    public boolean isSameFaction(object other){
        if(this.getFaction() == other.getFaction()) return true;
        else return false;
    }
}