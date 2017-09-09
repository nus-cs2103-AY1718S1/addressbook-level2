package seedu.addressbook.data.person.address;

/**
 * Represents a Person's address block segment in the address book.
 * Guarantees: immutable;
 */
public class Block {
	private final String value;

	public Block(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof Block && ((Block) other).toString().equals(value);
	}
}
