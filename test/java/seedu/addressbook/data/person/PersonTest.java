package seedu.addressbook.data.person;

import org.junit.Test;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PersonTest {
    
    @Test
    public void checkSequence() throws Exception {
        ArrayList<Person> list = new ArrayList<Person>();

        Address address = new Address("abc", true);
        Phone phone = new Phone("12312312", true);
        Email email = new Email("asd@gmail.com", true);
        UniqueTagList tags = new UniqueTagList();
        Person person1 = new Person(new Name("Adam"), phone, email, address, tags);
        list.add(person1);
        Person person2 = new Person(new Name("Ben"), phone, email, address, tags);
        list.add(person2);
        Person person3 = new Person(new Name("Charlie"), phone, email, address, tags);
        list.add(person3);
        list.remove(person3);
        Person person4 = new Person(new Name("Daisy"), phone, email, address, tags);
        list.add(person4);

        assertTrue(person1.getSequence() == 1);
        assertTrue(person2.getSequence() == 2);
        assertTrue(person4.getSequence() == 4);
        assertFalse(person4.getSequence() == 3);

    }
}