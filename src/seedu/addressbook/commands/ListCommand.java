package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;
import java.util.Scanner;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays the desired number of persons in the address book as a list with index numbers. If no" +
            "integer is given, all persons will be displayed.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many persons should be displayed? ");
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        if (scanner.hasNextInt()) {
            try {
                int i = scanner.nextInt();
                List<ReadOnlyPerson> subListPersons = allPersons.subList(0, i);

            } catch (IndexOutOfBoundsException ie) {
                return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            }


        }
        else {
            return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
        }
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
