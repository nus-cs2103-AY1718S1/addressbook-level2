package seedu.addressbook.commands;


import seedu.addressbook.data.person.ReadOnlyPerson;



import java.util.List;

public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ":Displays all persons in the address book in sorted alphabetical order" +
            " as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> sortedPerson = addressBook.getAllPersons().alphabeticallySortedList();
        return new CommandResult(getMessageForPersonListShownSummary(sortedPerson), sortedPerson);
    }

}
