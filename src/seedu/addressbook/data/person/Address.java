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

    // I understand that I should remove this value but until I understand the rest of the code base
    // that makes use of this value. I will make changes.
    public final String value;
    private boolean isPrivate;

    private BlockNum block = new BlockNum();
    private Street street = new Street();
    private Unit unit = new Unit();
    private PostalCode postalCode = new PostalCode();

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
        this.value = trimmedAddress;
        String[] splittedAddress = trimmedAddress.split(",");
        for (int i = 0; i < splittedAddress.length; i++){
            if (i == 0){
                this.block.setValue(splittedAddress[0]);
            }
            if (i == 1){
                this.street.setValue(splittedAddress[1]);
            }
            if (i == 2){
                this.unit.setValue(splittedAddress[2]);
            }
            if (i == 3){
                this.postalCode.setValue(splittedAddress[3]);
            }
        }
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
