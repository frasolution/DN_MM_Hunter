public class objArr{
    public String name;
    public void setString(String passedString){
        name = passedString;
    }
    public String getString(){
        return name;
    }
    public static void main(String args[]) {
        int number = 3 ;
        objArr[] locArr = new objArr[number];
        for( int i = 0; number > i ; i++){
            locArr[i] = new objArr();
            locArr[i].setString( "something " + i );
        }

        printer(locArr);

    }
    
    public static void printer(objArr[] inputArr){
        for ( int i = 0 ; inputArr.length > i ; i++){
            System.out.println( "The " + i + " String is : " + inputArr[1].getString() );
        }
    }

}