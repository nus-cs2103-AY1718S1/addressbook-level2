package seedu.addressbook.ui;


/**
 * Formatter, used to format the text of the application for display.
 */
public class Formatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    private final PrintStream out;
    
    public Formatter() {
        this(System.out);
    }
    
    public Formatter(PrintStream out) {
        this.out = out;
    }

    public void showWelcomeMessage(String welcomeMess, String version, String argsUsage, String storageFileInfo) {
        showToUser(
                DIVIDER,
                DIVIDER,
                welcomeMess,
                version,
                argsUsage,
                storageFileInfo,
                DIVIDER);
    }

    public void showGoodbyeMessage(String goodbyeMessage) {
        showToUser(goodbyeMessage, DIVIDER, DIVIDER);
    }


    public void showInitFailedMessage(String failMessage) {
        showToUser(failMessage, DIVIDER, DIVIDER);
    }

    /** Shows message(s) to the user */
    public void showToUser(String... message) {
        for (String m : message) {
            out.println(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
        }
    }

}
