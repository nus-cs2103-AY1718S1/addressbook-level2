package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;
import java.util.Comparator;

/**
 * Sorts and list all persons in the address book to the user.
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts and display all persons in the address by their" +
            "name alphabetically.\nExample: " + COMMAND_WORD;

    @Override
    public CommandResult execute(){
        List<ReadOnlyPerson> sortedAllPersons = addressBook.getAllPersons().getNewPersonList();
        sortedAllPersons.sort(new Comparator<ReadOnlyPerson>(){
            public int compare(ReadOnlyPerson person1, ReadOnlyPerson person2){
                return person1.getName().toString().compareToIgnoreCase(person2.getName().toString());
            }
        });
        return new CommandResult(getMessageForSortedPersonListSummary(sortedAllPersons), sortedAllPersons);
    }
}
