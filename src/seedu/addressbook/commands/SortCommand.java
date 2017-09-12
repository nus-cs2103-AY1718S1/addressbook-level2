package seedu.addressbook.commands;

import java.util.List;
import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Sorts all persons in address book according to one of the following arguments - name, email, phone, block
 * If no arguments are specified, persons will be sorted by name
 */

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";


    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts persons according to field specified (name if none specified).\n"
            + "Parameters: [FIELD] (name/phone/email/address)\n"
            + "Example: " + COMMAND_WORD + " address";

    public static final String MESSAGE_SUCCESS = "AddressBook sorted by %1$s";
    private final String field;

    public SortCommand(String field) {
        this.field = field;
    }

    @Override
    public CommandResult execute() {

        addressBook.sortByField(field);
        return new CommandResult(String.format(MESSAGE_SUCCESS, field));
    }

}
