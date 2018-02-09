package seedu.addressbook.data.person.AddressConsists;

/**
 * Represents the unit number in a person's address.
 */
public class Unit {

    private String value;

    public Unit(String unitNumber){
        this.value = unitNumber;
    }

    @Override
    public String toString(){
        return value;
    }
}

