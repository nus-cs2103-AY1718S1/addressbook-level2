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

    private boolean isPrivate;

    private Block block;
    private Street street;
    private Unit unit;
    private Postal postal;

    /**
     *
     * inner classes
     */

    class Block {
        String blockNum;
        public Block (String block){
            blockNum = block;
        }

        public String getBlock(){
            return blockNum;
        }
    }

    class Street {
        String StreetName;
        public Street (String Street){
            StreetName = Street;
        }

        public String getStreet(){
            return StreetName;
        }
    }

    class Unit {
        String unitNum;
        public Unit (String unit){
            unitNum = unit;
        }

        public String getUnit(){
            return unitNum;
        }
    }

    class Postal {
        String PostalCode;
        public Postal (String postal){
            PostalCode = postal;
        }

        public String getPostal(){
            return PostalCode;
        }
    }

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

        String [] AddressParts = trimmedAddress.split(", ");

        int NumParts = AddressParts.length;

        if(NumParts > 0){
            block = new Block(AddressParts[0]);
        }
        else block =  new Block("");

        if(NumParts > 1){
            street = new Street(AddressParts[1]);
        }
        else street = new Street("");

        if(NumParts > 2){
            unit = new Unit(AddressParts[2]);
        }
        else unit = new Unit("");

        if(NumParts > 3){
            postal = new Postal(AddressParts[3]);
        }
        else postal = new Postal("");
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        String Addr = "";
        if (!block.getBlock().equals(""))
            Addr += block.getBlock();
        if (!street.getStreet().equals(""))
            Addr += ", " + street.getStreet();
        if (!unit.getUnit().equals(""))
            Addr += ", " + unit.getUnit();
        if (!postal.getPostal().equals(""))
            Addr += ", " + postal.getPostal();

        return Addr;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
