package seedu.addressbook.commands;


import java.util.ArrayList;

/**
 * Deletes a person identified using it's last displayed index from the address book.
 */
public class DeleteRangeCommand extends Command {

    public static final String COMMAND_WORD = "deleterange";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the range of people identified by the index number used in the last person listing.\n"
            + "Parameters: STARTINDEX ENDINDEX\n"
            + "Example: " + COMMAND_WORD + " 1" + " 2";

    private ArrayList<String> targetVisibleIndices;

    @Override
    public CommandResult execute() {
        return null;
    }
}
