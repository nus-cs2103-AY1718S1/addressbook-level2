package seedu.addressbook.ui;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
        
    public Formatter() {}

    public static String printPrefix() { return LINE_PREFIX; }
    
    public static String printDivider() { return DIVIDER; }
    
    public static String printLs() { return LS; }
    
    public static String getIndexList() { return MESSAGE_INDEXED_LIST_ITEM; }
}
