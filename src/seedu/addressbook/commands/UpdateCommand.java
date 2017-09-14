package seedu.addressbook.commands;

import java.util.Optional;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;


public class UpdateCommand extends Command {


	public static final String COMMAND_WORD = "update";

	private static final String MESSAGE_UPDATE_SUCCESS = "Person's information was updated";

	public static final String MESSAGE_USAGE = COMMAND_WORD
			+ ": Updates persons information based on the given parameter. "
			+ "Parameters: NAME PREFIX/NEW_VALUE\n"
			+ "Example: " + COMMAND_WORD
			+ " John Doe p/98765432";

	public static final String MESSAGE_PERSON_NOT_FOUND = "No person found with that name.";
	public static final String MESSAGE_ERROR_OCCURRED = "Unknown error occurred.";

	private final String personName;
	private final String valueWithPrefix;


	public UpdateCommand(String personName, String valueWithPrefix) {
		this.personName = personName;
		this.valueWithPrefix = valueWithPrefix;

	}

	@Override
	public CommandResult execute() {
		Optional<Person> personToUpdate = getPersonByName(this.personName);
		if(personToUpdate.isPresent()) {
			try {
				updateInformationForPerson(personToUpdate.get(), valueWithPrefix);
				return new CommandResult(MESSAGE_UPDATE_SUCCESS);
			} catch (Exception e){
				e.printStackTrace();
				return new CommandResult(e.getMessage());
			}
		}else {
			return new CommandResult(MESSAGE_PERSON_NOT_FOUND);
		}
	}


	public Optional<Person> getPersonByName(String name) {
		for(Person person : addressBook.getAllPersons()) {
			if(person.getName().fullName.equals(name)){
				return Optional.of(person);
			}
		}
		return Optional.empty();
	}

	private void updateInformationForPerson(Person person, String valueWithPrefix)
			throws IllegalValueException, PersonNotFoundException{

		String value = valueWithPrefix.substring(2, valueWithPrefix.length());
		String prefix = valueWithPrefix.substring(0,2);

		if (prefix.equals("p/")) {

			Phone newPhone = new Phone(value, person.getPhone().isPrivate());
			Person newPerson = new Person(person.getName(),
					newPhone,
					person.getEmail(),
					person.getAddress(),
					person.getTags());

			this.addressBook.removePerson(person);
			this.addressBook.addPerson(newPerson);
			
		} else if(prefix.equals("e/")) {

			Email newEmail = new Email(value, person.getEmail().isPrivate());
			Person newPerson = new Person(person.getName(),
					person.getPhone(),
					newEmail,
					person.getAddress(),
					person.getTags());

			this.addressBook.removePerson(person);
			this.addressBook.addPerson(newPerson);
			
		} else if(prefix.equals("a/")){

			Address newAddress = new Address(value, person.getAddress().isPrivate());
			Person newPerson = new Person(person.getName(),
					person.getPhone(),
					person.getEmail(),
					newAddress,
					person.getTags());

			this.addressBook.removePerson(person);
			this.addressBook.addPerson(newPerson);
			
		} else {
			throw new IllegalValueException(MESSAGE_ERROR_OCCURRED);
		}
	}

}
