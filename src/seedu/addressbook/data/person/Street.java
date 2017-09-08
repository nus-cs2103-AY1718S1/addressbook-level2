package seedu.addressbook.data.person;

/**
 * Represents the Street name in a persons address
 */
public class Street {

    private final String streetName;

    public Street(String street) {
        streetName = street;
    }

    public String getStreetName() {
        return streetName;
    }
}
