package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * A write-only immutable interface for a Person in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface WriteOnlyPerson {

    void setName();
    void setPhone();
    void setEmail();
    void setAddress();
    void setTags();

}
