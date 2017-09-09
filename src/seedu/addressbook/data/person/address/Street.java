package seedu.addressbook.data.person.address;

/**
 * Represents a Person's address street segment in the address book.
 * Guarantees: immutable;
 */
public class Street {
	private final String value;

	public Street(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof Street && ((Street) other).toString().equals(value);
	}
}
