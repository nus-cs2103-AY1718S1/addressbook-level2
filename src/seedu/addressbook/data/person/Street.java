package seedu.addressbook.data.person;

public class Street {
    private  String street;
    final public static int STREET_VALUE_NO = 1;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Street(String street){
        this.street = street;
    }
}
