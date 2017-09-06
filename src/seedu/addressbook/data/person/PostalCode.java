package seedu.addressbook.data.person;

public class PostalCode {
    String postalCodeName;

    public PostalCode(String postalCode) {
        postalCodeName = postalCode;
    }

    String getPostalCodeName() {
        return postalCodeName;
    }

    void setPostalCodeName(String postalCode) {
        postalCodeName = postalCode;
    }
}
