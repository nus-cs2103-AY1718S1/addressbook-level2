package seedu.addressbook.data.person;

public class Unit {
    private String unit;
    final public static int UNIT_VALUE_NO = 0;


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Unit(String unit){
        this.unit = unit;
    }
}
