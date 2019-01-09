import java.util.Random;

public class ArrPassTest{
    public static void main(String args[]) {
        int[] smallArr = new int[3];
        int[] enter = { 3 , 4 , 5 };
        smallArr = arrPas(enter);
        for( int i = 0 ; smallArr.length > i ; i++){
            System.out.print(smallArr[i] + " ");
        }
        System.out.println("");
    }
    public static int[] arrPas(int[] var) {
        Random rng = new Random();
        int[] smallArr = new int[3];
        smallArr[0] = rng.nextInt(var[0]);
        smallArr[1] = rng.nextInt(var[1]);
        smallArr[2] = rng.nextInt(var[2]);
        return smallArr;
    }
}