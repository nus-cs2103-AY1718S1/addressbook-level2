package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;

import static seedu.addressbook.common.Messages.*;

/**
 * formats outputs before passing it to TextUI to be output.
 */
public class Formatter {
	/** A decorative prefix added to the beginning of lines printed by AddressBook */
	private static final String LINE_PREFIX = "|| ";

	/** A platform independent line separator. */
	private static final String LS = System.lineSeparator();

	private static final String DIVIDER = "===================================================";

	/** Format of indexed list item */
	private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


	/** Offset required to convert between 1-indexing and 0-indexing.  */
	public static final int DISPLAYED_INDEX_OFFSET = 1;

	/** Format of a comment input line. Comment lines are silently consumed when reading user input. */
	private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

	static String getRequestCommandMessage() {
		return LINE_PREFIX + "Enter command: ";
	}

	static String getCommandEntered(String command) {
		return "[Command entered:" + command + "]";
	}

	static String[] getWelcomeMessages(String version, String storageFilePath) {
		String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
		return new String[]{DIVIDER, DIVIDER, MESSAGE_WELCOME, version, MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
				storageFileInfo, DIVIDER};
	}

	/**
	 * @return a formatted line of message
	 */
	static String getFormattedMessageLine(String m) {
		return LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX);
	}

	/**
	 * @return lines of messages for the goodbye message
	 */
	static String[] getGoodbyeMessages() {
		return new String[]{MESSAGE_GOODBYE, DIVIDER, DIVIDER};
	}

	/**
	 * @return Formatted initilization failed message
	 */
	static String[] getInitFailedMessages() {
		return new String[]{MESSAGE_INIT_FAILED, DIVIDER, DIVIDER};
	}

	/**
	 * Formats a string as a viewable indexed list item.
	 *
	 * @param visibleIndex visible index for this listing
	 */
	static String getIndexedListItem(int visibleIndex, String listItem) {
		return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
	}

	/**
	 * @return formatted result of command message.
	 */
	static String[] getCommandFeedbackMessages(CommandResult result) {
		return new String[]{result.feedbackToUser, DIVIDER};
	}

	/** Formats a list of strings as a viewable indexed list. */
	static String getIndexedListForViewing(List<String> listItems) {
		final StringBuilder formatted = new StringBuilder();
		int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
		for (String listItem : listItems) {
			formatted.append(Formatter.getIndexedListItem(displayIndex, listItem)).append("\n");
			displayIndex++;
		}

		return formatted.toString();
	}

	/**
	 * @return return formatted person list with private contact details hidden.
	 */
	static List<String> getFormattedPersons(List<? extends ReadOnlyPerson> persons) {
		final List<String> formattedPersons = new ArrayList<>();
		for (ReadOnlyPerson person : persons) {
			formattedPersons.add(person.getAsTextHidePrivate());
		}

		return formattedPersons;
	}
}
