package seedu.addressbook.commands;

import java.util.HashSet;
import java.util.Set;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Block;
import seedu.addressbook.data.person.PostalCode;
import seedu.addressbook.data.person.Street;
import seedu.addressbook.data.person.Unit;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * Adds a person to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: NAME [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25, 123456 t/friends t/owesMoney";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    private final int BLOCK_POSITION = 0;
    private final int STREET_POSITION = 1;
    private final int UNIT_POSITION = 2;
    private final int POSTAL_CODE_POSITION = 3;

    private final Person toAdd;

    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public AddCommand(String name,
                      String phone, boolean isPhonePrivate,
                      String email, boolean isEmailPrivate,
                      String address, boolean isAddressPrivate,
                      Set<String> tags) throws IllegalValueException {
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }
        String[] splitAddressToComponents = address.split(", ");
        this.toAdd = new Person(
                new Name(name),
                new Phone(phone, isPhonePrivate),
                new Email(email, isEmailPrivate),
                new Address(new Block(splitAddressToComponents[BLOCK_POSITION], isAddressPrivate), new Street(splitAddressToComponents[STREET_POSITION], isAddressPrivate),
                        new Unit(splitAddressToComponents[UNIT_POSITION], isAddressPrivate), new PostalCode(splitAddressToComponents[POSTAL_CODE_POSITION], isAddressPrivate), isAddressPrivate),
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
            addressBook.addPerson(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        }
    }

}
