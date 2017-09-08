package seedu.addressbook.data.person;

public class Street {

    private String street;

    public Street(String  address){

        this.street = address.trim();

    }
    public String getStreet(){

        return this.street;
    }
}
