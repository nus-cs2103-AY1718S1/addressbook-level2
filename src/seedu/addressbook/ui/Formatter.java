package seedu.addressbook.ui;

import java.util.List;

import static seedu.addressbook.common.Messages.MESSAGE_FEEDBACK_COMMAND_ECHO;
import static seedu.addressbook.common.Messages.MESSAGE_PROMPT_USER_INPUT;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_FEEDBACK_WELCOME_MESSAGE;
import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_FEEDBACK_COMMAND_RESULT;
import static seedu.addressbook.common.Messages.MESSAGE_FORMATTED_FEEDBACK;

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
    

    public static String getUserInputPrompt() {
        return String.format(MESSAGE_PROMPT_USER_INPUT, LINE_PREFIX);
    }
    
    public static String getUserCommandEcho(String userCommand) {
        return String.format(MESSAGE_FEEDBACK_COMMAND_ECHO, userCommand);
    }
    
    public static String getWelcomeMessage(String version, String storageFilePath) {
        return String.format(MESSAGE_FEEDBACK_WELCOME_MESSAGE,
                DIVIDER,
                version,
                String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath));
    }
    
    public static String getGoodbyeMessage() {
        return String.format(MESSAGE_GOODBYE, DIVIDER);
    }
    
    public static String getInitFailedMessage() {
        return String.format(MESSAGE_INIT_FAILED, DIVIDER);
    }
    
    public static String getFormattedFeedbackMessage(String message) {
        return String.format(MESSAGE_FORMATTED_FEEDBACK, LINE_PREFIX, message.replace("\n", LS + LINE_PREFIX));
    }
    
    public static String getCommandResultMessage(String feedbackMessage) {
        return String.format(MESSAGE_FEEDBACK_COMMAND_RESULT, feedbackMessage, DIVIDER);
    }

    /** Returns a formatted list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Returns a formatted string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
    
}
