package seedu.addressbook.ui;

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
}
