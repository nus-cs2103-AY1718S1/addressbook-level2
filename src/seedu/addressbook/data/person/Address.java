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

   // public final String value;
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
        //this.value = trimmedAddress;
        /**
         * Creates a new block,street,unit and postal code object.
         */
        if(trimmedAddress.contains(",")) {
            String[] split = trimmedAddress.split(",", 4);
            this.block = new Block(split[0]);
            this.street = new Street(split[1]);
            this.unit = new Unit(split[2]);
            this.postalCode = new PostalCode(split[3]);
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

        return block.getBlock()+","+street.getStreet()+","+unit.getUnit()+","+postalCode.getPostalcode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}



