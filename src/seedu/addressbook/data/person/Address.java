package seedu.addressbook.data.person;

import com.sun.prism.shader.DrawCircle_ImagePattern_AlphaTest_Loader;
import seedu.addressbook.data.exception.IllegalValueException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_DIAMOND_VALIDATION_REGEX = "(?<block>[\\w\\s]+),(?<street>[\\w\\s]+)," +
            "(?<unit>[#\\-\\w\\s]+),(?<postalCode>[\\w\\s]+)";
    
    public final String value;
    private boolean isPrivate;
    private final Block block = new Block();
    //private final Street street = new Street();
    //private final Unit unit = new Unit();
    //private final Postalcode postalCode = new Postalcode();

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
        
        Pattern pattern = Pattern.compile(ADDRESS_DIAMOND_VALIDATION_REGEX);
        Matcher matcher = pattern.matcher(trimmedAddress);
        if (matcher.find()) {
            this.block.setBlockNumber(matcher.group("block");
            //Street street = new Street(matcher.group("street"), this.isPrivate);
        }
        
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_DIAMOND_VALIDATION_REGEX);
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

public class Block {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block can be in any format";
    public static final String BLOCK_VALIDATION_REGEX = "\\s";

    private String blockNumber;
    private boolean isPrivate;

    public Block(){
        this.isPrivate = false;
    }
    
    /**
     * Validates block number
     * @param blockNumber block part of address
     * @param isPrivate private if address is private
     * @throws IllegalValueException if given block number string is invalid.
     */
    public Block(String blockNumber, boolean isPrivate) {
        String trimmedBlockNumber = blockNumber.trim();
        this.isPrivate = isPrivate;
        this.blockNumber = trimmedBlockNumber;
    }

    /**
     * Sets the values of the members 
     * @param blockNumber
     * @param isPrivate
     */
    public void setValues(String blockNumber, boolean isPrivate) {
        this.blockNumber = blockNumber;
        this.isPrivate = isPrivate;
    }
    
    /**
     * Returns true if a given string is a valid block number.
     */
    public static void setBlockNumber(){
        
    }
    
}

class Street {
    private String streetName;
    private boolean isPrivate;
}

class Unit {
    private String unitNumber;
    private boolean isPrivate;
}

class Postalcode {
    private String postalcodeNumber;
    private boolean isPrivate;
}