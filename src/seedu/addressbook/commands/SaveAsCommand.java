package seedu.addressbook.commands;

public class SaveAsCommand extends Command {
    public static final String COMMAND_WORD = "saveas";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Changes where the storage file is located. "
            + "The file name must end in .xml for it to be acceptable to the program"
            + "Parameters: NEW_PATH\n"
            + "Example: " + COMMAND_WORD + " addressbook_new.xml";

    public static final String MESSAGE_SUCCESS = "The path to the storage file has been changed.";
}
