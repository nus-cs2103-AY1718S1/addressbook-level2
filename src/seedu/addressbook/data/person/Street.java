package seedu.addressbook.data.person;

/**
 * Represents a Person's street name in the address book.
 */

public class Street {

    private String streetName;

    /**
     * Constructs a Street using the given String
     * @param streetName
     */
    public Street(String streetName){
        this.streetName = streetName;
    }

    /**
     * Sets the street name of the Person's address
     * @param streetName
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     *
     * @return Person's street name
     */
    public String getStreetName() {
        return streetName;
    }
}
