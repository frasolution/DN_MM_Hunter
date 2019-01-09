//import java.util.HashSet;

public class HashSetObj{

    public int number;
    public void setNumber(int in){ number = in; }
    public int getNumber() { return number; }

    public static void main(String args[]){
        HashSetObj[] hashTester = new HashSetObj[2];
        hashTester[0] = new HashSetObj();
        hashTester[0].setNumber(6);
        //HashSet<HashSetObj[]> hSet = new HashSet<HashSetObj[]>();
        //hSet.add(hashTester);

        HashSetObj[] hashTestPrev = new HashSetObj[2];
        hashTestPrev = hashTester;

        hashTester[1] = new HashSetObj();
        hashTester[1].setNumber(7);

        System.out.println(hashTestPrev.equals(hashTester));
        //System.out.println(hSet.contains(hashTester));

    }
}