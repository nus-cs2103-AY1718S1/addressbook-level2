package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Collections;
import java.util.List;

import static seedu.addressbook.data.person.Person.NAMESORT;


public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";
    public static final String PHONECASE = "phone";
    public static final String EMAILCASE = "email";

    private String sortingArg;

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays a persons in the address book as a sorted list with index numbers.\n"
            + "Sorts by name if parameters left blank or if invalid\n"
            + "Parameters: phone email\n"
            + "Example: " + COMMAND_WORD + " email";

    public SortCommand(String argument){
        this.sortingArg = argument;
    }


    @Override
    public CommandResult execute() {
        List<Person> allPersons = addressBook.getAllPersons().changeableListView();
        switch (sortingArg.trim()) {
            case PHONECASE:
                Collections.sort(allPersons, Person.PHONESORT);
                break;
            case EMAILCASE:
                Collections.sort(allPersons, Person.EMAILSORT);
                break;
            default:
                Collections.sort(allPersons, Person.NAMESORT);
                break;
        }
        return new CommandResult(getMessageForPersonSortedShownSummary(allPersons), allPersons);
    }
}
