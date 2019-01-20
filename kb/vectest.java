import java.util.Vector;
import src.vectest2;
public class vectest{
    private String name;
    private int number;
    public vectest(String name, int number){
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
    public static void main(String[] args) {
        Vector<vectest2> vec = new Vector<vectest2>();
        //this doesn't work correctly, settings is (1,1) as standard
        //create with empty bracets
        //vectest2 adder = new vectest2("alex", 1);
        vec.add(new vectest2("oli", 2));
        vec.add(new vectest2("john", 1));
        System.out.print("Size " + vec.size() + "\n");
        for ( int i = 0; i < vec.size() ; i++ ) System.out.println(vec.elementAt(i).getName() + " " + vec.elementAt(i).getNumber());
        for ( int i = 0 ; i < vec.size() ; i++ ) System.out.println(vec.elementAt(i).custCmp(new vectest2("oli",2)));
    }
}