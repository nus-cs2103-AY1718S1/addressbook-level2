package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;

import java.util.Set;

/**
 * Edits a person identified using it's last displayed index from the address book.
 */
public class EditCommand extends Command{
    public static final String COMMAND_WORD = "edit";

    private static final String SELECTED_INDEX = "1";
    private static final String MESSAGE_USAGE_EXAMPLE = COMMAND_WORD + "\n"
            + "<List of all people in the address book will be populated>\n"
            + COMMAND_WORD + " " + SELECTED_INDEX
            + " John Doe [p]p/98765432 pe/johnd@gmail.com [p]a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits a person in the address book."
            + "Select the index of the person to be edited from the list provided.\n"
            + "The first command will just be " + COMMAND_WORD + " to list all the people in the database.\n"
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: n/NAME [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + MESSAGE_USAGE_EXAMPLE;
    public static final String MESSAGE_SUCCESS = "Selected person is edited: %1$s";

    /**
     * Constructor to delete a person based on index and add a new person in replacement.
     *  @param index index of the person in the previous listing after calling "edit"
     * @param name name of the person
     * @param phone phone number of the person
     * @param isPhonePrivate private status of phone number
     * @param email email of the person
     * @param isEmailPrivate private status of email
     * @param address address of the person
     * @param isAddressPrivate private status of address
     * @param tagArguments tags to the person
     */
    public EditCommand(String index, String name,
                       String phone, boolean isPhonePrivate,
                       String email, boolean isEmailPrivate,
                       String address, boolean isAddressPrivate,
                       Set<String> tagArguments){
    }

    @Override
    public CommandResult execute() {
//        EditCommand personIndex = new EditCommand(1);
        return new CommandResult(String.format(MESSAGE_SUCCESS, "abc"));
    }
}
