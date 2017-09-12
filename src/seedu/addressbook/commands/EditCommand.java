package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;

/**
 * Edits details of an existing person in the Address Book
 */
public class EditCommand extends Command {
    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the phone number, email, or address "
            + "of an existing person in the Address Book.\n"
            + "Parameters: NAME p/PHONE\n"
            + "OR NAME e/EMAIL\n"
            + "OR NAME a/ADDRESS\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432";

    public static final String MESSAGE_SUCCESS = "Person edited: %1$s";
    public static final String MESSAGE_PERSON_NOT_FOUND = "This person doesn't exist in the address book, "
            + "use the 'add' command to add a new person!";
    public static final String MESSAGE_INCORRECT_PARAMETERS = "The parameters supplied seem to be incorrect!";
    public static final String MESSAGE_FIELD_TYPE_NOT_RECOGNISED = "The field type is not recognised, "
            + "Check if you entered it correctly!";

    private final String nameToSearch;
    private final String fieldType;
    private final String newValue;
    private Person personToEdit;

    public EditCommand(String nameToSearch, String fieldType, String newValue)
            throws IllegalValueException {
        this.nameToSearch = nameToSearch;
        this.fieldType = fieldType;
        this.newValue = newValue;
    }

    public ReadOnlyPerson getPerson() {
        return personToEdit;
    }

    @Override
    public CommandResult execute() {
        try {
            personToEdit = getPerson(nameToSearch);
            switch (fieldType) {
                case "p":
                    personToEdit.setPhone(newValue);
                    break;
                case "a":
                    personToEdit.setAddress(newValue);
                    break;
                case "e":
                    personToEdit.setEmail(newValue);
                    break;
                default:
                    return new CommandResult(MESSAGE_FIELD_TYPE_NOT_RECOGNISED);
            }
            return new CommandResult(String.format(MESSAGE_SUCCESS, personToEdit));
        } catch (UniquePersonList.PersonNotFoundException dpe) {
            return new CommandResult(MESSAGE_PERSON_NOT_FOUND);
        } catch (IllegalValueException ive) {
            return new CommandResult(MESSAGE_INCORRECT_PARAMETERS);
        }
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param name for searching
     * @return persons found
     */
    private Person getPerson(String name) throws UniquePersonList.PersonNotFoundException, IllegalValueException {
        Name searchName = new Name(name);

        for (Person person : addressBook.getAllPersons()) {
            final Name personName = person.getName();
            if (searchName.equals(personName)) {
                return person;
            }
        }
        // If the person does not exist in the Address Book yet
        throw new UniquePersonList.PersonNotFoundException();
    }
}

