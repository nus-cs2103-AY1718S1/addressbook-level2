package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Lists all persons in the address book to the user, sorted by name.
 */
public class ListSortCommand extends Command {

    public static final String COMMAND_WORD = "listsort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book sorted by name in ascending order\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        Comparator<ReadOnlyPerson> compare= new Comparator<ReadOnlyPerson>() {

            @Override
            public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2){
                String p1Name = p1.getName().toString();
                String p2Name = p2.getName().toString();
                return p1Name.compareTo(p2Name);
            }
        };

        ArrayList<ReadOnlyPerson> copyOfPeople = new ArrayList<>();
        copyOfPeople.addAll(addressBook.getAllPersons().immutableListView());
        copyOfPeople.sort(compare);

        return new CommandResult(getMessageForPersonListShownSummary(copyOfPeople), copyOfPeople);
    }
}
