package seedu.addressbook.commands;

import java.util.List;
import java.util.Random;


import seedu.addressbook.data.person.ReadOnlyPerson;

public class BoredCommand extends Command {

    public static final String COMMAND_WORD = "bored";
    public static final String BORED_SUCCESS = "This person might be bored too! ";
    public static final String BORED_FAILED = "Uh oh! You have no friends :(";


    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = addressBook.getAllPersons().immutableListView();

        Random rand = new Random();
        int index;
        int numPeople = personsFound.size();

        if (numPeople == 0) {
            return new CommandResult(BORED_FAILED);
        }

        else if (numPeople == 1) {
            return new CommandResult(BORED_SUCCESS + personsFound.get(0));
        }

        index = rand.nextInt(personsFound.size());
        return new CommandResult(BORED_SUCCESS + personsFound.get(index).getName());
    }

}
