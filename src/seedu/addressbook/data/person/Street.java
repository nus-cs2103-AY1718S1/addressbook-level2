package seedu.addressbook.data.person;

public class Street {
    private String streetName;

    public Street(String value) {
        this.streetName = value;
    }

    public void setStreetName(String value) {
        this.streetName = value;
    }

    public String getStreetName() {
        return this.streetName;
    }
}