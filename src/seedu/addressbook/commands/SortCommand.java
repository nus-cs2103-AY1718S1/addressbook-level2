package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Displays the alphabetically sorted list of persons."
            + "Example: " + COMMAND_WORD;


    public static final String MESSAGE_SUCCESS = "Sorting performed successfully.";

    public SortCommand() {}


    @Override
    public CommandResult execute() {
        final boolean isListSizeZero = (addressBook.getAllPersons().immutableListView().size() == 0);
        if (isListSizeZero) {
            return new CommandResult(Messages.MESSAGE_FAILED_SORTING);
        }
        List<ReadOnlyPerson> sortedPersonList = addressBook.getSortedPersons();
        return new CommandResult(MESSAGE_SUCCESS, sortedPersonList);
    }
    
}
