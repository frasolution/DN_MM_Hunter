import java.util.*;

public class rngTest{
// TESTING EFFCIENT FUNCTION USE FOR CREATING OBJECTS
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = rngesus(sc);

        //close
        sc.close();
    }

    public static Random rngesus( Scanner sc ) {
        System.out.print("Do you want to set a seed? / (yes/no) \n");
        String inString = sc.nextLine();
        if(inString.equals("yes")){
            Random rng = new Random(sc.nextInt());
            return rng;
        } else {
            Random rng = new Random();
            return rng;
        }

        
    }
    
}