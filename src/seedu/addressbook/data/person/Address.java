package seedu.addressbook.data.person;

import com.sun.prism.shader.DrawCircle_ImagePattern_AlphaTest_Loader;
import seedu.addressbook.data.exception.IllegalValueException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in format: " +
                                                             "a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_DIAMOND_VALIDATION_REGEX = "(?<block>[\\w\\s]+),(?<street>[\\w\\s]+)," +
            "(?<unit>[#\\-\\w\\s]+),(?<postalCode>[\\w\\s]+)";
    public static final String ADDRESS_PART_SEPERATOR = ", ";
    
    
    public final String value;
    private boolean isPrivate;
    private final Block block = new Block();
    private final Street street = new Street();
    private final Unit unit = new Unit();
    private final Postalcode postalCode = new Postalcode();

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        super(address, isPrivate);
        this.isPrivate = isPrivate;
        
        if (!isValidAddress(super.value)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        } 
        
        Pattern pattern = Pattern.compile(ADDRESS_DIAMOND_VALIDATION_REGEX);
        Matcher matcher = pattern.matcher(super.value);
        if (matcher.find()) {
            this.block.setValues(matcher.group("block"), isPrivate);
            this.street.setValues(matcher.group("street"), isPrivate);
            this.unit.setValues(matcher.group("unit"), isPrivate);
            this.postalCode.setValues(matcher.group("postalCode"), isPrivate); 
        }
        
        this.value = super.value;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_DIAMOND_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
        String addressString = this.block.getBlockNumber() + ADDRESS_PART_SEPERATOR + this.street.getStreetName() + 
                ADDRESS_PART_SEPERATOR + this.unit.getUnitNumber() + ADDRESS_PART_SEPERATOR +
                this.postalCode.getPostalcodeNumber();
        return addressString;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    /**
     * Compares block addresses
     * @param other address object to compare with
     * @return true if blocks are same for two address
     */
    public boolean compareBlockNumbers(Object other) {
        String blockNumber = this.block.getBlockNumber();
        return (other instanceof Address // instanceof handles nulls
                && blockNumber.equals(((Address) other).block.getBlockNumber())); // state check
    }

    /**
     * Compares street addresses
     * @param other address object to compare with
     * @return true if streets are same for two address
     */
    public boolean compareStreetNames(Object other) {
        String streetName = this.street.getStreetName();
        return (other instanceof Address // instanceof handles nulls
                && streetName.equals(((Address) other).street.getStreetName())); // state check
    }

    /**
     * Compares unit addresses
     * @param other address object to compare with
     * @return true if units are same for two address
     */
    public boolean compareUnitNumbers(Object other) {
        String unitNumber = this.unit.getUnitNumber();
        return (other instanceof Address // instanceof handles nulls
                && unitNumber.equals(((Address) other).unit.getUnitNumber())); // state check
    }

    /**
     * Compares postal code of addresses
     * @param other address object to compare with
     * @return true if postal code numbers are same for two address 
     */
    public boolean comparePostalcodeNumbers(Object other) {
        String postalCodeNumber = this.postalCode.getPostalcodeNumber();
        return (other instanceof Address // instanceof handles nulls
                && postalCodeNumber.equals(((Address) other).postalCode.getPostalcodeNumber())); // state checks
    }
}

class Block {

    private String blockNumber;
    private boolean isPrivate;

    /**
     * Initializes block if no arguments given
     */
    public Block(){
        this.isPrivate = false;
    }
    
    /**
     * Initializes block if arguments given
     * @param blockNumber block part of address
     * @param isPrivate true if address is private
     */
    public Block(String blockNumber, boolean isPrivate) {
        String trimmedBlockNumber = blockNumber.trim();
        this.isPrivate = isPrivate;
        this.blockNumber = trimmedBlockNumber;
    }

    /**
     * Sets the values of the member variables
     * @param blockNumber string value of block part of the address
     * @param isPrivate boolean that tells whether street address is private
     */
    public void setValues(String blockNumber, boolean isPrivate) {
        String trimmedBlockNumber = blockNumber.trim();
        this.blockNumber = trimmedBlockNumber;
        this.isPrivate = isPrivate;
    }

    /**
     * Returns the block address to the user
     * @return block address as a String
     */
    public String getBlockNumber() {
        return this.blockNumber;
    }

    /**
     *  Returns the privacy of the block address
     * @return true when block address is private
     */
    public boolean isPrivate() {
        return this.isPrivate;
    }
}

class Street {
    private String streetName;
    private boolean isPrivate;

    /**
     * Initializes block if no arguments given
     */
    public Street(){
        this.isPrivate = true;
    }

    /**
     * Initializes street if arguments given
     * @param streetName street part of address
     * @param isPrivate true if street address is private
     */
    public Street(String streetName, boolean isPrivate) {
        String trimmedStreetName = streetName.trim();
        this.isPrivate = isPrivate;
        this.streetName = trimmedStreetName;
    }

    /**
     * Sets the values of the member variables
     * @param streetName String value of the street
     * @param isPrivate boolean, true if street is private
     */
    public void setValues(String streetName, boolean isPrivate) {
        String trimmedStreetName = streetName.trim();
        this.streetName= trimmedStreetName;
        this.isPrivate = isPrivate;
    }

    /**
     * Returns the street address to the user
     * @return street address as a String
     */
    public String getStreetName() {
        return this.streetName;
    }

    /**
     *  Returns the privacy of the street address
     * @return true when street address is private
     */
    public boolean isPrivate() {
        return this.isPrivate;
    }
}

class Unit {
    private String unitNumber;
    private boolean isPrivate;

    /**
     * Initializes Unit if no arguments given
     */
    public Unit(){
        this.isPrivate = true;
    }

    /**
     * Initializes Unit if arguments given
     * @param unitNumber unit part of address
     * @param isPrivate true if unit address is private
     */
    public Unit(String unitNumber, boolean isPrivate) {
        String trimmedUnitNumber = unitNumber.trim();
        this.isPrivate = isPrivate;
        this.unitNumber = trimmedUnitNumber;
    }

    /**
     * Sets the values of the members 
     * @param unitNumber String value of the unit
     * @param isPrivate boolean, true if unit is private
     */
    public void setValues(String unitNumber, boolean isPrivate) {
        String trimmedUnitNumber = unitNumber.trim();
        this.unitNumber= trimmedUnitNumber;
        this.isPrivate = isPrivate;
    }

    /**
     * Returns the unit address to the user
     * @return unit address as a String
     */
    public String getUnitNumber() {
        return this.unitNumber;
    }

    /**
     *  Returns the privacy of the unit address
     * @return true when unit address is private
     */
    public boolean isPrivate() {
        return this.isPrivate;
    }
}

class Postalcode {
    private String postalcodeNumber;
    private boolean isPrivate;

    /**
     * Initializes Postalcode if no arguments given
     */
    public Postalcode(){
        this.isPrivate = true;
    }

    /**
     * Initializes class if arguments are given
     * @param postalcodeNumber postal code part of address
     * @param isPrivate true if postal code is private
     */
    public Postalcode(String postalcodeNumber, boolean isPrivate) {
        String trimmedPostalCodeNumber = postalcodeNumber.trim();
        this.isPrivate = isPrivate;
        this.postalcodeNumber = trimmedPostalCodeNumber;
    }

    /**
     * Sets the values of the members 
     * @param postalcodeNumber String value of the postal code
     * @param isPrivate true if postal Code is private
     */
    public void setValues(String postalcodeNumber, boolean isPrivate) {
        String trimmedPostalCodeNumber = postalcodeNumber.trim();
        this.postalcodeNumber = trimmedPostalCodeNumber;
        this.isPrivate = isPrivate;
    }

    /**
     * Returns the postalcode number to the user
     * @return postal code number as a String
     */
    public String getPostalcodeNumber() {
        return this.postalcodeNumber;
    }

    /**
     *  Returns the privacy of the postal code number
     * @return true when postal code is private
     */
    public boolean isPrivate() {
        return this.isPrivate;
    }
}