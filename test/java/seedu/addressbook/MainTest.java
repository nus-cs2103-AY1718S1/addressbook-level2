package seedu.addressbook;

import org.junit.Test;
import java.io.ByteArrayInputStream;

public class MainTest {
    private static char S = '\n';

    @Test
    public void main() throws Exception {
        Main runMain = new Main();
        String commandIn;
        commandIn = "list" + S +
                "private 1 email" + S +
                "list"  + S +
                "private 1" + S +
                "list" + S +
                "private 1 UNDO" + S +
                "exit" + S;
        ByteArrayInputStream input = new ByteArrayInputStream(
                (commandIn).getBytes());
        System.setIn(input);
        runMain.main();
        System.setIn(System.in);
    }
}