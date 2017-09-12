package seedu.addressbook.parser;

public class Formatter {
    private static final String DIVIDER = "===================================================";

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    public static String addDivider(){
        return DIVIDER;
    }

    public static String addLinePrefix(){
        return LINE_PREFIX;
    }
}
