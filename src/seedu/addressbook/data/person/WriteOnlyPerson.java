package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.UniqueTagList;

public interface WriteOnlyPerson {

	void setAddress(Address address);
	void setEmail(Email email);
	void setName(Name name);
	void setPhone(Phone phone);
	void setTags(UniqueTagList tags);
}
