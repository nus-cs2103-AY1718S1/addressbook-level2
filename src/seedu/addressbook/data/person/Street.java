package seedu.addressbook.data.person;

/**
 * Created by Philemon1 on 5/9/2017.
 */
public class Street {
    private String street;

    public Street(String inputStreet) {
        street = new String(inputStreet);
    }
    public String getValue() {
        return street;
    }
    public void setStreet(String inputStreet) {
        street = inputStreet;
    }
}
