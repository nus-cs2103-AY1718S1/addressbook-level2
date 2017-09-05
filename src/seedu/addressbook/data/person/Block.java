package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block{
    public static final String EXAMPLE = "123456";
    public static final String MESSAGE_BLOCK_CONSTRAINTS =
            "BLOCK should only consist of 3 integers";
    public static final String BLOCK_VALIDATION_REGEX = "\\d+";

    public final String value;
    private boolean isPrivate;

    public Block(String blockNum, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedBlock = blockNum.trim();
        if (!isValidBlock(trimmedBlock)) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
        this.value = trimmedBlock;
    }

    public String getBlock(){
        return this.value;
    }
    /**
     * Returns true if the given string is a valid block number.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

