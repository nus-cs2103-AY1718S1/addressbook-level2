package seedu.addressbook.commands;

import java.util.HashSet;
import java.util.Set;

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

/**
 * Adds a person to the address book.
 */
public class
AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: NAME [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON =
            "This person already exists in the address book, noone else was added";
    public static final String MESSAGE_DUPLICATE_PERSON_CONFIRMATION =
            "This person already exists in the address book,would you like to create another contact?";

    private final Person toAdd;

    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    String Duplicate = "abcde";
    public AddCommand(String name,
                      String phone, boolean isPhonePrivate,
                      String email, boolean isEmailPrivate,
                      String address, boolean isAddressPrivate,
                      Set<String> tags) throws IllegalValueException {
        final Set<Tag> tagSet = new HashSet<>();


        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }

        this.toAdd = new Person(
                new Name(name),
                new Phone(phone, isPhonePrivate),
                new Email(email, isEmailPrivate),
                new Address(address, isAddressPrivate),
                new UniqueTagList(tagSet)


        );

    }

    public AddCommand(Person toAdd) {
        this.toAdd = toAdd;
    }

    public ReadOnlyPerson getPerson() {
        return toAdd;
    }

    @Override
    public CommandResult execute() {
        try {
            // if userReply detected, will run the program with userReply
            if (userReply.contains("yes")){

                toAdd.editName(toAdd.getName() +" Duplicate");
            }

            addressBook.addPerson(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (UniquePersonList.DuplicatePersonException dpe) {

            if (userReply.contains("no")){

                return new CommandResult(MESSAGE_DUPLICATE_PERSON);
            }
            return new CommandResult(MESSAGE_DUPLICATE_PERSON_CONFIRMATION, true);
        }



    }

}


