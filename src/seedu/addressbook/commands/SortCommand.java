package seedu.addressbook.commands;


import seedu.addressbook.data.person.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Sorts a list of persons alphabetically.
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the list of persons in the address book "
            + "alphabetically.\n" + "Example: " + COMMAND_WORD;

    private List<Person> sortAddressBook() {
        List<Person> tempSortList = getPersonList();
        Collections.sort(tempSortList, (o1, o2) -> o1.getName().fullName.compareTo(o2.getName().fullName));

        return tempSortList;
    }

    private List<Person> getPersonList() {
        List<Person> tempSortList = new ArrayList<>();
        Iterator<Person> listIter = addressBook.getAllPersons().iterator();

        while (listIter.hasNext()) {
            tempSortList.add(listIter.next());
        }
        return tempSortList;
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(getMessageForPersonListShownSummary(sortAddressBook()), sortAddressBook());
    }
}
