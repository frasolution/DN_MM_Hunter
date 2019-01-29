//custom pack
package src;

public class oriObj{
    private int x;
    private int y;
    private int ori;
    private int faction;
    private goalPost goalPost;

    public oriObj(int x, int y, int ori, int faction){
        this.x = x;
        this.y = y;
        this.ori = ori;
        this.faction = faction;
    }
    
    public boolean equalsOri(oriObj o) {
        boolean test = false;
        if(this.getX() == o.getX() && this.getY() == o.getY()) test = true;
        return test;
    }

    /**
     * @return int return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return int return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return int return the ori
     */
    public int getOri() {
        return ori;
    }

    /**
     * @param ori the ori to set
     */
    public void setOri(int ori) {
        this.ori = ori;
    }

    /**
     * @return int return the faction
     */
    public int getFaction() {
        return faction;
    }

    /**
     * @param faction the faction to set
     */
    public void setFaction(int faction) {
        this.faction = faction;
    }
    /**
     * @param goalPost the goalPost to set
     */
    public void setGoalPost(goalPost goalPost) {
        this.goalPost = goalPost;
    }
    /**
     * @return the goalPost
     */
    public goalPost getGoalPost() {
        return goalPost;
    }
}