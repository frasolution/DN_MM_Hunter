package kb.src;
public class vectest2{
    private String name;
    private int number;
    public vectest2(String name, int number){
        this.name = name;
        this.number = number;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }
    public void setAll(String name, int number){
        this.name = name;
        this.number = number;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

}