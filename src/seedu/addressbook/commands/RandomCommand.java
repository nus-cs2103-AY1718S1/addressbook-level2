package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Returns a random person from the address book
 */
public class RandomCommand extends Command {

    public static final String COMMAND_WORD = "random";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Returns a random person from the address book.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        if (allPersons.isEmpty()) {
            return new CommandResult(getMessageForAddressBookIsEmpty());
        } else {
            final List<ReadOnlyPerson> personFound = getRandomPerson(allPersons);
            return new CommandResult(getMessageForRandomPersonFound(), personFound);
        }
    }

    /**
     * Retrieves all persons in the address book and returns a random person from the list.
     *
     * @param allPersons all the persons in the address book
     * @return random person
     */
    private List<ReadOnlyPerson> getRandomPerson(List<ReadOnlyPerson> allPersons) {
        final List<ReadOnlyPerson> randomPerson = new ArrayList<>();
        randomPerson.add(allPersons.get(new Random().nextInt(allPersons.size())));
        return randomPerson;
    }
}
