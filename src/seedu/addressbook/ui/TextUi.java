package seedu.addressbook.ui;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class TextUi {

    private final Scanner in;

    private Formatter formatter;

    public TextUi() {
        this(System.in);
    }

    public TextUi(InputStream in) {
        this.formatter = new Formatter();
        this.in = new Scanner(in);
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
        return rawInputLine.trim().matches(formatter.getCommentLineFormatRegex());
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Echos the command back to the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
        formatter.showEnterCommandMessage();
        String fullInputLine = in.nextLine();

        // silently consume all ignored lines
        while (shouldIgnore(fullInputLine)) {
            fullInputLine = in.nextLine();
        }

        formatter.showToUser("[Command entered:" + fullInputLine + "]");
        return fullInputLine;
    }
}
