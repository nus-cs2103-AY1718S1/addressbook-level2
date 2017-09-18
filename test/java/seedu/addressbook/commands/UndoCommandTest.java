package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.stack.CommandPair;
import seedu.addressbook.parser.ParserTest;

import static org.junit.Assert.*;
import static seedu.addressbook.commands.Command.undoStack;

public class UndoCommandTest {
    private UndoCommand undoCommand = new UndoCommand();

    @Test
    public void undoCommand_correctlyRecognisesUndo() throws Exception {
        assertTrue(undoCommand.isUndoCommand());
    }

    @Test
    public void undoCommand_successfullyPreparesCommand() throws Exception {
        Person p = ParserTest.generateTestPerson();
        undoCommand.setIsUndoingAdd(0);
        undoCommand.setPerson(p);
        undoStack.push(new CommandPair(p, 0));
        Command command = undoCommand.prepareCommand();
        assertTrue(command!=null);
    }
}