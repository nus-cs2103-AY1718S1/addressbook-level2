package seedu.addressbook.data.person;
import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

public class Unit {
    private String unit;

    public Unit(String unit){
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
