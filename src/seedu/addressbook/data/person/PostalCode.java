package seedu.addressbook.data.person;

/**
 * Represents a Person's postal code in the address book.
 */

public class PostalCode {

    private String postalCode;

    /**
     * Constructs a PostalCode using the given String
     * @param postalCode
     */
    public PostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    /**
     * Sets the postal code of the Person's address
     * @param postalCode
     */
    public void setPostal(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return Person's postal code
     */
    public String getPostal() {
        return postalCode;
    }
}
