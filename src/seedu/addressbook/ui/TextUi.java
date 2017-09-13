package seedu.addressbook.ui;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Text UI of the application.
 */
public class TextUi {
    private final Scanner in;
    private final PrintStream out;
    private Formatter fm;

    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
        fm = new Formatter();
    }

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(Formatter.COMMENT_LINE_FORMAT_REGEX);
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Echos the command back to the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
        out.print(Formatter.LINE_PREFIX + "Enter command: ");
        String fullInputLine = in.nextLine();

        // silently consume all ignored lines
        while (shouldIgnore(fullInputLine)) {
            fullInputLine = in.nextLine();
        }

        showToUser(fm.formatMessagesToList("[Command entered:" + fullInputLine + "]"));
        return fullInputLine;
    }


    public void showWelcomeMessage(String version, String storageFilePath) {
        showToUser(fm.formatWelcomeMessage(version, storageFilePath));
    }

    public void showGoodbyeMessage() {
        showToUser(fm.formatGoodbyeMessage());
    }


    public void showInitFailedMessage() {
        showToUser(fm.formatInitFailedMessage());
    }

    /** Shows message(s) to the user */
    private void showToUser(List<String> message) {
        for (String m : message) {
            out.println(fm.formatShowToUserMessage(m));
        }
    }

    /** Overloaded method for alternative way to show message(s) to user */
    public void showToUser(String... message) {
        for (String m : message) {
            out.println(fm.formatShowToUserMessage(m));
        }
    }

    /**
     * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    public void showResultToUser(CommandResult result) {
        final Optional<List<? extends ReadOnlyPerson>> resultPersons = result.getRelevantPersons();
        resultPersons.ifPresent(readOnlyPeople -> showToUser(fm.formatPersonListView(readOnlyPeople)));
        showToUser(fm.formatCommandResult(result));
    }
}
