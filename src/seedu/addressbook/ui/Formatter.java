package seedu.addressbook.ui;

import java.util.List;

import static seedu.addressbook.common.Messages.*;

/**
 * Formats output
 */
public class Formatter {

    private static final String DIVIDER = "===================================================";

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /**
     *  Base string formatter
     */
    public static String basicFormat(String... message) {
        String formatted = new String();
        for (String m : message) {
            formatted = formatted.concat(LINE_PREFIX
                    + m.replace("\n", LINE_SEPARATOR + LINE_PREFIX));
            formatted = formatted.concat(LINE_SEPARATOR);
        }
        formatted = formatted.substring(0, formatted.length() - LINE_SEPARATOR.length());
        return formatted;
    }

    public static String getUserCommandPromptFormatted() {
        return LINE_PREFIX + "Enter command: ";
    }

    public static String getUserCommandResponseFormatted(String fullInputLine) {
        return LINE_PREFIX + "[Command entered:" + fullInputLine + "]";
    }

    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return basicFormat(formatted.toString());
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

    /**
     *  Formats the welcome string
     * @param version
     * @param storageFileInfo
     * @return formatted welcome string
     */
    public static String getWelcomeFormatted(String version, String storageFileInfo) {
        return basicFormat(DIVIDER, DIVIDER, MESSAGE_WELCOME, version, MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo, DIVIDER);
    }

    /**
     * Gets the standard goodbye string
     * @return formatted goodbye string
     */
    public static String getGoodbyeFormatted() {
        return basicFormat(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }

    /**
     * Gets the standard init failed string
     * @return formatted init failed string
     */
    public static String getInitFailedFormatted() {
        return basicFormat(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    /**
     * Formats the command result string
     * @param feedbackToUser
     * @return formatted result string
     */
    public static String getResultFormatted(String feedbackToUser) {
        return basicFormat(feedbackToUser, DIVIDER);
    }
}
