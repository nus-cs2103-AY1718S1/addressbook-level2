package seedu.addressbook.data.person;

public class PostalCode {
    private int postalCode;
    final public static int POSTAL_CODE_VALUE_NO = 3;


    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public PostalCode(int postalCode){
        this.postalCode = postalCode;
    }
}
