package seedu.addressbook.data.person;

public class Unit {
    private String unit;

    public Unit(String unit){
        this.unit = unit;
    }

    public void setUnit(String newUnit){
        this.unit = newUnit;
    }

    public String getUnit(){
        return this.unit;
    }
}
