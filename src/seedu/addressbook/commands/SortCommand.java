package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

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
