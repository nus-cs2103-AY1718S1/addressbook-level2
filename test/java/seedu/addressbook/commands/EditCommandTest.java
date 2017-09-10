package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Phone;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class EditCommandTest {
	private static final Set<String> EMPTY_STRING_LIST = Collections.emptySet();

	@Test
	public void editCommand_invalidName_throwsException() {
		final String[] invalidNames = { "", " ", "[]\\[;]" };
		for (String name : invalidNames) {
			assertConstructingInvalidEditCmdThrowsException(1, name, Phone.EXAMPLE, true, Email.EXAMPLE, false,
					Address.EXAMPLE, true, EMPTY_STRING_LIST);
		}
	}

	@Test
	public void addCommand_invalidPhone_throwsException() {
		final String[] invalidNumbers = { "", " ", "1234-5678", "[]\\[;]", "abc", "a123", "+651234" };
		for (String number : invalidNumbers) {
			assertConstructingInvalidEditCmdThrowsException(1, Name.EXAMPLE, number, false, Email.EXAMPLE, true,
					Address.EXAMPLE, false, EMPTY_STRING_LIST);
		}
	}

	@Test
	public void addCommand_invalidEmail_throwsException() {
		final String[] invalidEmails = { "", " ", "def.com", "@", "@def", "@def.com", "abc@",
				"@invalid@email", "invalid@email!", "!invalid@email" };
		for (String email : invalidEmails) {
			assertConstructingInvalidEditCmdThrowsException(1, Name.EXAMPLE, Phone.EXAMPLE, false, email, false,
					Address.EXAMPLE, false, EMPTY_STRING_LIST);
		}
	}

	@Test
	public void addCommand_invalidAddress_throwsException() {
		final String[] invalidAddresses = { "", " " };
		for (String address : invalidAddresses) {
			assertConstructingInvalidEditCmdThrowsException(1, Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
					true, address, true, EMPTY_STRING_LIST);
		}
	}

	@Test
	public void addCommand_invalidTags_throwsException() {
		final String[][] invalidTags = { { "" }, { " " }, { "'" }, { "[]\\[;]" }, { "validTag", "" },
				{ "", " " } };
		for (String[] tags : invalidTags) {
			Set<String> tagsToAdd = new HashSet<>(Arrays.asList(tags));
			assertConstructingInvalidEditCmdThrowsException(1, Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
					true, Address.EXAMPLE, false, tagsToAdd);
		}
	}

	private void assertConstructingInvalidEditCmdThrowsException(int index, String name, String phone,
																 boolean isPhonePrivate, String email, boolean isEmailPrivate, String address,
																 boolean isAddressPrivate, Set<String> tags) {
		try {
			new EditCommand(index, name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate,
					tags);
		} catch (IllegalValueException e) {
			return;
		}

		String error = String.format(
				"An edit command was successfully constructed with invalid input: %d %s %s %s %s %s %s %s %s",
				index, name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate, tags);
		fail(error);
	}
}