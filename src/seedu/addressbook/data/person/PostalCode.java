package seedu.addressbook.data.person;

/**
 * Represents the postal code of a person's address.
 */
public class PostalCode {
    private static String postalCode;

    public PostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
