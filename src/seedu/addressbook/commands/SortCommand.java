package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all people in the address book in alphabetical order and then display "
            + "all persons in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    public static final Comparator<Person> ALPHABETICAL_COMPARATOR
            = (Person a, Person b) -> a.getName().toString().compareToIgnoreCase(b.getName().toString());


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().sort(ALPHABETICAL_COMPARATOR).immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
