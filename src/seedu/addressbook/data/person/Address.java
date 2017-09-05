package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        String[] values_temp = trimmedAddress.split(", ");
        String[] detailed_values = new String[4];
        for (int i = 0; i < detailed_values.length; i++) {
            detailed_values[i] = "";
        }
        for (int i = 0; i < values_temp.length; i++) {
            detailed_values[i] = values_temp[i];
        }

        block = new Block(detailed_values[0]);
        street = new Street(detailed_values[1]);
        unit = new Unit(detailed_values[2]);
        postalCode = new PostalCode(detailed_values[3]);

        this.value = getAddressValue();
    }

    /**
     * Set the integrated address value.
     */
    public String getAddressValue() {
        StringBuffer sb = new StringBuffer();
        if (!block.getValue().equals("")) {
            sb.append(block.getValue());
        }
        if (!street.getValue().equals("")) {
            sb.append(", ");
            sb.append(street.getValue());
        }
        if (!unit.getValue().equals("")) {
            sb.append(", ");
            sb.append(unit.getValue());
        }
        if (!postalCode.getValue().equals("")) {
            sb.append(", ");
            sb.append(postalCode.getValue());
        }

        return sb.toString();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
