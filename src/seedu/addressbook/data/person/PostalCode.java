package seedu.addressbook.data.person;

public class PostalCode {
    private String postalCode;

    public PostalCode (String fullAddress) {
        postalCode = SplitAddressByComma.splitAddress(fullAddress)[3];
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return getPostalCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PostalCode) {
            PostalCode toBeCompared = (PostalCode) obj;
            return this.getPostalCode().equals(toBeCompared.getPostalCode());
        }
        return false;
    }
}
