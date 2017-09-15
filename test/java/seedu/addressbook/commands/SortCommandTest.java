package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Haozhe_Haotian on 15/9/17.
 */
public class SortCommandTest{


    @Test
    public void sort() throws Exception {
        Person a = new Person(new Name("a"),
                new Phone("123", false),
                new Email("some@hey.go", false),
                new Address("nus", false),
                new UniqueTagList(Collections.emptySet()));

        Person b = new Person(new Name("b"),
                new Phone("321", false),
                new Email("aome@hey.go", false),
                new Address("nus", false),
                new UniqueTagList(Collections.emptySet()));

        //create the list of person
        List<Person> listOfPersonbyName = new UniquePersonList(a, b).getInternalList();

        //test for sorting by name
        SortCommand testSort = new SortCommand(" name");
        List<Person> sortedListByName = testSort.sort("name", listOfPersonbyName);
        assertTrue(sortedListByName.equals(listOfPersonbyName));

        //test for sorting by email
        List<Person> listOfPersonByEmail = new UniquePersonList(b, a).getInternalList();
        List<Person> sortedListByEmail = testSort.sort("email", listOfPersonbyName);
        assertTrue(sortedListByEmail.equals(listOfPersonbyName));
    }

}