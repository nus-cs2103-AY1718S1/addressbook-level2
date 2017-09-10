package seedu.addressbook.data.person;

/**
 * Represents a Person's postal code in the address book.
 */
public class PostalCode {

    public String postalCode;

    public PostalCode (String postalCode) {
        this.postalCode = postalCode;
    }

    public final void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() { return "Postal Code: " + postalCode; }

}