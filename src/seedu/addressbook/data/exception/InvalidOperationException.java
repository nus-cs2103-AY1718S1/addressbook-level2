package seedu.addressbook.data.exception;

public class InvalidOperationException extends IllegalValueException {
    public InvalidOperationException(String message) {
        super(message);
    }
}
