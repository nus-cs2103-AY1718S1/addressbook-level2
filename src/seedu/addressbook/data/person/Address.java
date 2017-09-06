package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public final String value;
    private boolean isPrivate;
    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;

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
        String[] data = parseAddress(trimmedAddress);
        block = new Block(Integer.parseInt(data[0]));
        street = new Street(data[1]);
        unit = new Unit(data[2]);
        postalCode = new PostalCode(Integer.parseInt(data[3]));
        this.value = block.getValue() + "," +
                street.getValue() + "," +
                 unit.getValue() + "," +
                postalCode.getValue();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }
    private String[] parseAddress (String address) throws IllegalValueException {
        String[] result = new String[4];
        //check if there is 4 components
        int count = address.length() - address.replace(",", "").length();
        if (count != 3) {
            throw new IllegalValueException("Invalid Address format! Please follow " + MESSAGE_ADDRESS_CONSTRAINTS);
        }
        //extracting
        for (int i = 0; i <=3 ; i++) {
            if (i == 3) {
                result[i] = address.trim();
            } else {
                result[i] = address.substring(0, address.indexOf(",")).trim();
                address = address.substring(address.indexOf(",") + 1);
            }
        }
        return result;
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


//Implementation of sub-classes
class Block{
    private Integer _value;
    public Block(Integer value) {
        _value = value;
    }
    public String getValue(){
        return Integer.toString(_value);
    }
}

class Street{
    private String _value;
    public Street(String value){
        _value = value;
    }
    public String getValue(){
        return _value;
    }
}
class Unit{
    private String _value;
    public Unit(String value){
        _value = value;
    }
    public String getValue(){
        return _value;
    }
}
class PostalCode{
    private Integer _value;
    public PostalCode(Integer value){
        _value = value;
    }

    public String getValue(){
        return Integer.toString(_value);
    }
}