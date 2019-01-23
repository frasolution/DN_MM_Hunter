import java.util.Scanner;
public class objArrTest{
    private int number;
    private String name;
    // actually not required here but I want to have it for cpy pst
    public void setName(String in){
		name = in;
	}
    public void setNumber(int in){
		number = in;
    }
    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //just for demonstartion
        int arrsize = sc.nextInt(); //can grab the number of objects that need to be crated from ui
        objArrTest [] arrs = new objArrTest[arrsize]; 
        // create an array for objects to be saved in. USE ARRAYLIST FOR THIS IN FINAL FOR EASY EXPANSION
        for(int i = 0 ; i < arrsize ; i++ ){
            arrs[i] = new objArrTest(); //create new object
            arrs[i].setName( "test Object " + i ); //set name of object
            arrs[i].setNumber( i ); //set number of object
        }
        for(int i = 0 ; i < arrsize ; i++ ){
            System.out.println("id : " + arrs[i].getNumber() + " name : " + arrs[i].getName() ); //sysout for testing
        }
    }
}
