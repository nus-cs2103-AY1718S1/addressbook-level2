package seedu.addressbook.data.person;

public class Contact {

	protected String EXAMPLE;
	protected String MESSAGE_CONTACT_CONSTRAINTS;
	protected String CONTACT_VALIDATION_REGEX;

	public String value;
	private boolean isPrivate;

	/**
	 * Returns true if the given string is a valid person phone number.
	 */
	public boolean isValidContact(String test) {
		return test.matches(this.CONTACT_VALIDATION_REGEX);
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Phone // instanceof handles nulls
				&& this.value.equals(((Phone) other).value)); // state check
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}

}
