package seedu.addressbook.ui;

/**
 * Formats output
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static String basicFormat(String message) {
        return (LINE_PREFIX + message.replace("\n", LINE_SEPARATOR + LINE_PREFIX));
    }

}
