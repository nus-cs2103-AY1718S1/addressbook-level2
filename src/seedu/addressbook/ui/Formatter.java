package seedu.addressbook.ui;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static seedu.addressbook.common.Messages.*;

/**
 * Formats text before it is displayed by TextUi
 */
public class Formatter {

    private static final String DIVIDER = "===================================================";
    
    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    public static String formatInputPrompt(String promptMessage) {
        return promptMessage;
    }
    
    public static String formatCommandEntered(String inputLine) {
        return "[Command entered:" + inputLine + "]";
    }
    
    public static ArrayList<String> formatWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        ArrayList<String> linesToDisplay = new ArrayList<>(Arrays.asList(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER));
        return linesToDisplay;
    }
    
    public static ArrayList<String> formatGoodbyeMessage() {
        return formatMessageWithDividers(MESSAGE_GOODBYE, 0, 2);
    }

    public static ArrayList<String> formatInitFailedMessage() {
        return formatMessageWithDividers(MESSAGE_INIT_FAILED, 0, 2);
    }

    public static ArrayList<String> formatMessageWithDividers(String message, int num_dividers_before, 
                                                               int num_dividers_after) {
        ArrayList<String> linesToDisplay = new ArrayList<>();
        for (int i = 0; i < num_dividers_before; i++) {
            linesToDisplay.add(DIVIDER);
        }
        linesToDisplay.add(message);
        for (int i = 0; i < num_dividers_after; i++) {
            linesToDisplay.add(DIVIDER);
        }
        return linesToDisplay;
    }
    
    public static List<String> formatPersonListView(List<? extends ReadOnlyPerson> persons){
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return formattedPersons;
    }

    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
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
    public static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
