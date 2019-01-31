
//package experiments;

/**
 * testArrPrint
 */
public class testArrPrint {

    public static void main(String[] args) {
        int x = 7;
        int y = 5;
        int[] fill = new int[2];
        doArr(x, y, fill);
    }
    public static void doArr(int x, int y,int[] fill){
        fill[1] = y - 1;
        fill[0] = x - 1;
        int[][] testArr = new int[x][y];
        System.out.println(testArr.length + " " + testArr[1].length);
        System.out.println(x + " " + y);
        testArr[fill[0]][fill[1]] = 1;
        int i = 0;
        int j = 0;
        for (i = 0; i < testArr[0].length; i++) {
            for (j = 0; j < testArr.length; j++) {
                System.out.print(testArr[j][i]);
            }
            System.out.println(" ");
        }
        System.out.println(testArr.length + " " + testArr[0].length);
        System.out.println(j + " " + i);
    }
    public static void printfill(int[][] testArr) {
        for (int i = testArr[0].length - 1 ; i > 0 ; i--) {
            for (int j = 0; j < testArr.length - 1; j++) {
                System.out.print(testArr[j][i]);
            }
            System.out.println(" ");
        }
    }
}
