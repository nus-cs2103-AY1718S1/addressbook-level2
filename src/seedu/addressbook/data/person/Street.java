package seedu.addressbook.data.person;

public class Street {
    private String street;

    public Street(String street){
        this.street = street;
    }

    public void setStreet(String newStreet){
        this.street = newStreet;
    }

    public String getStreet(){
        return this.street;
    }
}
