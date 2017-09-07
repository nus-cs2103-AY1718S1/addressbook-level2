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

    @Before
    public void setUp() throws Exception {
        name1 = new Name("emma");
        name2 = new Name("EMMA");
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void isSimilar() {
        assertTrue(isSimilar(name1, name2));
    }

}
