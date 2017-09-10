package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a person's Street in his address.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
public class Block {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLCOK_CONSTRAINTS = "Block should only contain numbers";
    public static final String BLOCK_VALIDATION_REGEX = "\\d+";

    private final String value;

    public Block(String block) throws IllegalValueException {
        String trimmedBlock = block.trim();
        if (!isValidBlock(trimmedBlock))
            throw new IllegalValueException(MESSAGE_BLCOK_CONSTRAINTS);
        this.value = trimmedBlock;
    }

    private boolean isValidBlock(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof Block
                && this.value.equals(((Block) other).value));
    }

    /**
     * Returns the hash code of the Block
     *
     * @return hash code of the block
     */
    @Override
    public int hashCode() {
        // uses block number as hash code
        return Integer.parseInt(value);
    }
}
