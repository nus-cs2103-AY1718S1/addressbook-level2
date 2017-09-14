package seedu.addressbook.state.exception;

/**
 * Signals that the application state has failed to load accurately.
 */
public class LoadStateException extends Exception {
    /**
     * @param message should contain relevant information on the failed constraints
     */
    public LoadStateException(String message) {
        super(message);
    }
}
