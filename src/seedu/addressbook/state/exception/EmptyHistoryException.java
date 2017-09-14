package seedu.addressbook.state.exception;

/**
 * Signals that a history stack is empty during a pop command.
 */
public class EmptyHistoryException extends Exception {
    /**
     * @param message should contain relevant information on the failed constraints
     */
    public EmptyHistoryException(String message) {
        super(message);
    }
}
