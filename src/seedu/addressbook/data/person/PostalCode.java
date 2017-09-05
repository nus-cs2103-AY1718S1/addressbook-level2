package seedu.addressbook.data.person;

/**
 * PostalCode: part of the Address class
 */
public class PostalCode extends AddressComponent{

    // Substring after the 3rd comma, before end of line
    private final static String PARSE_POSTAL_CODE_FROM_ADDRESS_REGEX = "^(?:[^,]*,){3}(.*?)$";

    public PostalCode(String unitNumber) {
        super(unitNumber);
    }

    public static PostalCode getFromAddress(String address) {
        PostalCode re = new PostalCode(extractValueFromAddress(address, PARSE_POSTAL_CODE_FROM_ADDRESS_REGEX));
        return re;
    }
}


