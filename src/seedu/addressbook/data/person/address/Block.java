package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block number should be in number integer format.";
    public static final String BLOCK_VALIDATION_REGEX = "\\d+";
    public final String value;

    /**
     * Validates given block Number.
     *
     * @throws IllegalValueException if given postal code string is invalid.
     */

    public Block(String blockNumber) throws IllegalValueException{

        if (!isValidBlock(blockNumber)) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }

        this.value = blockNumber;
    }

    /**
     * Returns true if a given string is a valid block number.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }

    public String getBlockNumber() {
        return this.value;
    }
}
