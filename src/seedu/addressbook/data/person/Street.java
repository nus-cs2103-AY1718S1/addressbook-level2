package seedu.addressbook.data.person;

/**
 * Street: part of the Address class
 */
public class Street extends AddressComponent{

    // Substring between 1st and (2nd comma or end of line)
    private final static String PARSE_STREET_FROM_ADDRESS_REGEX = "^(?:.*?),(.*?)(?:,|$)";

    public Street(String streetNumber) {
        super(streetNumber);
    }

    public static PostalCode getFromAddress(String address) {
        PostalCode re = new PostalCode(extractValueFromAddress(address, PARSE_STREET_FROM_ADDRESS_REGEX));
        return re;
    }
}
