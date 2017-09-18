package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

import java.util.*;

/**
 * Sorts the address book according to name.
 */
public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts the list according to name.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_ERROR = "Error sorting.";

    public CommandResult execute() {
        Iterator<Person> allPersons = addressBook.getAllPersons().iterator();
        List<Person> sortList = getSortList(allPersons);

        Collections.sort(sortList, (o1, o2) -> o1.getName().fullName.compareTo(o2.getName().fullName));
        try{
            List<ReadOnlyPerson> personList = new UniquePersonList(sortList).immutableListView();
            return new CommandResult(getMessageForPersonListShownSummary(personList), personList);
        }catch (Exception e) {
            return new CommandResult(MESSAGE_ERROR);
        }
    }
    /**
     * Parses arguments in the context of the view all command.
     *
     * @param allPersons Iterator list of all persons in addressbook
     * @return a list that can be sorted
     */
    private List<Person> getSortList(Iterator<Person> allPersons) {
        List<Person> sortList = new ArrayList<Person>();

        while (allPersons.hasNext()) {
            sortList.add(allPersons.next());
        }
        return sortList;
    }

}
