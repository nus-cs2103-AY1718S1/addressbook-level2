package seedu.addressbook.ui;

import java.util.List;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    public static String showToUser(String... message) {
        StringBuilder s = new StringBuilder();
        for (String m : message) {
            s.append(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
        }
        return s.toString();
    }

    public static String showIndexedListToUser(List<String> listItems) {
        return null;
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
