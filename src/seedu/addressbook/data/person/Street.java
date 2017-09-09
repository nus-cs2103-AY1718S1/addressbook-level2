package seedu.addressbook.data.person;
import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

public class Street {
    private String street;

    public Street(String street){
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}
