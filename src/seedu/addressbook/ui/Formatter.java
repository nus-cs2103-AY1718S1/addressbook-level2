package seedu.addressbook.ui;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static seedu.addressbook.common.Messages.*;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;

/**
 * Formatter for TextUi (to pretty print information on command line)
 *
 * @author Niu Yunpeng
 */
public class Formatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    /** A divider for separating the outputs. */
    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    private final PrintStream out;

    /**
     * Uses the system standard out by default.
     */
    public Formatter() {
        this.out = System.out;
    }

    /**
     * Decides the output PrintStream to use when doing the text formatting.
     *
     * @param out is the specified output stream.
     */
    public Formatter(PrintStream out) {
        this.out = out;
    }

    /**
     * Prompts the user to enter the next command.
     */
    public void promptForEnterCommand() {
        out.print(LINE_PREFIX + "Enter command: ");
    }

    /**
     * Reflects to the user about the command that has just been entered.
     *
     * @param command is the command just entered.
     */
    public void reflectEnterCommand(String command) {
        showToUser("[Command entered:" + command + "]");
    }

    public void showWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        showToUser(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
    }

    public void showGoodbyeMessage() {
        showToUser(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }

    public void showInitFailedMessage() {
        showToUser(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    /**
     * Shows result of the command to the user, if the result is simply a string.
     */
    public void showFormattedResult(String result) {
        showToUser(result, DIVIDER);
    }

    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    public void showFormatterResult(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        showToUserAsIndexedList(formattedPersons);
    }

    /** Shows a list of strings to the user, formatted as an indexed list. */
    private void showToUserAsIndexedList(List<String> list) {
        showToUser(getIndexedListForViewing(list));
    }

    /** Formats a list of strings as a viewable indexed list. */
    private static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = DISPLAYED_INDEX_OFFSET;

        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

    /**
     * Shows message(s) to the user.
     *
     * @param message is the message(s) that needs to be shown to the user.
     */
    public void showToUser(String... message) {
        for (String m : message) {
            out.println(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
        }
    }
}
