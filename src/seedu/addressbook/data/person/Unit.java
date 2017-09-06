package seedu.addressbook.data.person;

/**
 * Represents a Person's block in the address book.
 */

public class Unit {

    public final String value;

    public Unit (String unit) {
        this.value = unit.trim();
    }

    public String getUnit() {
        return this.value;
    }
}
