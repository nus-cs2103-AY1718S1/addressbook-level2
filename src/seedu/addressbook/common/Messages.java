package seedu.addressbook.common;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_GOODBYE = "Good bye!";
    public static final String MESSAGE_INIT_FAILED = "Failed to initialise address book application. Exiting...";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_PERSON_NOT_IN_ADDRESSBOOK = "Person could not be found in address book";
    public static final String MESSAGE_NO_ONE_IN_STORAGE_FOR_DELETED = "Currently there is no one to be restored";
    public static final String MESSAGE_DUPLICATE_ENTRY_IN_STORAGE_FOR_DELETED = "Person is already in the storage for deleted";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE = "Launch command format: " +
            "java seedu.addressbook.Main [STORAGE_FILE_PATH]";
    public static final String MESSAGE_WELCOME = "Welcome to your Address Book!";
    public static final String MESSAGE_USING_STORAGE_FILE = "Using storage file : %1$s";
}
