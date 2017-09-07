package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String[])}
 */
public class Address extends Contacts implements Printable{

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the following format: " +
            "a/BLOCK, STREET, UNIT, POSTAL_CODE.\n\tBLOCK: " + Block.MESSAGE_ADDRESS_BLOCK_CONSTRAINTS + "\n\tSTREET: "
            + Street.MESSAGE_ADDRESS_STREET_CONSTRAINTS + "\n\tUNIT: " + Unit.MESSAGE_ADDRESS_UNIT_CONSTRAINTS
            + "\n\tPOSTAL_CODE: " + Postal.MESSAGE_ADDRESS_POSTAL_CONSTRAINTS;
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final int ADDRESS_BLOCK_INDEX = 0;
    public static final int ADDRESS_STREET_INDEX = 1;
    public static final int ADDRESS_UNIT_INDEX = 2;
    public static final int ADDRESS_POSTAL_CODE_INDEX = 3;
    public final Block block;
    public final Street street;
    public final Unit unit;
    public final Postal postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        super(validateAndReturnAddress(address), isPrivate);
        String trimmedAddress = address.trim();
        String[] splitAddress = trimmedAddress.split(",");
        if (!isValidAddress(splitAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.block = new Block(splitAddress[ADDRESS_BLOCK_INDEX].trim());
        this.street = new Street(splitAddress[ADDRESS_STREET_INDEX].trim());
        this.unit = new Unit(splitAddress[ADDRESS_UNIT_INDEX].trim());
        this.postalCode = new Postal(splitAddress[ADDRESS_POSTAL_CODE_INDEX].trim());
    }

    /**
     * Validates and returns the address as a String.
     *
     * @param address the address to be validated
     * @return a String of the validated address
     * @throws IllegalValueException if the address is not valid
     */
    private static String validateAndReturnAddress(String address) throws IllegalValueException{
        String trimmedAddress = address.trim();
        String[] splitAddress = trimmedAddress.split(",");
        if (!isValidAddress(splitAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        return splitAddress[ADDRESS_BLOCK_INDEX].trim() + ", " + splitAddress[ADDRESS_STREET_INDEX].trim()
                + ", " + splitAddress[ADDRESS_UNIT_INDEX].trim() + ", " + splitAddress[ADDRESS_POSTAL_CODE_INDEX].trim();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String[] splitAddress) {
        return splitAddress.length == 4
                && Block.isValidAddressBlock(splitAddress[ADDRESS_BLOCK_INDEX].trim())
                && Street.isValidAddressStreet(splitAddress[ADDRESS_STREET_INDEX].trim())
                && Unit.isValidAddressUnit(splitAddress[ADDRESS_UNIT_INDEX].trim())
                && Postal.isValidAddressPostal(splitAddress[ADDRESS_POSTAL_CODE_INDEX].trim());
    }

    @Override
    public String getPrintableString(){
        if(isPrivate){
            return "(private) Address: " + value;
        }else{
            return "Address: " + value;
        }
    }
}
