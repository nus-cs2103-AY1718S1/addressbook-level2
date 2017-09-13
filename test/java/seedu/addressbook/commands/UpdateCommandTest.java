package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.util.TestUtil;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;



public class UpdateCommandTest {


	@Test
	public void testUpdateCommand_updatePhone() {
		Person person = TestUtil.generateTestPerson();
		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(person);
		String personName = person.getName().fullName;
		String newPhone = "234234";
		String valueWithPrefix = "p/" + newPhone;
		UpdateCommand command = new UpdateCommand(personName, valueWithPrefix);
		AddressBook book = new AddressBook();

		try {
			book.addPerson(person);
		} catch (Exception e){
			System.out.println("Shouldn't happen");
		}
		command.setData(book, personList);
		command.execute();
		Person newPerson = person;
		for (Person loopPerson: book.getAllPersons()){
			if(loopPerson.getName().equals(person.getName())){
				newPerson = loopPerson;
			}
		}
		assertEquals(newPhone, newPerson.getPhone().value);

	}

	@Test
	public void testUpdateCommand_updateEmail() {
		Person person = TestUtil.generateTestPerson();
		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(person);
		String personName = person.getName().fullName;
		String newEmail = "asdf@asdf.com";
		String valueWithPrefix = "e/" + newEmail;
		UpdateCommand command = new UpdateCommand(personName, valueWithPrefix);
		AddressBook book = new AddressBook();

		try {
			book.addPerson(person);
		} catch (Exception e){
			System.out.println("Shouldn't happen");
		}

		command.setData(book, personList);
		command.execute();
		Person newPerson = person;
		for (Person loopPerson: book.getAllPersons()){
			if(loopPerson.getName().equals(person.getName())){
				newPerson = loopPerson;
			}
		}
		assertEquals(newEmail, newPerson.getEmail().value);

	}

	@Test
	public void testUpdateCommand_updateAddress() {
		Person person = TestUtil.generateTestPerson();
		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(person);
		String personName = person.getName().fullName;
		String newAddress = "Test drive 2";
		String valueWithPrefix = "a/" + newAddress;
		UpdateCommand command = new UpdateCommand(personName, valueWithPrefix);
		AddressBook book = new AddressBook();

		try {
			book.addPerson(person);
		} catch (Exception e){
			System.out.println("Shouldn't happen");
		}

		command.setData(book, personList);
		command.execute();
		Person newPerson = person;
		for (Person loopPerson: book.getAllPersons()){
			if(loopPerson.getName().equals(person.getName())){
				newPerson = loopPerson;
			}
		}
		assertEquals(newAddress, newPerson.getAddress().value);

	}


}