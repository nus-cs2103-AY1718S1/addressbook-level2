package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents an Address's block.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
public class Block {

    public static final String EXAMPLE = "123";
    private static final String MESSAGE_BLOCK_CONSTRAINTS =
            "Address's block should begin with a number";
    private static final String BLOCK_VALIDATION_REGEX = "[0-9]+[^,]*";

    private final String block;

    /**
     * Validates given block.
     *
     * @throws IllegalValueException if given block string is invalid.
     */
    public Block(String block) throws IllegalValueException {
        String trimmedBlock = block.trim();
        if (!isValidBlock(trimmedBlock)) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }

        this.block = trimmedBlock;
    }

    /**
     * Returns true if a given string is a valid block.
     */
    private static boolean isValidBlock(String test) {
        return test.matches(Block.BLOCK_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.block.equals(((Block) other).block)); // state check
    }

    @Override
    public int hashCode() {
        return block.hashCode();
    }
}
