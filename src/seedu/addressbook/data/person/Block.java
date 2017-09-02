package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 *  We split the person's address class into several subclass
 *  Including Block, Street, Unit, and Postal Code
 *  For Block, it is a integer represented by the block number that person's address at
 */
public class Block {
    private int blockNumber;
    private boolean valid;
    private String value;

    private static final String BLOCK_NUMBER_CONSTRAINTS = "Block number is an integer between 0 to 10000";

    /**
     * construct the block object and validate the block number passed in
     * @param inputNumber
     * @throws IllegalValueException
     */
    public Block ( int inputNumber ) throws IllegalValueException {
        blockNumber = inputNumber;
        valid = false;
        if (!isValidBlockNumber(blockNumber)){
            throw new IllegalValueException(BLOCK_NUMBER_CONSTRAINTS);
        }
        valid = true;
        value = Integer.toString(blockNumber);
    }

    /**
     * Second constructor to accept String input, which should be the correct constructor to use
     * In the address String passed in, we can have omitted values
     * And the input string by address position is a string by itself
     * @param inputString
     * @throws IllegalValueException
     */
    public Block ( String inputString ) throws IllegalValueException {
        if (!inputString.isEmpty()){
            blockNumber = Integer.parseInt(inputString.trim());
            valid = false;
            if (!isValidBlockNumber(blockNumber)){
                throw new IllegalValueException(BLOCK_NUMBER_CONSTRAINTS);
            }
            valid = true;
            value = inputString.trim();
        }
        else {
            // In this case, we don't raise any warnings or exceptions as we believe block input is omitted.
            valid = false;
            value = "";
        }
    }

    /**
     * getter to help retrieve the String version of the block number
     * This function can return empty String as the Block input can be omitted (but this object status is invalid)
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

    /**
     * To give the validity of this object, to retrieve the value of this object
     * @return the valid boolean signal
     */
    public boolean isValidBlockObject () {
        return valid;
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

