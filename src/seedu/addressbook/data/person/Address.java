package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import java.lang.Integer;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String OOP_MESSAGE_ADDRESS_CONSTRAINTS = "Required Format: <block>,<street>,<unit>,<postal code>";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String OOP_ADDRESS_VALIDATION_REGEX = "(.*),(.*),(.*),(.*)";

    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     * Address has to be input in the following format: block, street, unit, postal code
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(OOP_MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] inputAddressArr = splitAddressInputToArr(trimmedAddress);
        initializeAddressItems(inputAddressArr);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(OOP_ADDRESS_VALIDATION_REGEX);
    }

    private String[] splitAddressInputToArr(String inputAddress) {
        String[] tempArr = inputAddress.split(",");
        for(int i = 0; i < tempArr.length; i++){
            tempArr[i] = tempArr[i].trim();
        }
        return tempArr;
    }

    private void initializeAddressItems(String[] inputArr) {
        block = new Block(inputArr[0]);
        street = new Street(inputArr[1]);
        unit = new Unit(inputArr[2]);
        postalCode = new PostalCode(Integer.parseInt(inputArr[3]));
    }

    @Override
    public String toString() {
        return block.getValue() + ", " + street.getValue() + ", " + unit.getValue() + ", " + postalCode.getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.hasSameProperties((Address)other)); // state check
    }

    private boolean hasSameProperties(Address inputAddress) {
        return inputAddress.getBlock().getValue() == block.getValue()
            && inputAddress.getStreet().getValue() == street.getValue()
            && inputAddress.getUnit().getValue() == unit.getValue()
            &&inputAddress.getPostalCode().getValue() == postalCode.getValue();
    }

    public Block getBlock() {
        return block;
    }
    public void setBlock(Block inputBlock) {
        block = inputBlock;
    }

    public Street getStreet() {
        return street;
    }
    public void setStreet(Block inputStreet) {
        block = inputStreet;
    }

    public Unit getUnit() {
        return unit;
    }
    public void setUnit(Block inputUnit) {
        block = inputUnit;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(Block inputPostalCode) {
        block = inputPostalCode;
    }

    public Address getAddress(){
        return this;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
