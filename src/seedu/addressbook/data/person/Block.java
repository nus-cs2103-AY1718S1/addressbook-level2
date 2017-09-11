package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the block in a person's address.
 */
public class Block {
    private final String value;
    private static final String BLOCK_VALIDATION_REGEX = "^[a-zA-Z0-9]*$";
    private static final String MESSAGE_BLOCK_CONSTRAINTS = "Person address block must be in an "
                                                        + "alphanumeric format without special characters";

    /**
     * Block Constructor
     * 
     * @param block initial untrimmed string value
     * @throws IllegalValueException if block string is invalid
     */
    public Block(String block) throws IllegalValueException {
        if (!isValidBlock(block.trim())) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
        value = block.trim();
    }

    /**
     * Validates current block object.
     * 
     * @return true if this block is valid
     */
    public boolean isValidBlock() {
        return value.matches(BLOCK_VALIDATION_REGEX);
    }

    /**
     * Validates a given block string.
     * 
     * @param testBlockString block of the address
     * @return true if testBlockString is valid block value
     */
    public static boolean isValidBlock(String testBlockString) {
        return testBlockString.matches(BLOCK_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() { return value; }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && value.equals(((Block) other).value)); // state check
    }
}
