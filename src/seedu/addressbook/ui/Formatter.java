package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

/**
 * Text formatter utility class for text UI.
 */
public class Formatter {


    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    //TODO: Add maximum line cutter (truncate help text to next line e.g. help etc if values are too long)

    //===================================== Message Constants ===========================================
    private static final String MESSAGE_PROMPT_USER_INPUT = "Enter command: ";
    private static final String MESSAGE_FEEDBACK_COMMAND_ECHO = "[Command entered:%1$s]";
    private static final String MESSAGE_FEEDBACK_WELCOME_MESSAGE = DIVIDER + "\n" + DIVIDER
            + "\n" + MESSAGE_WELCOME
            + "\n" + "%1$s"
            + "\n" + MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE
            + "\n" + "%2$s"
            + "\n" + DIVIDER;

    public static String getUserInputPrompt() {
        return MESSAGE_PROMPT_USER_INPUT;
    }
    
    public static String getUserCommandEcho(String userCommand) {
        return String.format(MESSAGE_FEEDBACK_COMMAND_ECHO, userCommand);
    }
    
    public static String getWelcomeMessage(String version, String storageFilePath) {
        return String.format(MESSAGE_FEEDBACK_WELCOME_MESSAGE,
                version,
                String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath));
    }
}
