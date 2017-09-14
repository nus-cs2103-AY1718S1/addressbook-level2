package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SortCommandTest {
    public static ArrayList<Person> sortedPersonsList;

    @Test
    public void sortCommand_CorrectOrder() throws Exception {
        sortedPersonsList = new ArrayList<Person>();

        Person john     =  new Person(new Name("John Smith"), new Phone("1112223333", false), new Email("john@mail.com", false), new Address("111 Nowhere way", false),  new UniqueTagList());
        Person zahir    =  new Person(new Name("Zahir Smith"), new Phone("1112223333", false), new Email("john@mail.com", false), new Address("111 Nowhere way", false),  new UniqueTagList());
        Person anand    =  new Person(new Name("Anand Smith"), new Phone("1112223333", false), new Email("john@mail.com", false), new Address("111 Nowhere way", false),  new UniqueTagList());
        Person jermaine =  new Person(new Name("Jermaine Smith"), new Phone("1112223333", false), new Email("john@mail.com", false), new Address("111 Nowhere way", false),  new UniqueTagList());

        sortedPersonsList.add(anand);
        sortedPersonsList.add(jermaine);
        sortedPersonsList.add(john);
        sortedPersonsList.add(zahir);

        ArrayList<Person> randomPersonsList = new ArrayList<Person>();
        randomPersonsList.addAll(sortedPersonsList);
        Collections.shuffle(randomPersonsList);


        AddressBook testBook = new AddressBook();
        for (Person p : randomPersonsList) {
            testBook.addPerson(p);
        }

        Command sortbook = new SortCommand();
        sortbook.setData(testBook, testBook.getAllPersons().immutableListView());
        CommandResult result = sortbook.execute();

        List<ReadOnlyPerson> resultPersonsList = testBook.getAllPersons().immutableListView();

        boolean inOrder = true;

        for (int i = 0; i < sortedPersonsList.size(); i++) {
            if (!resultPersonsList.get(i).getName().equals(sortedPersonsList.get(i).getName())) {
                inOrder = false;
                System.out.println(resultPersonsList.get(i).getName());
                System.out.println(sortedPersonsList.get(i).getName());
            }
        }

        assertTrue(inOrder);
    }
}
