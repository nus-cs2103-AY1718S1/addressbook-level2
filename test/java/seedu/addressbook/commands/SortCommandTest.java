package seedu.addressbook.commands;

/**
 * Created by Philemon1 on 14/9/2017.
 */

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all people by alphabetical order" +
            "No parameter needed.";
    public static final String MESSAGE_SUCCESS = "All people sorted";
    public static final String MESSAGE_ALREADY_SORTED = "Already sorted";

    UniquePersonList tempPersonList = new UniquePersonList();
    Person expectedPerson;

    @Test
    public void sortCommand_correctlySorted(){
        try {
            Person temp1 = new Person(
                    new Name("Zack Tan"),
                    new Phone("96225555", false),
                    new Email("adamTan@gmail.com", false),
                    new Address("Jurong North Street 42 blk 222", false),
                    new UniqueTagList()
            );

            Person temp2 = new Person(
                    new Name("Adam Tan"),
                    new Phone("96225555", false),
                    new Email("adamTan@gmail.com", false),
                    new Address("Jurong North Street 42 blk 222", false),
                    new UniqueTagList()
            );
            expectedPerson = temp2;
            tempPersonList.add(temp1);
            tempPersonList.add(temp2);
        }
        catch (IllegalValueException e){
            return;
        }

        tempPersonList.internalSort();

        Iterator<Person> tempIterator = tempPersonList.iterator();
        Person actualPerson = tempIterator.next();

        assertEquals(expectedPerson, actualPerson);
    }


}
