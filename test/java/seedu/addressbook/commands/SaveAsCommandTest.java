package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import seedu.addressbook.storage.StorageFile;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SaveAsCommandTest {
    private static final String TEST_DATA_FOLDER = "test/data/StorageFileTest";
    private static final String VALID_FILE_NAME = "ValidData.xml";
    private static final String VALID_NEW_FILE_NAME = "NewValidData.xml";
    private static final String INVALID_FILE_EXTENSION = "some_path.txt";

    private StorageFile storage = null;

    @Before
    public void setup() throws Exception {
        storage = new StorageFile(TEST_DATA_FOLDER + "/" + VALID_FILE_NAME);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /***
     * Returns a failure message (rather than throws any exception) when the file extension is invalid.
     */
    @Test
    public void saveAsCommand_invalidFileExtension_returnsIncorrect() {
        SaveAsCommand command = new SaveAsCommand(TEST_DATA_FOLDER + "/" + INVALID_FILE_EXTENSION);
        CommandResult result = command.execute(storage);

        assertEquals(StorageFile.MESSAGE_INVALID_STORAGE_PATH, result.feedbackToUser);
    }

    /**
     * Checks whether the static method isSaveAs can distinguish real/fake SaveAs commands.
     */
    @Test
    public void saveAsCommand_isSaveAs_correctlyChecking() {
        Command deleteCommand = new DeleteCommand(10);
        Command saveASCommand = new SaveAsCommand(TEST_DATA_FOLDER + "/" + VALID_FILE_NAME);

        assertFalse(SaveAsCommand.isSaveAs(deleteCommand));
        assertTrue(SaveAsCommand.isSaveAs(saveASCommand));
    }

    /**
     * Tests whether the storage file path is really changed if the newPath is valid.
     */
    @Test
    public void saveAsCommand_correctlyExecute_changeFilePath() {
        SaveAsCommand command = new SaveAsCommand(TEST_DATA_FOLDER + "/" + VALID_NEW_FILE_NAME);
        CommandResult result = command.execute(storage);

        assertEquals(SaveAsCommand.MESSAGE_SUCCESS, result.feedbackToUser);

        Path expected = Paths.get(TEST_DATA_FOLDER + "/" + VALID_NEW_FILE_NAME);
        Path actual = Paths.get(storage.getPath());

        /*
        We use equals method in Path Class to get rid of OS-dependent constraints in the file path.
         */
        assertTrue(expected.equals(actual));
    }
}
