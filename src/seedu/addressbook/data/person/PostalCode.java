package seedu.addressbook.data.person;

public class PostalCode {
    private String postalCodeNumber;

    public PostalCode(String value) {
        this.postalCodeNumber = value;
    }

    public void setPostalCodeNumber(String value) {
        this.postalCodeNumber = value;
    }

    public String getPostalCodeNumber() {
        return this.postalCodeNumber;
    }
}
