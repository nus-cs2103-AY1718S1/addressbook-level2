package seedu.addressbook.data.person;

public class Unit {
    private String _unit;

    /**
     * Constructor
     *
     * @param unit
     */
    public Unit(String unit) {
        _unit = unit;
    }

    /* Getters and Setters*/
    public String getUnit() {
        return _unit;
    }
    public void setUnit(String newUnit) {
        _unit = newUnit;
    }
}
