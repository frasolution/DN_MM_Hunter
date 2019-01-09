import java.util.HashSet;

public class HashSetObj{

    public int number;
    public String name;

    public void setNumber(int in){
        number = in;
    }
    public void setString(String in){
        name = in;
    }

    public String getString(){
        return name;
    }
    public int getNumber(){
        return number;
    }

    public static void main(String args[]){
        HashSetObj[] hashTester = new HashSetObj[20];
        hashTester[0] = new HashSetObj();
        hashTester[0].setNumber(6);
        hashTester[0].setString("green");
        //HashSet<HashSetObj[]> hSet = new HashSet<HashSetObj[]>();
        //hSet.add(hashTester);

        HashSetObj[] hashTestPrev = new HashSetObj[20];
        hashTestPrev = hashTester;

        hashTester[1] = new HashSetObj();
        hashTester[1].setNumber(7);
        hashTester[1].setString("peace");

        System.out.println(hashTester.equals(hashTestPrev));
        //System.out.println(hSet.contains(hashTester));

    }
}