package seedu.addressbook.data.person.address;

/**
 * A common interface for components of an address (block, street, unit, postal code).
 *
 * @author Niu Yunpeng
 */
public interface AddressComponent {
    /**
     * Three compulsory String constants for each address component.
     */
    String EXAMPLE = null;
    String MESSAGE_ADDRESS_CONSTRAINTS = null;
    String ADDRESS_VALIDATION_REGEX = ".+";

    /**
     * Separates different components in the same overall address.
     *
     * Notice: output delimiter has a whitespace while the input delimiter does not. The input could be trimmed
     * anyway. The output must be separated with a whitespace to accord with English grammatical requirement.
     */
    String ADDRESS_INPUT_DELIMITER = ",";
    String ADDRESS_OUTPUT_DELIMITER = ", ";

    /**
     * Checks whether the given string is valid to be used as this address component.
     *
     * @param address is the given string.
     * @return true if the given string is valid.
     */
    boolean isValidAddress(String address);

    /**
     * Gets the value (in String format) of this address component.
     *
     * @return the address value in String format.
     */
    String getValue();
}
