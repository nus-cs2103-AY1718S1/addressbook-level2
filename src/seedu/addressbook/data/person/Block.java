package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block {
    public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block should only contain number";
    public static final String BLOCK_VALIDATION_REGEX = "\\d+";

    public final String value;

    public Block (String block) throws IllegalValueException {
        String trimmedBlock = block.trim();
        if(!isValidBlock(trimmedBlock)){
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
        this.value = trimmedBlock;
    }

    @Override
    public String toString() { return value; }

    public static boolean isValidBlock(String block) { return block.matches(BLOCK_VALIDATION_REGEX); }
}