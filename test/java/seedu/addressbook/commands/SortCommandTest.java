package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.parser.ParserTest;

public class SortCommandTest extends ParserTest{
    @Test
    public void parse_sortCommand_parsedCorrectly() {
        final String parseName = "sort";
        parseAndAssertCommandType(parseName, SortCommand.class);
    }
}