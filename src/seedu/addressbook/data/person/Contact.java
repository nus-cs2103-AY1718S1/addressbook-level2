package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book. Parent class of Email, Phone
 * and Address classes.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public abstract class Contact {
	public static String EXAMPLE;
	public static String MESSAGE_CONSTRAINT = "Invalid Contact format";
	public static String VALIDATION_REGEX;

	public String value;
	private boolean isPrivate;

	/**
	 * Validates given contact.
	 *
	 * @throws IllegalValueException if given contact string is invalid.
	 */
	public void setContact(String contact, boolean isPrivate) throws IllegalValueException {
		this.isPrivate = isPrivate;
		String trimmedContact = contact.trim();
		if (!isValidContact(contact)) {
			throw new IllegalValueException(MESSAGE_CONSTRAINT);
		}

		this.value = trimmedContact;
	}

	/**
	 * Returns true if the given string is a valid contact.
	 */
	public static boolean isValidContact(String contact) {
		return contact.matches(VALIDATION_REGEX);
	};

	public void setContactConstants(String example, String constraints, String regex) {
		EXAMPLE = example;
		MESSAGE_CONSTRAINT = constraints;
		VALIDATION_REGEX = regex;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Contact // instanceof handles nulls
				&& this.value.equals(((Contact) other).value)); // state check
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}
