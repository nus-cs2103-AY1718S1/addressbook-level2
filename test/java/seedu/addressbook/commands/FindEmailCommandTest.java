package seedu.addressbook.commands;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindEmailCommandTest {


	@Test
	public void testFindEmailCommand() {
		String keyword = "Alice@Gmail.com";
		FindEmailCommand fmc = new FindEmailCommand(keyword);
		assertNotSame("Matches", "Alice", fmc.getKeywords());
	}

	@Test
	public void testGetKeywords() {
		String keyword = "Alice@Gmail.com";
		FindEmailCommand fmc = new FindEmailCommand(keyword);
		assertNotSame("Matches", "Alice", fmc.getKeywords());
		
	}

}
