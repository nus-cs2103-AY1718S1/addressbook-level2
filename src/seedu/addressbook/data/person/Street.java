package seedu.addressbook.data.person;

public class Street {
    private String myStreet;

    Street (String inputStreet){
        myStreet=inputStreet;
    }

    public String getStreetFromClass(){
        return myStreet;
    }

    public void editAddress(String newAddress){
        myStreet=newAddress;
    }

}
