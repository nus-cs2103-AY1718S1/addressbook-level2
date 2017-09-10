package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static seedu.addressbook.common.Messages.*;

public class Formatter {

    /**
     * A decorative prefix added to the beginning of lines printed by AddressBook
     */
    private static final String LINE_PREFIX = "|| ";

    /**
     * A platform independent line separator.
     */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /**
     * Format of indexed list item
     */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /**
     * Offset required to convert between 1-indexing and 0-indexing.
     */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /**
     * Format of a comment input line. Comment lines are silently consumed when reading user input.
     */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    public static boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }


    public static String getEnterCommandString(){
        return LINE_PREFIX + "Enter command: ";
    }

    public static String getCommandEnteredString(String fullInputLine){
        return "[Command entered:" + fullInputLine + "]";
    }

    public static String[] getWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return new String[]{DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER};
    }

    public static String[] getGoodbyeMessage() {
        return new String[]{MESSAGE_GOODBYE, DIVIDER, DIVIDER};
    }

    public static String[] getInitFailedMessage() {
        return new String[]{MESSAGE_INIT_FAILED, DIVIDER, DIVIDER};
    }

    public static String formatForUser(String message) {
        return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }

    /**
     * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    public static String[] formatResultForUser(CommandResult result) {
        final Optional<List<? extends ReadOnlyPerson>> resultPersons = result.getRelevantPersons();
        if (resultPersons.isPresent()) {
            TextUi.showToUser(formatPersonListView(resultPersons.get()).toArray(new String[0]));
        }
        return new String[]{result.feedbackToUser, DIVIDER};
    }

    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    private static List<String> formatPersonListView(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return formatForUserAsIndexedList(formattedPersons);
    }

    /**
     * Shows a list of strings to the user, formatted as an indexed list.
     */
    private static List<String> formatForUserAsIndexedList(List<String> list) {

        return new ArrayList<>(Arrays.asList(getIndexedListForViewing(list)));
    }

    /**
     * Formats a list of strings as a viewable indexed list.
     */
    private static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
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


}
