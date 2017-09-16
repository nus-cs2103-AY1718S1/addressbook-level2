package seedu.addressbook.data.exception;

/**
 * Signals that some given data does not fulfill some constraints.
 */
public class WrongSequenceException extends Exception {
    /**
     * @param message should contain relevant information on the failed constraint(s)
     */
    public WrongSequenceException(String message) {
        super(message);
    }
}
