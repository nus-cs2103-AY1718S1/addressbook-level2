package seedu.addressbook.data.person;

public class Unit {
    private String unit;

    public Unit (String fullAddress) {
        unit = SplitAddressByComma.splitAddress(fullAddress)[2];
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return getUnit();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Unit) {
            Unit toBeCompared = (Unit) obj;
            return this.getUnit().equals(toBeCompared.getUnit());
        }
        return false;
    }
}
