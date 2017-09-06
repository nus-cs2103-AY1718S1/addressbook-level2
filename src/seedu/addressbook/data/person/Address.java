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
    public static final String ADDRESS_COMMA = ", ";

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final Postal postal;
    private boolean isPrivate;

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
        } else {
            String[] components = trimmedAddress.split(",");
            block = new Block(components[0].trim());

            if(components.length > 1){
                street = new Street(components[1].trim());
            } else {
                street = new Street("");
            }

            if(components.length > 2){
                unit = new Unit(components[2].trim());
            } else {
                unit = new Unit("");
            }

            if(components.length > 3){
                postal = new Postal(components[3].trim());
            } else {
                postal = new Postal("");
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
        return getAddress();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getAddress().equals(((Address) other).getAddress())); // state check
    }

    @Override
    public int hashCode() {
        return getAddress().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * Returns the address as a String.
     */
    public String getAddress() {
        return (block + (street.toString() != "" ? ADDRESS_COMMA + street : "")
                        + (unit.toString() != "" ? ADDRESS_COMMA + unit : "")
                        + (postal.toString() != "" ? ADDRESS_COMMA + postal : "")).trim();
    }

    /**
     * ================================================================================================================
     * Sub-address classes
     * ================================================================================================================
     */

    class Block{
        private String block;
        
        public Block(String block){
            this.block = block;
        }

        @Override
        public String toString(){
            return block;
        }
    }

    class Street{
        private String street;

        public Street(String street){
            this.street = street;
        }

        @Override
        public String toString(){
            return street;
        }
    }

    class Unit{
        private String unit;

        public Unit(String unit){
            this.unit = unit;
        }

        @Override
        public String toString(){
            return unit;
        }
    }

    class Postal{
        private String postal;

        public Postal(String postal){
            this.postal = postal;
        }

        @Override
        public String toString(){
            return postal;
        }
    }
}
