package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.group.Group;
import seedu.addressbook.data.group.GroupName;
import seedu.addressbook.data.group.UniqueGroupList;
import seedu.addressbook.util.TestUtil;

public class AddGroupCommandTest {
    private static final List<Group> EMPTY_GROUP_LIST = Collections.emptyList();

    @Test
    public void addGroupCommand_invalidName_throwsException() {
        final String[] invalidNames = { "", " ", "[]\\[;]" };
        for (String name : invalidNames) {
            assertConstructingInvalidAddGroupCmdThrowsException(name);
        }
    }

    /**
     * Asserts that attempting to construct an addgroup command with the supplied
     * invalid data throws an IllegalValueException
     */
    private void assertConstructingInvalidAddGroupCmdThrowsException(String name) {
        try {
            new AddGroupCommand(name);
        } catch (IllegalValueException e) {
            return;
        }
        String error = String.format(
                "An add group command was successfully constructed with invalid input: %s", name);
        fail(error);
    }

    @Test
    public void addGroupCommand_validData_correctlyConstructed() throws Exception {
        AddGroupCommand command = new AddGroupCommand(GroupName.EXAMPLE);
        Group p = command.getGroup();

        assertEquals(GroupName.EXAMPLE, p.getName());
    }

    @Test
    public void addGroupCommand_emptyAddressBook_addressBookContainsGroup() {
        Group p = TestUtil.generateTestGroup();
        AddGroupCommand command = new AddGroupCommand(p);
        AddressBook book = new AddressBook();
        command.setGroupData(book, EMPTY_GROUP_LIST);
        CommandResult result = command.execute();
        UniqueGroupList groups = book.getAllGroups();

        assertTrue(groups.contains(p));
        assertEquals(1, groups.immutableListView().size());
        assertFalse(result.getRelevantGroups().isPresent());
        assertEquals(String.format(AddGroupCommand.MESSAGE_SUCCESS, p), result.feedbackToUser);
    }

    @Test
    public void addGroupCommand_addressBookAlreadyContainsGroup_addressBookUnmodified() throws Exception {
        Group p = TestUtil.generateTestGroup();
        AddressBook book = new AddressBook();
        book.addGroup(p);
        AddGroupCommand command = new AddGroupCommand(p);
        command.setGroupData(book, EMPTY_GROUP_LIST);
        CommandResult result = command.execute();

        assertFalse(result.getRelevantPersons().isPresent());
        assertEquals(AddGroupCommand.MESSAGE_DUPLICATE_GROUP, result.feedbackToUser);
        UniqueGroupList groups = book.getAllGroups();
        assertTrue(groups.contains(p));
        assertEquals(1, groups.immutableListView().size());
    }
}
