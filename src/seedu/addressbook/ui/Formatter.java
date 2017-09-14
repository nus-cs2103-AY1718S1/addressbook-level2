package seedu.addressbook.ui;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";
    
    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    public static String getLinePrefix() {
        return LINE_PREFIX;
    }
    public static String getDivider() {
        return DIVIDER;
    }
    
    /** A platform independent line separator. */
    public static String getLineSeparator() {
        return System.lineSeparator();
    }
    
    public static String getMessageIndexedListItem() {
        return MESSAGE_INDEXED_LIST_ITEM;
    }
    
    public static int getDisplayIndexOffset(){
        return DISPLAYED_INDEX_OFFSET;
    }
}
