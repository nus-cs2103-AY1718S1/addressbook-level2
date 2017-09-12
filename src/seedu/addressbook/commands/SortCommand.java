package seedu.addressbook.commands;

import seedu.addressbook.data.exception.DuplicateDataException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.Block;
import seedu.addressbook.data.person.Street;
import seedu.addressbook.data.person.Unit;
import seedu.addressbook.data.person.Postal;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.tag.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book as a list with index numbers by their name.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_DUPLICATE_PERSON = "There are duplicate data in your addressBook";


    @Override
    public CommandResult execute() {
        try {
            List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
            ArrayList<Person> allNewPersons = new ArrayList<>();
            for (ReadOnlyPerson readOnlyPerson : allPersons) {
                allNewPersons.add(deepCopyPersonFromReadOnlyPerson(readOnlyPerson));
                addressBook.removePerson(readOnlyPerson);
            }

            allNewPersons.sort(new SortPerson());

            for (int i = 0; i < allNewPersons.size(); i++) {
                addressBook.addPerson(allNewPersons.get(i));
            }

            List<ReadOnlyPerson> allNowPersons = addressBook.getAllPersons().immutableListView();

            return new CommandResult(getMessageForPersonSortShownSummary(allNowPersons), allNowPersons);

        } catch (UniquePersonList.PersonNotFoundException e) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        } catch(DuplicateDataException e) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        }
    }

    /**
     * Human Reproduction Centre
     * Create a deep copy real person from the readOnlyPerson object passed
     * @param readOnlyPerson - to be copied
     * @return a human copy
     */
    private Person deepCopyPersonFromReadOnlyPerson(ReadOnlyPerson readOnlyPerson) {
        Name personName = readOnlyPerson.getName();
        Email personEmail = readOnlyPerson.getEmail();
        Phone personPhone = readOnlyPerson.getPhone();
        Address personAddress = readOnlyPerson.getAddress();
        UniqueTagList personTag = readOnlyPerson.getTags();
        return new Person(personName, personPhone, personEmail, personAddress, personTag);
    }

    private static class SortPerson implements Comparator<Person> {

        public final int uniqueId;
        public SortPerson() { uniqueId = 970520;}

        @Override
        public int compare (Person p1, Person p2) {
            String name1 = p1.getName().toString().toLowerCase();
            String name2 = p2.getName().toString().toLowerCase();
            return name1.compareTo(name2);
        }

        public boolean equals (Object other) {
            return (other instanceof SortPerson && uniqueId==((SortPerson) other).uniqueId);
        }

    }
}
