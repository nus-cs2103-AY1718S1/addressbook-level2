package seedu.addressbook.data;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    // Two sample persons used for test
    private Person aliceBetsy;
    private Person bobChaplin;

    @Before
    public void setUp() throws Exception {
        aliceBetsy = new Person(new Name("Alice Betsy"),
                                 new Phone("91235468", false),
                                 new Email("alice@nushackers.org", false),
                                 new Address("8 Computing Drive, Singapore", false),
                                 new UniqueTagList());

        bobChaplin = new Person(new Name("Bob Chaplin"),
                                 new Phone("94321500", false),
                                 new Email("bob@nusgreyhats.org", false),
                                 new Address("9 Computing Drive", false),
                                 new UniqueTagList());
    }

    /**
     * Tests whether the sequence number of Person objects is incremental and starts from 1.
     */
    @Test
    public void person_sequenceNumber_incremental() {
        // Notice: We cannot individually test their sequenceNumbers, because we do not when this test will be called.
        assertEquals(1, bobChaplin.getSequenceNumber() - aliceBetsy.getSequenceNumber());
    }
}
