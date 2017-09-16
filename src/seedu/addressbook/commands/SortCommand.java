package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


/**
 * Lists all persons in the address book to the user in a sorted order.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list according to the alphabetical order of their names.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<Person> allPersons = addressBook.getAllPersons().getInternalList();
        sort(allPersons);
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }

    public void sort(List<Person> allPersons){
        Collections.sort(allPersons, new Comparator< Person>(){
            public int compare (Person person1, Person person2){
                return person1.getName().toString().compareTo(person2.getName().toString());
            }
        });
    }
}

