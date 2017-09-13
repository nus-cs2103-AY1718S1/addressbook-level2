package seedu.addressbook.data.person.address;

public class Street {
    private String street_Number;

    public Street(String street) {
        street_Number = street;
    }

    public String getStreet() {
        return street_Number;
    }
}
