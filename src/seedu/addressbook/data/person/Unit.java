package seedu.addressbook.data.person;

/**
 * Unit: part of the Address class
 */
public class Unit extends AddressComponent{

    // Substring between 2nd comma and (3rd comma or end of line)
    private final static String PARSE_UNIT_FROM_ADDRESS_REGEX = "^(?:[^,]*,){2}(.*?)(?:,|$)";

    public Unit(String unitNumber) {
        super(unitNumber);
    }

    public static Unit getFromAddress(String address) {
        Unit re = new Unit(extractValueFromAddress(address, PARSE_UNIT_FROM_ADDRESS_REGEX));
        return re;
    }
}
