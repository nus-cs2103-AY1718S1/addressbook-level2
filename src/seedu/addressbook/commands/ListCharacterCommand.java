package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class ListCharacterCommand extends Command {

    public static final String COMMAND_WORD = "listchar";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons with the given fist character in the address book as a list with index numbers.\n"
            + "Parameters: listchar CHARACTER\n"
            + "Examples: " + COMMAND_WORD + " A, " + COMMAND_WORD + " b, " + COMMAND_WORD + " #";

    private char listCharacter;

    /**
     * Convenience constructor using raw values.
     */
    public ListCharacterCommand(char inputCharacter) {
        listCharacter = inputCharacter;
    }

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> filteredPersons = new ArrayList<ReadOnlyPerson>();

        for (int i = 0; i < allPersons.size(); i++) {
            ReadOnlyPerson person = allPersons.get(i);
            String personName = (person.getName()).toString();
            char firstCharacter = personName.charAt(0);

            if (firstCharacter == listCharacter){
                filteredPersons.add(person);
            }
        }
        return new CommandResult(getMessageForPersonListShownSummary(filteredPersons), filteredPersons);
    }
}
