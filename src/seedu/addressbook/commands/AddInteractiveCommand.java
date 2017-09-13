package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.parser.Parser;
import seedu.addressbook.ui.TextUi;

/**
 * Adds a person to the address book.
 */
public class AddInteractiveCommand extends AddCommand {

    public static final String COMMAND_WORD = "add-interactive";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: NAME [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    /**
     * Constructor for AddInteractive
     *
     */
    public AddInteractiveCommand() {
        super();
    }

    @Override
    public CommandResult execute() {
        /*

        */
        TextUi ui = new TextUi();
        ArrayList<Class<?>> infoList = new ArrayList<>(Arrays.asList(
                Name.class, Phone.class, Email.class, Address.class));
        String generatedCommand = AddCommand.COMMAND_WORD;
        for (Class<?> infoClass : infoList) {
            String input = ui.promptUserInput("Please enter " + infoClass.getSimpleName() + ": ");
            try {
                infoClass.getMethod("isPrivate");
                Boolean isPrivate = ui.promptUserInput("Set this field as private? ([Y] for yes): ").trim().toUpperCase()
                        == "Y" ;
                generatedCommand += (isPrivate) ? " p" : " ";
                generatedCommand += Parser.PERSON_DATA_PREFIXES.get(infoClass.getSimpleName());
                generatedCommand += input;
            } catch (NoSuchMethodException | SecurityException e) {
                // Should only happen for Name class
                generatedCommand += " " + input;
            }
        }
        ui.showToUser(generatedCommand);
        /*
        try {
            addressBook.addPerson(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        }
        */
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
