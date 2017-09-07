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
    private String[] addressStringSplitUp;

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
        addressStringSplitUp = trimmedAddress.split(", ");
        Block block = new Block(addressStringSplitUp[0]);
        Street street = new Street(addressStringSplitUp[1]);
        Unit unit = new Unit(addressStringSplitUp[2]);
        PostalCode postalCode = new PostalCode(addressStringSplitUp[3]);
        //Test calling getBlock() from Block class.
        // System.out.println(block.getBlock());
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


class Block{
    String block;
    public Block(String block){

        this.block = block ;
    }
    public String getBlock(){
        return this.block;
    }

}

class Street{
    String street;
    public Street(String street){
        this.street = street;
    }
    public String getStreet(){
        return this.street;
    }
}

class Unit{
    String unit;
    public Unit(String unit){
        this.unit=unit ;
    }
    public String getStreet() {
        return this.unit;
    }
}

class PostalCode{
    String postalCode;
    public PostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    public String getPostalCode(){
        return this.postalCode;
    }

}