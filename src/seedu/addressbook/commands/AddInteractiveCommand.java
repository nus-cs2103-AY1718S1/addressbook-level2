package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Arrays;

import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.tag.Tag;
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

    public static final String MESSAGE_SUCCESS = "Adding person to address book...";

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
        // These are the classes that will be only added once
        ArrayList<Class<?>> infoList = new ArrayList<>(Arrays.asList(
                Name.class, Phone.class, Email.class, Address.class));
        String generatedCommand = AddCommand.COMMAND_WORD;
        for (Class<?> infoClass : infoList) {
            String prompt = "Please enter " + infoClass.getSimpleName() + ": ";
            String input = ui.promptUserInput(prompt);
            generatedCommand += generateCommandFromInput(infoClass, input);
        }

        // Tag is not compulsory; ask user first whether they need tags
        ui.showToUser("Do you want to add tags for this person?");
        // Tags may be added multiple times; ask user to input a space-separated list for convenience
        if (ui.isUserAnswerYes()) {
            String tagsInput = ui.promptUserInput("Please enter tags for person (separate multiple tags with spaces):");
            for (String tag : tagsInput.trim().split(" ")) {
                generatedCommand += generateCommandFromInput(Tag.class, tag);
            }
        }

        ui.enqueueCommand(generatedCommand);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    private String generateCommandFromInput(Class<?> infoClass, String input) {
        String generatedCommandSnippet = " ";
        // It would be more user-friendly to validate input here instead of returning error after all the steps
        // However due to time constraint we leave the validation to AddCommand

        try {
            infoClass.getMethod("isPrivate");
            ui.showToUser("Set this field as private?");
            Boolean isPrivate = ui.isUserAnswerYes();
            generatedCommandSnippet += (isPrivate) ? "p" : "";
        } catch (NoSuchMethodException | SecurityException e) {
            // Should only happen for Name and Tag class
        }

        generatedCommandSnippet += Parser.PERSON_DATA_PREFIXES.get(infoClass.getSimpleName());
        generatedCommandSnippet += input;
        return generatedCommandSnippet;
    }

}
