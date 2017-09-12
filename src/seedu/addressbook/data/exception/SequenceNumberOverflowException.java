package seedu.addressbook.data.exception;

/**
 * Signals that the number of entries that were added to address book has exceeded the max_int value.
 */
public class SequenceNumberOverflowException extends Exception {
    public SequenceNumberOverflowException(String message) {
        super(message);
    }
}
