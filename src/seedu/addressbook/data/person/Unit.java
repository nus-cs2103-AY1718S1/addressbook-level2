package seedu.addressbook.data.person;

public class Unit {

    private String unit;

    public Unit(String  address){

        this.unit = address.trim();

    }
    public String getUnit(){

        return this.unit;
    }
}
