package seedu.addressbook.commands;

import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import java.lang.*;
import java.util.List;


/**
 * Sorts all persons in the address book and lists them to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book sorted, as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {

        List<ReadOnlyPerson> toBeSorted = addressBook.getAllPersons().immutableListView();
        //List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();

        //String name_one = toBeSorted.get(0).getName().toString();
        //String name_two = toBeSorted.get(1).getName().toString();
        /*
        System.out.println(toBeSorted.get(0).getName().toString());
        System.out.println(toBeSorted.get(1).getName().toString());
        */
        //System.out.println(name_one);
        //System.out.println(name_two);
        //System.out.println(name_one.compareTo(name_two));
/*
        for (int i = 0; i < toBeSorted.size() -  1; i++) {
            for (int k = i + 1; k <= toBeSorted.size()-1; k++) {
                ReadOnlyPerson person_one = toBeSorted.get(i);
                ReadOnlyPerson person_two = toBeSorted.get(k);
                if (person_one.getName().toString().compareTo(person_two.getName().toString()) > 0) {
                    toBeSorted.set(i, person_two);
                    toBeSorted.set(k, person_one);
                }
            }
        }
*/
        return new CommandResult(getMessageForPersonListShownSummary(toBeSorted), toBeSorted);

    }
}
