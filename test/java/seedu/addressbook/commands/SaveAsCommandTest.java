package seedu.addressbook.commands;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import seedu.addressbook.storage.StorageFile;

public class SaveAsCommandTest {
    private static final String TEST_DATA_FOLDER = "test/data/StorageFileTest";
    private static final String VALID_FILE_NAME = "ValidData.xml";
    private static final String INVALID_FILE_EXTENSION = "some_path.txt";

    private StorageFile storage = null;

    @Rule
    private ExpectedException thrown = ExpectedException.none();

    @Test
    public void saveAsCommand_invalidFileExtension_returnsIncorrect() {
        SaveAsCommand command = new SaveAsCommand("some_path.txt");
        CommandResult result = command.execute();
    }
}
