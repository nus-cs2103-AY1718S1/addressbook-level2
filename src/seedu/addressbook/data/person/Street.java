package seedu.addressbook.data.person;

public class Street extends AddressComponent{

    private final static String PARSE_STREET_FROM_ADDRESS_REGEX = "^(?:.*?),(.*?)(?:,|$)";

    public Street(String streetNumber) {
        super(streetNumber);
    }

    public static PostalCode getFromAddress(String address) {
        PostalCode re = new PostalCode(extractValueFromAddress(address, PARSE_STREET_FROM_ADDRESS_REGEX));
        return re;
    }
}
