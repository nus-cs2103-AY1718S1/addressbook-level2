package seedu.addressbook.data.person;

/**
 * Represents the unit number in a persons address
 */
public class Unit {

    private final String unitNumber;

    public Unit(String unit) {
        unitNumber = unit;
    }

    public String getUnitNumber() {
        return unitNumber;
    }
}
