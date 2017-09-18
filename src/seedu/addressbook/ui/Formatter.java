package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

/**
 * Decoration to ui
 */

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    private static final String MESSAGE_FEEDBACK_WELCOME_MESSAGE = DIVIDER + "\n" + DIVIDER
                         + "\n" + MESSAGE_WELCOME
                         + "\n" + "%1$s"
                         + "\n" + MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE
                         + "\n" + "%2$s"
                         + "\n" + DIVIDER;

    private static String NEW_GOODBY_MESSAGE = MESSAGE_GOODBYE + "\n" + DIVIDER + "\n" + DIVIDER;

    /**
     * Constructor used to create a Formatter instance
     */
    public Formatter () { }

    public String getLinePrefix() {
        return LINE_PREFIX;
    }

    public String getDivider() {
        return DIVIDER;
    }

    public String getMessageIndexedListItem () {
        return MESSAGE_INDEXED_LIST_ITEM;
    }

    public String getCommentLineFormatRegex() {
        return COMMENT_LINE_FORMAT_REGEX;
    }

    public String getWelcomeMessage(String version, String storageFilePath) {
        return (String.format(MESSAGE_FEEDBACK_WELCOME_MESSAGE, version,
                 String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath )));
    }

    public String getGoodbyMessage() {
        return NEW_GOODBY_MESSAGE;
    }

    public String getInitFailedMessage() {
        return String.format(MESSAGE_INIT_FAILED, String.format(DIVIDER, DIVIDER));
    }

}
