package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class TextUi {

    /**
     * Offset required to convert between 1-indexing and 0-indexing.
     */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    private final Scanner in;
    private static PrintStream out = null;

    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || Formatter.isCommentLine(rawInputLine);
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Echos the command back to the user.
     *
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
        out.print(Formatter.getEnterCommandString());
        String fullInputLine = in.nextLine();

        // silently consume all ignored lines
        while (shouldIgnore(fullInputLine)) {
            fullInputLine = in.nextLine();
        }

        showToUser(Formatter.getCommandEnteredString(fullInputLine));
        return fullInputLine;
    }

    public void showWelcomeMessage(String version, String storageFilePath) {
        showToUser(Formatter.getWelcomeMessage(version, storageFilePath));
    }

    public void showGoodbyeMessage() {
        showToUser(Formatter.getGoodbyeMessage());
    }

    public void showInitFailedMessage() {
        showToUser(Formatter.getInitFailedMessage());
    }

    /**
     * Shows message(s) to the user
     */
    public static void showToUser(String... message) {
        for (String m : message) {
            out.println(Formatter.formatForUser(m));
        }
    }

    /**
     * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    public void showResultToUser(CommandResult result) {
        showToUser(Formatter.formatResultForUser(result));
    }

}
