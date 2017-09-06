package seedu.addressbook.data.person;

public class Street {
    private String _street;

    /**
     * Constructor
     * @param street
     */
    public Street(String street) {
        _street = street;
    }

    /*Getters and Setters*/
    public String getStreet() {
        return _street;
    }
    public void setStreet(String newStreet) {
        _street = newStreet;
    }
}
