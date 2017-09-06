package seedu.addressbook.data.person;

/**
 * Created by Philemon1 on 5/9/2017.
 */
public class Unit {
    private String unit;

    public Unit(String inputUnit){
        unit = new String(inputUnit);
    }
    public String getValue(){
        return unit;
    }
    public void setUnit(String inputUnit){
        unit = inputUnit;
    }


}
