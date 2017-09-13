package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;


/**
 * Lists all persons in the address book according to the user according to alphabetical order of the names.
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list sorted according to alphabetical order of the names.\n"
            + "Example: " + COMMAND_WORD;

    
    @Override
    public CommandResult execute() {
        List<Person> allPersons = addressBook.getAllPersons().getInternalList();
        Collections.sort(allPersons, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getName().toString().compareTo(person2.getName().toString());
            }
        });

        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
