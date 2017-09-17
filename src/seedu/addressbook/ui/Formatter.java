package seedu.addressbook.ui;

/**
 * Text UI of the application that is responsible for the formatting of the UI.
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    static final String LS = System.lineSeparator();

    static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

}
