package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the block number of an address.
 */
public class Block {
    public static final String EXAMPLE = "123";
    private String value;

    public Block(String blockNumber) throws IllegalValueException {
        String trimmedBlockNumber = blockNumber.trim();
        this.value = trimmedBlockNumber;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
}
