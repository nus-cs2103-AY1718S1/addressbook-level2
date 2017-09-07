package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;

import java.util.*;

import static seedu.addressbook.common.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";
    public static final String MESSAGE_USAGE = "Edit details of a person.\n"
            + "Example: " + COMMAND_WORD + " INDEX p/[Value to change]";

    public static final String MESSAGE_SUCCESS = "Edited Person: %1$s";
    public String arg;
    public Person person;
    //   private final Set<String> keywords;
//
//    public EditCommand(Set<String> keywords) {
//        this.keywords = keywords;
//    }

    /**
     * Returns a copy of keywords in this command.
     */
    //  public Set<String> getKeywords() {
//        return new HashSet<>(keywords);
//    }
    private Person toEdit, editedPerson;

    public EditCommand(int targetVisibleIndex, String arg) {
        super(targetVisibleIndex);
        this.arg = arg.substring(2);
        // isEditArgValid(arg);
    }
//
//    public EditCommand(Person toEdit) {
//        this.toEdit = toEdit;
//    }

    @Override
    public CommandResult execute() {
        //   final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(keywords);
        // return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
        try {
            final ReadOnlyPerson target = getTargetPerson();
            toEdit = new Person(target);
          //  toEdit=person.getPerson(target);
            editedPerson = addressBook.editPerson(toEdit, arg);
            addressBook.removePerson(target);
            addressBook.addPerson(editedPerson);
            return new CommandResult(String.format(MESSAGE_SUCCESS, editedPerson));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (IllegalValueException ive) {
            return new CommandResult(MESSAGE_USAGE);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }
    }

}
