package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.parser.ParserTest;

/**
 *  Added simple parse test for 0-argument command of sort
 */

public class SortCommandTest extends ParserTest {
    @Test
    public void parse_sortCommand_parsedCorrectly() {
        final String input = "sort";
        parseAndAssertCommandType(input, SortCommand.class);
    }
}