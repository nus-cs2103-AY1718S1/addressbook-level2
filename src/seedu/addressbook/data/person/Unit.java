package seedu.addressbook.data.person;

public class Unit extends AddressComponent{

    private final static String PARSE_UNIT_FROM_ADDRESS_REGEX = "a/(?:.*{2}),(.*?),.*$";

    public Unit(String unitNumber) {
        super(unitNumber);
    }

    public static Unit getFromAddress(String address) {
        Unit re = new Unit(extractValueFromAddress(address, PARSE_UNIT_FROM_ADDRESS_REGEX));
        return re;
    }
}
