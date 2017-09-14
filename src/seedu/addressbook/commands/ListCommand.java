package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static int numberOfPersons;

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays the desired number of persons from the address book as an unordered list with index numbers. \n The desired " +
            "number of persons should be given at the same time as the list command.\n"
            + "Example: " + COMMAND_WORD + " 2" ;



    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        try {
            List<ReadOnlyPerson> subListPersons = allPersons.subList(0, numberOfPersons);
            return new CommandResult(getMessageForPersonListShownSummary(subListPersons), subListPersons);

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_NUMBER_PERSONS);
        }


    }

}
