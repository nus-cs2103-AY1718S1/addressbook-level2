package seedu.addressbook.data.person;

/**
 * Created by Philemon1 on 5/9/2017.
 */
public class PostalCode {
    private int postalCode;

    public PostalCode(int inputPostalCode) {
        postalCode = inputPostalCode;
    }

    public int getValue() {
        return postalCode;
    }

    public void setPostalCode(int inputPostalCode){
        postalCode = inputPostalCode;
    }
}

