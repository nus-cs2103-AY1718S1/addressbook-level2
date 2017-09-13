package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


public class SortCommand extends Command{
    public static final String COMMAND_WORD="sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort all persons by alphabetical order in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute(){
        boolean isEmpty=addressBook.sortPerson();
        List<ReadOnlyPerson> allPersons=addressBook.getAllPersons().immutableListView();
        if(!isEmpty) return new CommandResult("The addressBook is empty, you don't need to sort it!");
        else
            return new CommandResult("Sorted successful for "+getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}