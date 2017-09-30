package seedu.addressbook.ui;

import java.util.List;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

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

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    public String formatLinePrefix(String string){
        return LINE_PREFIX + string;
    }

    public String formatEchoCommandEntered(String commandEntered) {
        return "[Command entered:" + commandEntered + "]";
    }

    public String[] formatWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = formatUsingStorageFileMessage(storageFilePath);
        return new String[]{DIVIDER, DIVIDER, MESSAGE_WELCOME, version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo, DIVIDER};
    }

    public String formatUsingStorageFileMessage(String storageFilePath){
        return String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    }

    public String[] formatGoodbyeMessage() {
        return new String[] {MESSAGE_GOODBYE, DIVIDER, DIVIDER};
    }

    public String[] formatFailedMessage() {
        return new String[] {MESSAGE_INIT_FAILED, DIVIDER, DIVIDER};
    }

    public String formatMessageLine(String message) {
        return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }

    public String[] formatFeedbackToUser(String feedbackToUser) {
        return new String[] {feedbackToUser, DIVIDER};
    }

    /** Formats a list of strings as a viewable indexed list. */
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
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
