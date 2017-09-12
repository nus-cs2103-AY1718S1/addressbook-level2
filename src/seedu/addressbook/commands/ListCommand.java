package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
//      List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView()
        List<ReadOnlyPerson> allPersons = getList(addressBook.getAllPersons().iterator());
        Collections.sort(allPersons, (ReadOnlyPerson person1, ReadOnlyPerson person2) ->
                (person1.getName().toString()).compareTo(person2.getName().toString()));
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }

    private List<ReadOnlyPerson> getList(Iterator<Person> iterator) {
        List<ReadOnlyPerson> list = new ArrayList<>();
        while(iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
