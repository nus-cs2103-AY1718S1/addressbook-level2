package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.UniqueTagList;

import java.util.Objects;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Person implements ReadOnlyPerson {

    private Name name;
    private Phone phone;
    private Email email;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private final UniqueTagList tags;

    /**
     * Assumption: Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Block block, Street street, Unit unit, PostalCode postalCode, UniqueTagList tags) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.block = block;
        this.street = street;
        this.unit = unit;
        this.postalCode = postalCode;
        this.tags = new UniqueTagList(tags); // protect internal tags from changes in the arg list
    }

    /**
     * Copy constructor.
     */
    public Person(ReadOnlyPerson source) {
        this(source.getName(), source.getPhone(), source.getEmail(), source.getBlock(), source.getStreet(), source.getUnit(), source.getPostalCode(), source.getTags());
    }

    @Override
    public Name getName() {
        return name;
    }

    @Override
    public Phone getPhone() {
        return phone;
    }

    @Override
    public Email getEmail() {
        return email;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public Street getStreet() {
        return street;
    }

    @Override
    public Unit getUnit() {
        return unit;
    }

    @Override
    public PostalCode getPostalCode() {
        return postalCode;
    }

    @Override
    public UniqueTagList getTags() {
        return new UniqueTagList(tags);
    }

    /**
     * Replaces this person's tags with the tags in the argument tag list.
     */
    public void setTags(UniqueTagList replacement) {
        tags.setTags(replacement);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReadOnlyPerson // instanceof handles nulls
                && this.hasSameData((ReadOnlyPerson) other));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, block, street, unit, postalCode, tags);
    }

    @Override
    public String toString() {
        return getAsTextShowAll();
    }

}
