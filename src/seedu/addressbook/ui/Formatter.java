package seedu.addressbook.ui;

import java.util.List;

public class Formatter {

    public Formatter(){};

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    public String requestEnterCommand(){return LINE_PREFIX + "Enter command: ";}

    public String getCommentLineFormatRegex(){return COMMENT_LINE_FORMAT_REGEX;}

    public String getLinePrefix(){return LINE_PREFIX;}

    public String commandEntered(String input){ return "[Command entered:" + input + "]";}

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public String getIndexedListItem(int visibleIndex, String listItem){
        return String.format(MESSAGE_INDEXED_LIST_ITEM,visibleIndex,listItem);
    }

    /** Formats a list of strings as a viewable indexed list. */
    public String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(this.getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();

    }
}
