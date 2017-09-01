package seedu.addressbook.data.person;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the Block part of a Person's address.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddressBlock(String)}
 */

public class Block {

    public static final String BLOCK_VALIDATION_REGEX = "\\p{Digit}+";
    public static final String MESSAGE_ADDRESS_BLOCK_CONSTRAINTS = "Address block must be a non-zero contiguous array of digits.";

    public final String value;

    /** Validates the given address block
     *
     * @param blockNumber block number of the address as given by user.
     * @throws IllegalValueException if the block number is invalid.
     */
    public Block(String blockNumber) throws IllegalValueException{
        if(!isValidAddressBlock(blockNumber)){
            throw new IllegalValueException(MESSAGE_ADDRESS_BLOCK_CONSTRAINTS);
        }
        this.value = blockNumber;
    }

    /** Returns true is the given block number is a valid block number.
     * A block number is valid is it is a non-zero contiguous array of digits.
     *
     */
    private static boolean isValidAddressBlock(String blockNumber){
        return blockNumber.matches(BLOCK_VALIDATION_REGEX);
    }

    @Override
    public String toString(){
        return value;
    }

    @Override
    public boolean equals(Object other){
        return this == other
                || (other instanceof Block
                && this.value.equals(((Block)other).value));
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }
}
