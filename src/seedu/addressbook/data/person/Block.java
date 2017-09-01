package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 *  We split the person's address class into several subclass
 *  Including Block, Street, Unit, and Postal Code
 *  For Block, it is a integer represented by the block number that person's address at
 */
public class Block {
    private int blockNumber;
    private String value;

    private static final String BLOCK_NUMBER_CONSTRAINTS = "Block number is an integer between 0 to 10000";

    /**
     * construct the block object and validate the block number passed in
     * @param inputNumber
     * @throws IllegalValueException
     */
    public Block ( int inputNumber ) throws IllegalValueException {
        blockNumber = inputNumber;
        if (!isValidBlockNumber(blockNumber)){
            throw new IllegalValueException(BLOCK_NUMBER_CONSTRAINTS);
        }
        value = Integer.toString(blockNumber);
    }

    /**
     * getter to help retrieve the String version of the block number
     * @return the string version of the block number
     */
    public String getBlockNumberValue () {
        return value;
    }

    /**
     * validation checker for the block number
     * @param blockNumber
     * @return true if the block number is in line with the constraints of 0 to 10000
     */
    public static boolean isValidBlockNumber ( int blockNumber ) {
        return ((blockNumber >= 0) && (blockNumber <= 10000));
    }

    @Override
    public String toString () {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block)other).getBlockNumberValue())); // state check
    }
}

