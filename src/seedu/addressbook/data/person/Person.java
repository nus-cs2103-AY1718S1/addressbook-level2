package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
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
    private Address address;
    private Block block;
    private Street street;
    private Unit unit;
    private Postal postal;

    private final UniqueTagList tags;

    /**
     * Assumption: Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, UniqueTagList tags) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.block = address.getBlock();
        this.street = address.getStreet();
        this.unit = address.getUnit();
        this.postal = address.getPostal();
        this.tags = new UniqueTagList(tags); // protect internal tags from changes in the arg list
    }

    public Person(Name name, Phone phone, Email email, Block block,
                  Street street, Unit unit, Postal postal, UniqueTagList tags) throws IllegalValueException{
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.block = block;
        this.street = street;
        this.unit = unit;
        this.postal = postal;
        this.address = new Address(block, street, unit, postal, false);
        this.tags = new UniqueTagList(tags);
    }
    /**
     * Copy constructor.
     */
    public Person(ReadOnlyPerson source) {
        this(source.getName(), source.getPhone(), source.getEmail(), source.getAddress(), source.getTags());
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
    public Address getAddress() {
        return address;
    }

    @Override
    public UniqueTagList getTags() {
        return new UniqueTagList(tags);
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
    public Postal getPostal() {
        return postal;
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
        return Objects.hash(name, phone, email, address, tags);
    }

    @Override
    public String toString() {
        return getAsTextShowAll();
    }

}
