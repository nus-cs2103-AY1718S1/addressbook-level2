package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static seedu.addressbook.common.Messages.*;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;

/**
 * Formats the text to be passed into TextUI
 */
class Formatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    private static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    static final String COMMENT_LINE_FORMAT_REGEX = "#.*";


    List<String> formatMessagesToList(String... message) {
        List<String> formattedMessages = new ArrayList<>();
        formattedMessages.addAll(Arrays.asList(message));
        return formattedMessages;
    }

    List<String> formatWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return formatMessagesToList(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
    }

    List<String> formatGoodbyeMessage() {
        return formatMessagesToList(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }


    List<String> formatInitFailedMessage() {
        return formatMessagesToList(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    /**
     * Formats the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    List<String> formatCommandResult(CommandResult result) {
        final Optional<List<? extends ReadOnlyPerson>> resultPersons = result.getRelevantPersons();
        resultPersons.ifPresent(this::formatPersonListView);
        return formatMessagesToList(result.feedbackToUser, DIVIDER);
    }


    /**
     * Formats a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    List<String> formatPersonListView(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return formattedPersons;
    }

    /** Formats a list of strings as a viewable indexed list. */
    List<String> getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatMessagesToList(formatted.toString());
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
