package seedu.addressbook.data.person.address;

/**
 * Represents a Person's address unit segment in the address book.
 * Guarantees: immutable;
 */
public class Unit {
	private final String value;

	public Unit(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof Unit && ((Unit) other).toString().equals(value);
	}
}
