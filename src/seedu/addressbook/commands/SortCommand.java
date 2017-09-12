package seedu.addressbook.commands;

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
            + ": Sorts all people in the address book in a specific order and then display the list with index numbers. \n" +
            "   - option 0: alphabetical order \n" +
            "   - option 1: order of length \n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final Comparator<Person> ALPHABETICAL_COMPARATOR
            = (Person a, Person b) -> a.getName().toString().compareToIgnoreCase(b.getName().toString());

    public static final Comparator<Person> NAME_LENGTH_COMPARATOR
            = Comparator.comparingInt(p -> p.getName().toString().length());

    public final Comparator<Person>[] COMPARATORS
            = new Comparator[]{ ALPHABETICAL_COMPARATOR, NAME_LENGTH_COMPARATOR };

    public final Comparator<Person> COMPARATOR_OPTION;

    public SortCommand(int option){
        COMPARATOR_OPTION = COMPARATORS[option];
    }


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons
                = addressBook.sort(COMPARATOR_OPTION).getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
