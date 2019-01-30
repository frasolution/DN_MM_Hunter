
public class viscone{  //this should be a class function
    public static void main(String[] args) {
        int[][] plane = new int[10][10];
        int[][] test = new int[10][10];
        int len = 6; //This is the length of the vis cone
        int x = 0; //x of the start point
        int y = 2; //y of the start point
        test = fillStart(plane, len, x, y);
        printCust(test);
        plane[0][3] = 5; //this is you
        plane[3][4] = 3; //this is the other object
        int[] firstOverlap = new int[2];
        firstOverlap = overlap(plane, test, 0);
        System.out.println("------------");
        System.out.println(firstOverlap[0] + " " + firstOverlap[1]);
        test[firstOverlap[0]][firstOverlap[1]] = 0;
        System.out.println("------------");
        printCust(test);
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
        System.out.println(len+ "\n");
        int y0 = y;
        if(len == 0) return arrCurr;
        y--;
        x++;
        //actual writing
        for(int i = 0; i < count; i++) { //if the there is
            if(!(y+i < 0 || x+i <0 || y+i > arrCurr[1].length - 1 || x > arrCurr[0].length - 1 )){    
                if(y0 > y+i ) arrCurr[x][y+i] = 1;
                if(y0 == y+i ) arrCurr[x][y+i] = 2;
                if(y0 < y+i) arrCurr[x][y+i] = 3;
            }
        }
        count = count + 2;
        len--;
        fillAct(arrCurr, len, count, x, y);
        return arrCurr;
    }

    public static int[] overlap (int[][] plane, int[][] test, int objOri) {
        int[] returner = new int[2];
        switch(objOri){
            case 0 : 
                for ( int ix = 0 ; ix < plane[0].length ; ix++ ) {
                    for ( int iy = 0 ; iy < plane[1].length ; iy++ ) {
                        if(plane[ix][iy] != 0 && test[ix][iy] != 0){
                            switch(test[ix][iy]){
                                case 1:
                                    returner[0] = ix;
                                    returner[1] = iy;
                                    return returner;
                                case 2:
                                    returner[0] = ix;
                                    returner[1] = iy;
                                    return returner;
                                case 3:
                                    returner[0] = ix;
                                    returner[1] = iy;
                                    return returner;
                            }
                        }
                    }
                }

            case 1 :
                for ( int iy = 0 ; iy < plane[1].length ; iy++){
                    for( int ix = 0 ; ix < plane[0].length ; ix++ ){
                        if(plane[ix][iy] != 0 && test[ix][iy] != 0){
                            if(plane[ix][iy] != 0 && test[ix][iy] != 0){
                                switch(test[ix][iy]){
                                    case 1:
                                        returner[0] = ix;
                                        returner[1] = iy;
                                        return returner;
                                    case 2:
                                        returner[0] = ix;
                                        returner[1] = iy;
                                        return returner;
                                    case 3:
                                        returner[0] = ix;
                                        returner[1] = iy;
                                        return returner;
                                }
                            }
                        }
                    }
                }
            case 2 :
                for ( int ix = 0 ; ix < plane[0].length ; ix++){
                    for ( int iy = 0 ; iy < plane[1].length ; iy++){
                        if(plane[ix][iy] != 0 && test[ix][iy] != 0){
                            if(plane[ix][iy] != 0 && test[ix][iy] != 0){
                                switch(test[ix][iy]){
                                    case 1:
                                        returner[0] = ix;
                                        returner[1] = iy;
                                        return returner;
                                    case 2:
                                        returner[0] = ix;
                                        returner[1] = iy;
                                        return returner;
                                    case 3:
                                        returner[0] = ix;
                                        returner[1] = iy;
                                        return returner;
                                }
                            }
                        }
                    }
                }
            case 3 :
                for ( int iy = 0 ; iy < plane[1].length ; iy++ ) {
                    for ( int ix = 0 ; ix < plane[0].length ; ix++ ) {
                        if(plane[ix][iy] != 0 && test[ix][iy] != 0){
                            switch(test[ix][iy]){
                                case 1:
                                    returner[0] = ix;
                                    returner[1] = iy;
                                    return returner;
                                case 2:
                                    returner[0] = ix;
                                    returner[1] = iy;
                                    return returner;
                                case 3:
                                    returner[0] = ix;
                                    returner[1] = iy;
                                    return returner;
                            }
                        }
                    } 
                }
        }
        return returner;
    }

    public static void printCust(int[][] arrCurr) {
        for( int y = 0 ; y < arrCurr[0].length ; y++ ) {
            for ( int x = 0 ; x < arrCurr[1].length ; x++ ) {
                if(arrCurr[x][y] != 0){
                    System.out.print('*');
                }
                else System.out.print('+');
            }
            System.out.print("\n");
        }
    }

}