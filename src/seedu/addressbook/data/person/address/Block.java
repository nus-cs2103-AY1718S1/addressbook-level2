package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block must be a string that can be parsed as an integer";
    public static final String BLOCK_VALIDATION_REGEX = "(\\d+)";

    public final int value;

    /**
     * Validates given block.
     *
     * @throws IllegalValueException if given invalid block string
     */

    public Block(String block) throws IllegalValueException{
        if (!isValidBlock(block)) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
        this.value = Integer.parseInt(block);
    }

    private static boolean isValidBlock(String test) {
        return isValidFormat(test) && isParsable(test);
    }

    private static boolean isValidFormat(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
    }

    public static boolean isParsable(String test) {
        boolean canParse = true;
        try {
            Integer.parseInt(test);
        } catch(NumberFormatException e) {
            canParse = false;
        }
        return canParse;
    }

    @Override
    public String toString() { return Integer.toString(this.value); }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Block
                && this.value == ((Block) other).value);
    }

    @Override
    public int hashCode() { return this.value; }

}
