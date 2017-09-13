package seedu.addressbook.data;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import seedu.addressbook.data.person.Name;

import static org.junit.Assert.assertTrue;

public class NameTest {

    private Name name1;
    private Name name2;

    private Name name3;
    private Name name4;

    private Name name5;
    private Name name6;

    @Before
    public void setUp() throws Exception {
        /** Names with upper and lower case*/
        name1 = new Name("emma");
        name2 = new Name("EMMA");

        /** Name that contains another */
        name3 = new Name("EMMA");
        name4 = new Name("EM");

        /** Names with different order */
        name5 = new Name("EMMA");
        name6 = new Name("EAMM");
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void isSimilar() {
        assertTrue(name1.isSimilar(name2));
        assertTrue(name3.isSimilar(name4));
        assertTrue(name5.isSimilar(name6));
    }

}
