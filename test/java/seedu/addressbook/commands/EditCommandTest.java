package seedu.addressbook.commands;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import seedu.addressbook.data.exception.IllegalValueException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class EditCommandTest {

    @Test
    public void assertValidConstructed() throws Exception{
        Set<String> defaultTags = new HashSet<>();
        Set<String> emptyTags = new HashSet<>();

        defaultTags.add("programmer");

        new EditCommand("Alice Betsy",
                null, false,
                "alice@nushackers.org", false,
                "8 Computing Drive, Singapore", false,
                "0101", false,
                defaultTags);

        new EditCommand("Alice Betsy",
                "91235468", false,
                null, false,
                "8 Computing Drive, Singapore", false,
                "0101", false,
                defaultTags);

        new EditCommand("Alice Betsy",
                "91235468", false,
                "alice@nushackers.org", false,
                null, false,
                "0101", false,
                defaultTags);

        new EditCommand("Alice Betsy",
                "91235468", false,
                "alice@nushackers.org", false,
                "8 Computing Drive, Singapore", false,
                null, false,
                defaultTags);

        new EditCommand("Alice Betsy",
                "91235468", false,
                "alice@nushackers.org", false,
                "8 Computing Drive, Singapore", false,
                "0101", false,
                emptyTags);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void assertInvalidConstructed() throws Exception{
        thrown.expect(IllegalValueException.class);
        new EditCommand("",
                "91235468", false,
                "alice@nushackers.org", false,
                "8 Computing Drive, Singapore", false,
                "0101", false,
                new HashSet<>());
    }
}