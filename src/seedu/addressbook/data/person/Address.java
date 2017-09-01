package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    //These cannot be final at this time point, as we haven't figured out how to reverse engineer these objects
    private  Block block;
    private Street street;
    private Unit unit;
    private Postal postal;

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
    }

    /**
     * Initiates and validate the given component objects of the address object
     * This is another version of the constructor
     * @param block - block object
     * @param street - street object
     * @param unit - unit object
     * @param postal - postal object
     * @param isPrivate - isPrivate boolean signalling input
     * @throws IllegalValueException
     */
    public Address(Block block, Street street, Unit unit, Postal postal,
                   boolean isPrivate) throws IllegalValueException {
        this.block = block;
        this.street = street;
        this.unit = unit;
        this.postal = postal;
        if (!block.isValidBlockObject()|
                !street.isValidStreetObject()|
                !unit.isValidUnitObject()|
                !postal.isValidPostalCodeObject()){
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.isPrivate = isPrivate;
        this.value = (block.getBlockNumberValue() + ", " +
                street.getStreetValue() + ", " +
                unit.getUnitValue() + ", " +
                postal.getPostalCodeValue()).trim();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    //Getter methods for those four objects
    public Block getBlock() {
        return block;
    }

    public Street getStreet() {
        return street;
    }

    public Unit getUnit() {
        return unit;
    }

    public Postal getPostal() {
        return postal;
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
