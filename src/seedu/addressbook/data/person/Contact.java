package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Super class for Phone, Email and Address
 */

public class Contact {

	public final String EXAMPLE;
	public final String MESSAGE_CONTACT_CONSTRAINTS;
	public final String CONTACT_VALIDATION_REGEX;

	public final String value;
	private boolean isPrivate;

	/**
	 *  Constructor for setting the values and validating
	 *
	 *  @throws IllegalValueException if given value string is invalid.
	 */
	public Contact(String example,
				   String constraints,
				   String regex,
				   String value,
				   boolean isPrivate) throws IllegalValueException {
		
		this.EXAMPLE = example;
		this.MESSAGE_CONTACT_CONSTRAINTS = constraints;
		this.CONTACT_VALIDATION_REGEX = regex;

		this.setPrivacy(isPrivate);
		String trimmedValue = value.trim();
		if (!isValidContact(trimmedValue)) {
			throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
		}
		this.value = trimmedValue;
	}

	public boolean isPrivate() { return this.isPrivate; }

	private void setPrivacy(boolean privacy){ this.isPrivate = privacy; }

	public boolean isValidContact(String test) { return test.matches(CONTACT_VALIDATION_REGEX); }

	@Override
	public String toString() { return value; }

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Phone // instanceof handles nulls
				&& this.value.equals(((Phone) other).value)); // state check
	}


	@Override
	public int hashCode() { return value.hashCode(); }

}
