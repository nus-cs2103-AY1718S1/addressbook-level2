package seedu.addressbook.data.person.AddressConsists;

/**
 * Represents the street name in a person's address.
 */
public class Street {

    private String value;

    public Street(String streetName){
        this.value = streetName;
    }

    @Override
    public String toString(){
        return value;
    }
}

