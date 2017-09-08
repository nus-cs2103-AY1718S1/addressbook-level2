package seedu.addressbook.data.person;

/**
 * Represents the postal code in a persons address
 */
public class PostalCode {

    private final String postalCode;

    public PostalCode (String code) {
        postalCode = code;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
