package seedu.addressbook.data.person;
import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

public class PostalCode {
    private String postalCode;

    public PostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
