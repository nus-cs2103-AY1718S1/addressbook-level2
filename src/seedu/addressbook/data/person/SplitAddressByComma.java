package seedu.addressbook.data.person;

/**
 * Splits address into an array containing Block, Street, Unit, Postal Code respectively
 */

public class SplitAddressByComma {
    public static final String ADDRESS_SEPARATOR_COMMA = ", ";
    public static String[] splitAddress(String fullAddress) {
        return fullAddress.split(ADDRESS_SEPARATOR_COMMA);
    }
}
