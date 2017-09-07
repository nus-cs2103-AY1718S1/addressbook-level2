package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import seedu.addressbook.storage.StorageFile;

import static org.junit.Assert.assertEquals;

public class SaveAsCommandTest {
    private static final String TEST_DATA_FOLDER = "test/data/StorageFileTest";
    private static final String VALID_FILE_NAME = "ValidData.xml";
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
        SaveAsCommand command = new SaveAsCommand("some_path.txt");
        CommandResult result = command.execute(storage);

        assertEquals(result.feedbackToUser, StorageFile.MESSAGE_INVALID_STORAGE_PATH);
    }
}
