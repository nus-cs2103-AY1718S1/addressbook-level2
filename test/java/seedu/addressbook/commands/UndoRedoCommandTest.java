package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static seedu.addressbook.util.TestUtil.createEmptyApplicationHistory;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.state.ApplicationHistory;
import seedu.addressbook.state.ApplicationState;
import seedu.addressbook.state.exception.EmptyHistoryException;
import seedu.addressbook.state.exception.LoadStateException;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalHistory;
import seedu.addressbook.util.TypicalPersons;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class UndoRedoCommandTest {
    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void undoRedoCommand_EmptyHistoryThrowsException() {
        ApplicationHistory applicationHistory = createEmptyApplicationHistory();
        assertConstructingInvalidUndoRedoCmdThrowsException(applicationHistory);
    }
    
    @Test
    public void assertLoadNewApplicationState() {
        TypicalHistory typicalHistory = new TypicalHistory();
        ApplicationHistory applicationHistory = typicalHistory.typicalHistory;
        ApplicationState assertState = new ApplicationState(TestUtil.createAddressBook(), new ArrayList<>());
        try {
            assertTrue(!addressBook.getAllPersons().immutableListView().isEmpty());
            applicationHistory.loadNewApplicationState(assertState, addressBook);
            assertTrue(addressBook.getAllPersons().immutableListView().isEmpty());
        } catch (LoadStateException e) {
            e.printStackTrace();
            assert false : "assertLoadNewApplicationState failed";
        }
    }
    
    @Test
    public void assertSaveStateBeforeOperation() {
        ApplicationHistory applicationHistory = TestUtil.createEmptyApplicationHistory();
        ApplicationState assertState = new ApplicationState(TestUtil.createAddressBook(), new ArrayList<>());
        applicationHistory.saveStateBeforeOperation(assertState);

        try {
            Field applicationSaveState = applicationHistory.getClass().getDeclaredField("saveState");
            applicationSaveState.setAccessible(true);
            
            assertEquals(applicationSaveState.get(applicationHistory), assertState);
            
        } catch (NoSuchFieldException nsfe) {
            nsfe.printStackTrace();
            assert false : "No saveState exists in application history";
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
            assert false : "Unable to access saveState";
        }
    }
    
    @Test
    public void assertHistoryStackAfterSuccessfulOperation() {
        ApplicationHistory applicationHistory = TestUtil.createEmptyApplicationHistory();
        try {
            Field maxSizeField = applicationHistory.getClass().getDeclaredField("MAX_HISTORY_SIZE");
            maxSizeField.setAccessible(true);
            int maxSize = (int) maxSizeField.get(applicationHistory);
            for (int i = 0; i < maxSize * 3; i++) {
                applicationHistory.pushHistory(new ApplicationState(TestUtil.createAddressBook(), new ArrayList<>()));
            }
            ApplicationState saveState = new ApplicationState(addressBook, addressBook.getAllPersons().immutableListView());
            applicationHistory.saveStateBeforeOperation(saveState);
            applicationHistory.addStateAfterSuccessfulOperation();
            
            assertEquals(saveState, applicationHistory.popHistory());
            
        } catch (NoSuchFieldException nsfe) {
            nsfe.printStackTrace();
            assert false : "No MAX_HISTORY_SIZE exists in application history";
            
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
            assert false : "Unable to access MAX_HISTORY_SIZE";
            
        } catch (EmptyHistoryException ehe) {
            ehe.printStackTrace();
            assert false : "History stack is empty!";
            
        }
    }
    
    @Test
    public void assertUndoTillEmpty() {
        TypicalHistory typicalHistory = new TypicalHistory();
        ApplicationHistory applicationHistory = typicalHistory.typicalHistory;
        try {
            while (!applicationHistory.isEmptyHistory()) {
                applicationHistory.popHistory();
            }
        } catch (EmptyHistoryException ehe) {
            assertTrue(applicationHistory.isEmptyHistory());
        }
    }
    
    @Test
    public void assertRedoTillMax() {
        TypicalHistory typicalHistory = new TypicalHistory();
        ApplicationHistory applicationHistory = typicalHistory.typicalHistory;
        try {
            while (!applicationHistory.isEmptyRedoHistory()) {
                applicationHistory.popRedoHistory();
            }
        } catch (EmptyHistoryException ehe) {
            assertTrue(applicationHistory.isEmptyRedoHistory());
        }
    }
    
    /**
     * Asserts that attempting to pop history or redo history while application history is empty
     * throws EmptyHistoryException
     */
    private void assertConstructingInvalidUndoRedoCmdThrowsException(ApplicationHistory applicationHistory) {
        try {
            applicationHistory.popHistory();
            applicationHistory.popRedoHistory();
        } catch (EmptyHistoryException ehe) {
            return;
        }
        fail("History or redo history has managed to be retrieved with history remaining.");
    }
}
