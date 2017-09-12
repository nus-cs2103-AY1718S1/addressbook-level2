package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList;

public class SortListCommand extends Command {

    public static final String COMMAND_WORD = "sortlist";
    final private String SORT_NAME = " name";
    final private String SORT_PHONE  = " phone";
    final private String SORT_EMAIL = " email";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Takes in the variable to sort Persons according to that variable and outputs the list"
            + "Example: " + COMMAND_WORD;

    private String sortVar;

    public SortListCommand(String variable) {
        this.sortVar = variable;
    }

    @Override
    // Lists all Persons sorted by input variable
    public CommandResult execute() {
        List<Person> sorted = this.sortPersons();
        return new CommandResult(getMessageForPersonListShownSummary(sorted), sorted);
    }

    private List<Person> sortPersons() {
        // Instantiate allPersons array for sorting
        ArrayList<Person> allPersons = new ArrayList<Person>();
        for (Person p : addressBook.getAllPersons()) {
            allPersons.add(p);
        }

        ArrayList<Person> sortedPersons = new ArrayList<Person>();
        int iterationNum = allPersons.size();
        for (int i = 0; i < iterationNum; i++) {
            Person personToAdd = allPersons.get(0);
            for (Person p : allPersons) {
                if (this.personSortVariable(p).compareToIgnoreCase(this.personSortVariable(personToAdd)) < 0) {
                    personToAdd = p;
                }
            }
            sortedPersons.add(personToAdd);
            allPersons.remove(personToAdd);
        }
        return sortedPersons;
    }

    private String personSortVariable(Person p) {
        switch (this.sortVar) {
            case SORT_NAME:
                return p.getName().toString();
            case SORT_PHONE:
                return p.getPhone().toString();
            case SORT_EMAIL:
                return p.getEmail().toString();
            default:
                return "";
        }
    }



}
