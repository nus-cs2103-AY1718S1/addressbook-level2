package seedu.addressbook.data.person;

/**
 * Represents a Person's unit in the address book.
 */
public class Unit {

    public String unit;

    public Unit (String unit) {
        this.unit = unit;
    }

    public final void setUnitNumber(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() { return "Unit: " + unit; }

}