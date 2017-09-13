package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

public class Formatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    public static final String MESSAGE_REQUEST_USER_COMMAND = LINE_PREFIX + "Enter Command:";

    public String welcomeMessage(String version, String storageFileInfo) {
        return DIVIDER + LS +
                DIVIDER + LS +
                MESSAGE_WELCOME + LS +
                version + LS +
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE + LS +
                storageFileInfo + LS +
                DIVIDER;
    }

    public String formatSystemMessage(String systemMessage) {
        return systemMessage + LS + DIVIDER + LS + DIVIDER;
    }

    public String formatLineToBePrinted(String lineToBePrinted) {
        return LINE_PREFIX + lineToBePrinted.replace("\n", LS + LINE_PREFIX);
    }

    public String formatFeedback(String feedback) {
        return feedback + LS + DIVIDER;
    }

    public String formatEchoInput(String userCommand) {
        return "[Command entered:" + userCommand + "]";
    }

}
