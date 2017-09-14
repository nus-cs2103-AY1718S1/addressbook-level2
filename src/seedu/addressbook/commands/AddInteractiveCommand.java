package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

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

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book with guided steps. "
            + "Example: " + COMMAND_WORD;

    private TextUi ui;

    //public static final String MESSAGE_SUCCESS = "New person added: %1$s";

    /**
     * Constructor for AddInteractive
     *
     */
    public AddInteractiveCommand(TextUi ui) {
        super();
        this.ui = ui;
    }

    @Override
    public CommandResult execute() {
        /*

        */
        ArrayList<Class<?>> infoList = new ArrayList<>(Arrays.asList(
                Name.class, Phone.class, Email.class, Address.class));
        String generatedCommand = AddCommand.COMMAND_WORD;
        for (Class<?> infoClass : infoList) {
            String input = ui.promptUserInput("Please enter " + infoClass.getSimpleName() + ": ");
            try {
                infoClass.getMethod("isPrivate");
                String isPrivateInput = ui.promptUserInput("Set this field as private? ([Y] for yes): ").trim().toUpperCase();
                // It would be more user-friendly to validate input here instead of returning error after all the steps
                // However due to time constraint we leave the validation to AddCommand
                Boolean isPrivate = Objects.equals(isPrivateInput, "Y");
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
