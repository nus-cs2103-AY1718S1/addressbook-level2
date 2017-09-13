package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;

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

	/**
	 * @return formatted request command message
	 */
	static String getRequestCommandMessage() {
		return LINE_PREFIX + "Enter command: ";
	}

	/**
	 * @return formatted details of command entered by user
	 */
	static String getCommandEntered(String command) {
		return "[Command entered:" + command + "]";
	}

	/**
	 * @return formatted welcome message
	 */
	static String getWelcomeMessage(String version, String storageFilePath) {
		String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
		return consolidateMessagesIntoString(new String[]{DIVIDER, DIVIDER, MESSAGE_WELCOME, version,
				MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo, DIVIDER});
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
	static String getGoodbyeMessage() {
		return consolidateMessagesIntoString(new String[]{MESSAGE_GOODBYE, DIVIDER, DIVIDER});
	}

	/**
	 * @return Formatted initilization failed message
	 */
	static String getInitFailedMessage() {
		return consolidateMessagesIntoString(new String[]{MESSAGE_INIT_FAILED, DIVIDER, DIVIDER});
	}

	/**
	 * Formats a string as a viewable indexed list item.
	 *
	 * @param visibleIndex visible index for this listing
	 */
	static String getIndexedListItem(int visibleIndex, String listItem) {
		return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
	}

	static String getFeedbackMessage(CommandResult result) {
		String[] feedbackMessages = new String[]{result.feedbackToUser, DIVIDER};
		return consolidateMessagesIntoString(feedbackMessages);
	}

	/**
	 * Consolidate messages into a string, with each String element being formatted as a line
	 *
	 * @return consolidated message from messages
 	 */
	private static String consolidateMessagesIntoString(String... messages) {
		String consolidatedMessage = "";
		for(String message : messages) {
			consolidatedMessage += message;

			if(!message.equals(messages[messages.length - 1])) {
				consolidatedMessage += "\n";
			}
		}

		return consolidatedMessage;
	}
}
