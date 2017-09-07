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

    private static final int INDEX_BLOCK = 0;
    private static final int INDEX_STREET = 1;
    private static final int INDEX_UNIT = 2;
    private static final int INDEX_POSTALCODE = 3;
    private static final int NUMBER_OF_ADDRESS_SUBCLASSES = 4;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String[] preInitArray = {"", "", "", ""};
        String[] splitAddress = address.split(",");
        String trimmedAddress = address.trim();
        if (!isValidAddress(address)){
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        for (int i = 0; i < splitAddress.length; i++){
            preInitArray[i] = splitAddress[i];
        }

        this.isPrivate = isPrivate;

        this.block = new Block(preInitArray[INDEX_BLOCK], isPrivate);
        this.street = new Street(preInitArray[INDEX_STREET], isPrivate);
        this.unit = new Unit(preInitArray[INDEX_UNIT], isPrivate);
        this.postalCode = new PostalCode(preInitArray[INDEX_POSTALCODE], isPrivate);

        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {

        String trimmedAddress = test.trim();
        boolean isBlankAddress = isAddressEmpty(test);

        return test.matches(ADDRESS_VALIDATION_REGEX)
                && isBlankAddress
                && !trimmedAddress.isEmpty();
    }

    private static boolean isAddressEmpty(String address) {
        String[] splitAddress = address.split(",");
        int emptyCount = 0;

        for (String splitAddres : splitAddress) {
            if (splitAddres.isEmpty()) {
                emptyCount++;
            }
        }
        return emptyCount != NUMBER_OF_ADDRESS_SUBCLASSES;
    }

    @Override
    public String toString() {
        String block = this.block.toString();
        String street = this.street.toString();
        String unit = this.unit.toString();
        String postalCode = this.postalCode.toString();
        String[] addresses = {block, street, unit, postalCode};

        String fullAddress = "";
        for (String s : addresses){
            if (!s.isEmpty()){
                fullAddress = fullAddress + s + ",";
            }
        }

        fullAddress = fullAddress.substring(0, fullAddress.length()-1);

        return fullAddress;
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
