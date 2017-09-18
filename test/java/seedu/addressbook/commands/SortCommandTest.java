package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.parser.ParserTest;

public class SortCommandTest {
    public class sortCommandTest extends ParserTest {
        @Test
        public void parse_sortCommand_parsedCorrectly() {
            final String parseCommand = "sort";
            parseAndAssertCommandType(parseCommand, SortCommand.class);
        }
    }
}
