package seedu.addressbook.data.person.AddressConsists;

/**
 * Represents the postal code of a person's address.
 */
public class PostalCode {

    private String value;

    public PostalCode(String postalCode){
        this.value = postalCode;
    }

    @Override
    public String toString(){
        return value;
    }
}

