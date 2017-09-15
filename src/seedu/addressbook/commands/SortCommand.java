package seedu.addressbook.commands;

import seedu.addressbook.data.person.*;

import java.lang.reflect.Array;
import java.util.*;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort persons by name and displays all persons in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<Person> futureSortedList = new ArrayList<>();
        /* Copy the read-only list into a list of persons to sort */
        for(int i = 0; i < allPersons.size(); i++){
            Person p = new Person(allPersons.get(i).getName(), allPersons.get(i).getPhone(), allPersons.get(i).getEmail(),
                    allPersons.get(i).getAddress(), allPersons.get(i).getTags());
            futureSortedList.add(p);
        }
        Collections.sort(futureSortedList);
        List<ReadOnlyPerson> SortedList = new ArrayList<>();
        /* Copy back to a new list of ReadOnlyPerson to use the ListCommand tools */
        for(int i = 0; i < allPersons.size(); i++){
            ReadOnlyPerson p = new Person(futureSortedList.get(i).getName(), futureSortedList.get(i).getPhone(), futureSortedList.get(i).getEmail(),
                    futureSortedList.get(i).getAddress(), futureSortedList.get(i).getTags());
            SortedList.add(p);
        }

        return new CommandResult(getMessageForPersonListShownSummary(SortedList), SortedList);
    }


}
