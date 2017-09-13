package seedu.addressbook.data.person.address;

public class Postal_Code {

    private String postalCode_Number;

    public Postal_Code(String postalCode) {
        postalCode_Number = postalCode;
    }

    public String getPostalCode() {
        return postalCode_Number;
    }
}
