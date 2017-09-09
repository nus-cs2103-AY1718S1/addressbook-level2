package seedu.addressbook.data.person.address;

/**
 * Represents a Person's address postal code segment in the address book.
 * Guarantees: immutable;
 */
public class PostalCode {
	private final String value;

	public PostalCode(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof PostalCode && ((PostalCode) other).toString().equals(value);
	}
}
