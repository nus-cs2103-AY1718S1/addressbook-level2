package seedu.addressbook.commands;

public class EditCommand extends Command {
    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits a person's details in the address book based on the index of last viewed list"
            + " and the detail that the user wants to edit.\n"
            + "Example: " + COMMAND_WORD + " 1\n"
            + " e/jdoe95@gmail.com";

    @Override
    public CommandResult execute() {
        
    }
}
