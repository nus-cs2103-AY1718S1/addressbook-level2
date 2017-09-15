package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> sortedPersons = sortPersonsAlphabetically(
                                                        addressBook.getAllPersons().immutableListView());
        return new CommandResult(getMessageForPersonSortShownSummary(sortedPersons), sortedPersons);
    }

    /**
     * Sorts and displays all persons in the address book alphabetically.
     *
     * @param  unsortedPersons for sorting
     * @return list of persons sorted
     */
    private List<ReadOnlyPerson> sortPersonsAlphabetically(List<ReadOnlyPerson> unsortedPersons) {
        List<ReadOnlyPerson> sortedPersons = new ArrayList<ReadOnlyPerson>(unsortedPersons);
        Collections.sort(sortedPersons, new Comparator<ReadOnlyPerson>() {
            public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2) {
                return (p1.getName().toString()).compareTo(p2.getName().toString());
            }
        });
        return sortedPersons;
    }

}
