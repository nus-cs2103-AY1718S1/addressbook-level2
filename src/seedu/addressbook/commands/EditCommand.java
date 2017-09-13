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
    private Person getPerson, toEdit, editedPerson;
    private int targetIndex;

    public EditCommand(Person toEdit) {
        this.toEdit= toEdit;
    }

    public Person getPerson() {
        return toEdit;
    }

    public EditCommand(int targetVisibleIndex, String arg) throws IllegalValueException {
        super(targetVisibleIndex);
        this.targetIndex=targetVisibleIndex;
        if(arg.length()>=2) {
            this.arg = arg.substring(2);
        }else{
            this.arg=arg;
        }
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
            getPerson = new Person(target);
            EditCommand editCommand=new EditCommand(getPerson);
            toEdit=editCommand.getPerson();
            editedPerson = addressBook.editPerson(toEdit, arg, targetIndex);
//            addressBook.removePerson(target);
//            addressBook.addPerson(editedPerson);
            return new CommandResult(String.format(MESSAGE_SUCCESS, editedPerson));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (IllegalValueException ive) {
            return new CommandResult(MESSAGE_USAGE);
//        } catch (PersonNotFoundException pnfe) {
//            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
//        }
        }
    }

}
