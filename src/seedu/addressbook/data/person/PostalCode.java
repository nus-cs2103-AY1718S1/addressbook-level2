package seedu.addressbook.data.person;

public class PostalCode {
    private int _postalCode;

    /**
     * Constructor
     *
     * @param postalCode
     */
    public PostalCode(int postalCode) {
        _postalCode = postalCode;
    }

    /* Getters and Setters*/
    public int getPostalCode() {
        return _postalCode;
    }
    public void setPostalCode(int newCode) {
        _postalCode = newCode;
    }
}
