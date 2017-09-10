package seedu.addressbook.data.exception;

/**
 * Signals an error caused when the storage data is read-only.
 */

public class ReadOnlyDataException extends IllegalValueException{
    public ReadOnlyDataException(String message) {
        super(message);
    }
}
