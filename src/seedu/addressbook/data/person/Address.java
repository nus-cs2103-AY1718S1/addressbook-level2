package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "Block, Street, Unit, Postal Code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    private Block blockAddress = null;
    private Street streetAddress = null;
    private Unit unitAddress = null;
    private PostalCode postalCodeAddress = null;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();

        //Split and store Block, Street, Unit and Postal Code details
        String[] addressDetails = trimmedAddress.split(",");
        this.blockAddress= new Block(addressDetails[0]);
        this.streetAddress= new Street(addressDetails[1]);
        this.unitAddress= new Unit(addressDetails[2]);
        this.postalCodeAddress= new PostalCode(addressDetails[3]);


        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
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

    public String getBlock(){return blockAddress.getBlockFromClass();}
    public String getStreet(){return streetAddress.getStreetFromClass();}
    public String getUnit(){return unitAddress.getUnitFromClass();}
    public String getPostalCode(){return postalCodeAddress.getPostalCodeFromClass();}
}
