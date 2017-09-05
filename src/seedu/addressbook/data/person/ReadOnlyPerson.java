package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * A read-only immutable interface for a Person in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface ReadOnlyPerson {

    Name getName();
    Phone getPhone();
    Email getEmail();
    Block getBlock();
    Street getStreet();
    Unit getUnit();
    PostalCode getPostalCode();

    /**
     * Returns a new TagList that is a deep copy of the internal TagList,
     * changes on the returned list will not affect the person's internal tags.
     */
    UniqueTagList getTags();

    /**
     * Returns true if both persons have the same identity fields (name and telephone).
     */
    default boolean isSamePerson(ReadOnlyPerson other) {
        return (other == this)
                || (other != null
                    && other.getName().equals(this.getName())
                    && other.getPhone().equals(this.getPhone()));
    }

    /**
     * Returns true if all data in this object is the same as that in another
     * (Note: interfaces cannot override .equals)
     */
    default boolean hasSameData(ReadOnlyPerson other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                    && other.getName().equals(this.getName()) // state checks here onwards
                    && other.getPhone().equals(this.getPhone())
                    && other.getEmail().equals(this.getEmail())
                    && other.getBlock().equals(this.getBlock())
                    && other.getStreet().equals(this.getStreet())
                    && other.getUnit().equals(this.getUnit())
                    && other.getPostalCode().equals(this.getPostalCode())
                    && other.getTags().equals(this.getTags()));
    }

    /**
     * Formats the person as text, showing all contact details.
     */
    default String getAsTextShowAll() {
        final StringBuilder builder = new StringBuilder();
        final String detailIsPrivate = "(private) ";
        builder.append(getName())
                .append(" Phone: ");
        if (getPhone().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getPhone())
                .append(" Email: ");
        if (getEmail().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getEmail())
                .append(" Block: ");
        if (getBlock().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getBlock())
                .append(" Street: ");
        if (getStreet().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getStreet())
                .append(" Unit: ");
        if (getUnit().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getUnit())
                .append(" Postal Code: ");
        if (getPostalCode().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getPostalCode())
                .append(" Tags: ");
        for (Tag tag : getTags()) {
            builder.append(tag);
        }
        return builder.toString();
    }

    /**
     * Formats a person as text, showing only non-private contact details.
     */
    default String getAsTextHidePrivate() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName());
        if (!getPhone().isPrivate()) {
            builder.append(" Phone: ").append(getPhone());
        }
        if (!getEmail().isPrivate()) {
            builder.append(" Email: ").append(getEmail());
        }
        if (!getBlock().isPrivate()) {
            builder.append(" Block: ").append(getBlock());
        }
        if (!getStreet().isPrivate()) {
            builder.append(" Street: ").append(getStreet());
        }
        if (!getUnit().isPrivate()) {
            builder.append(" Unit: ").append(getUnit());
        }
        if (!getPostalCode().isPrivate()) {
            builder.append(" Postal Code: ").append(getPostalCode());
        }
        builder.append(" Tags: ");
        for (Tag tag : getTags()) {
            builder.append(tag);
        }
        return builder.toString();
    }
}
