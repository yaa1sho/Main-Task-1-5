package eban;

public class Month {

    private static final String[] monthArray  = {"January", "February","March","April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    private int value;

    public Month(int value){
        this.value = value;
    }

    public String getMonth(){
        return monthArray[value - 1];
    }

}
