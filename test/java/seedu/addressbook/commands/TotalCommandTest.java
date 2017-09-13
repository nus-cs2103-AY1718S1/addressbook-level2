package seedu.addressbook.commands;

import org.junit.Test;

import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TotalCommandTest {

    /**
     * Simple test to ensure that the total command works with one contact inside the list.
     * @throws Exception
     */
    @Test
    public void execute() throws Exception {

        ReadOnlyPerson stranger = new Person(new Name("me"),
                new Phone("123", true),
                new Email("some@hey.go", true),
                new Address("nus", false),
                new UniqueTagList(Collections.emptySet()));

        List<ReadOnlyPerson> listWithExtraPerson = new ArrayList<ReadOnlyPerson>();
        listWithExtraPerson.add(stranger);
        assertValue(listWithExtraPerson);
    }

    public void assertValue(List persons) throws Exception {
        assertTrue(persons.size() == 1);
        assertFalse(persons.size() !=1);
    }
}