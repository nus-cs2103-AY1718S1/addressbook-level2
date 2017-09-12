package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.list;

/*
    Lists the people in the addressbook in alphabetical order
 */

public class SortCommand extends Command{

    public static final String COMMAND_WORD = 'sort';

    public static final String MESSAGE_USAGE = COMMAND_WORD

            + "Displays all persons in address book in alphabetical order as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute(){
        List <ReadOnlyPerson> allPersons = getAllPersonsSorted().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}