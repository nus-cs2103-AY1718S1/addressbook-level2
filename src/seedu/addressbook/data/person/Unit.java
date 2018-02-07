package seedu.addressbook.data.person;

/**
 * Represents the unit of a person's address.
 */

public class Unit {
    private static String unit;

    public Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
