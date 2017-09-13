package seedu.addressbook.commands;


//Testing the why function as compulsory LO


import org.junit.Test;

import static org.junit.Assert.*;

public class WhyCommandTest {

    public static final String MESSAGE_WHY_DEFAULT = "I'm sorry, my responses are limited, you must ask the right questions";

    @Test//TESTING THE DEFAULT CASE
    public void execute() throws Exception {
        //Nonsensical String
        assertWhyCommandBehavior("any nonsensical value over here");

        //Empty String
        assertWhyCommandBehavior("");

    }



    private void assertWhyCommandBehavior(String question) {
        WhyCommand why = new WhyCommand(question);
        CommandResult result = why.execute();
        assertEquals(MESSAGE_WHY_DEFAULT, result.feedbackToUser);
    }


}