package seedu.addressbook.data;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.tag.UniqueTagList;

public class PersonSequenceTest {

    @Test
    public void testSequenceImplementation() throws Exception {

        Name nameOne = new Name("Adam");
        Phone phoneOne = new Phone("888",false);
        Email emailOne = new Email("a@hotmail.com",false);
        Address addressOne = new Address("a,a,#01-01",false);;
        UniqueTagList tagOne = new UniqueTagList();
        Person Adam = new Person(nameOne,phoneOne,emailOne,addressOne,tagOne);
        assertTrue(Adam.getSequenceNumber()==1);

        Name nameTwo= new Name("Ben");
        Phone phoneTwo = new Phone("777",false);
        Email emailTwo = new Email("b@hotmail.com",false);
        Address addressTwo = new Address("b,b,#01-01",false);;
        UniqueTagList tagTwo = new UniqueTagList();
        Person Ben = new Person(nameTwo,phoneTwo,emailTwo,addressTwo,tagTwo);


        Name nameThree = new Name("Charlie");
        Phone phoneThree = new Phone("666",false);
        Email emailThree = new Email("c@hotmail.com",false);
        Address addressThree = new Address("c,c,#01-01",false);;
        UniqueTagList tagThree = new UniqueTagList();
        Person Charlie = new Person(nameThree,phoneThree,emailThree,addressThree,tagThree);

        assertTrue(Ben.getSequenceNumber()==2);
        assertTrue(Charlie.getSequenceNumber()==3);
    }

}
