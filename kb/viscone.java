import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

public class viscone{
    public static void main(String[] args) {
        int[][] plane = new int[10][10];
        int[][] test = new int[10][10];
        int len = 6;
        //double pos = 1.2;
        int x = 0;
        int y = 3;
        test = fillStart(plane, len, x, y);
        int fillSize = printCust(test);
        plane[0][3] = 5;
        plane[3][4] = 3;
        
    }
    
    public static int[][] fillStart(int[][] plane, int len, int x, int y) {
        int[][] arrCurr = new int[plane[0].length][plane[1].length];        
        x++;    
        len--;
        arrCurr[x][y] = 1;
        int count = 3;
        arrCurr = fillAct(arrCurr, len, count, x, y);
        return arrCurr;
    }

    public static int[][] fillAct(int[][] arrCurr, int len, int count, int x, int y){
        //out bounds protect
        int y0 = y;
        if(y <= 0 || x >= arrCurr[0].length) return arrCurr;
        y--;
        x++;
        //actual writing
        for(int i = 0; i < count; i++) { //if the there is
            if(y0 > y+i ) arrCurr[x][y+i] = 1;
            if(y0 == y+i ) arrCurr[x][y+i] = 2;
            if(y0 < y+i) arrCurr[x][y+i] = 3;
        }
        count = count + 2;
        fillAct(arrCurr, len, count, x, y);
        return arrCurr;
    }

    public static int[] overlap (int[][] plane, int[][] test, int fillSize, int objOri) {
        int[] returner = new int[fillSize*3];
        switch(objOri){
            case 0 : 
                
                break;
            case 1 :
                break;
            case 2 :
                break;
            case 3 :
                break;
        }
        if(objOri == 0 && objOri == 2){

        }
        if(objOri == 1 && objOri == 3){

        }
        for ( int iy = 0 ; iy < plane[1].length ; iy++ ){
            for ( int ix = 0 ; ix < plane[0].length ; ix++){
                if(plane[ix][iy] != 0 && test[ix][iy] != 0){

                }
            }
        }
        return returner;
    }

    if(plane[ix][iy] != 0 && test[ix][iy] != 0)

    public static int printCust(int[][] arrCurr) {
        int fillSize = 0;
        for( int y = 0 ; y < arrCurr[0].length ; y++ ) {
            for ( int x = 0 ; x < arrCurr[1].length ; x++ ) {
                if(arrCurr[x][y] != 0){
                    System.out.print('*');
                    fillSize++;
                }
                else System.out.print('+');
            }
            System.out.print("\n");
        }
        return fillSize;
        
    }

}