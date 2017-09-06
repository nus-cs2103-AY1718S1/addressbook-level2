package seedu.addressbook.data.person;

/**
 * Represents an Address' Unit in the address book.
 * Guarantees: is an string.
 */

public class Unit {
    private String unitNo;

    public Unit(String unitNumber) {
        this.unitNo = unitNumber;
    }

    public String getUnit() {
        return unitNo;
    }


}