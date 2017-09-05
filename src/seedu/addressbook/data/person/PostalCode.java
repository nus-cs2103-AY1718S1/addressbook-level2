package seedu.addressbook.data.person;

public class PostalCode extends AddressComponent{

    private final static String PARSE_POSTAL_CODE_FROM_ADDRESS_REGEX = "a/(?:.*{3}),\\s*([0-9]{6})$";

    public PostalCode(String unitNumber) {
        super(unitNumber);
    }

    public static PostalCode getFromAddress(String address) {
        PostalCode re = new PostalCode(extractValueFromAddress(address, PARSE_POSTAL_CODE_FROM_ADDRESS_REGEX));
        return re;
    }
}


