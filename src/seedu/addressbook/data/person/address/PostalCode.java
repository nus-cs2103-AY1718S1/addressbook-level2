package seedu.addressbook.data.person.address;

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
