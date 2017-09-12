package seedu.addressbook.commands;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.List;


/**
 * Sorts all people in the address book in alphabetical order and displays the new list with indexes to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all people in the address book in alphabetical order and then display "
            + "the list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    public static final Comparator<Person> ALPHABETICAL_COMPARATOR
            = (Person a, Person b) -> a.getName().toString().compareToIgnoreCase(b.getName().toString());


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons =
                addressBook.sort(ALPHABETICAL_COMPARATOR).getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
