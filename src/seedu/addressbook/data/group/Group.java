package seedu.addressbook.data.group;

import java.util.ArrayList;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;


public class Group {
    private GroupName _name;
    private ArrayList<Person> _members;

    /**
     * Constructor
     * Assumption: Every field must be present and not null
     * @param groupName
     */
    public Group(String groupName) throws IllegalValueException{
        this._name = new GroupName(groupName);
        this._members = new ArrayList<>();
    }

    public Group(GroupName groupName) {
        this._name = groupName;
        this._members = new ArrayList<>();
    }
    /**
     * Add new member
     * @param newMember
     *
     * if member already in group, print error message
     */
    public void addMember(Person newMember) {
        if (this._members.contains(newMember))
            System.out.println(newMember.getName() + " is already in this group!");
        else
            this._members.add(newMember);
    }

    /**
     * Remove member
     * @param member
     *
     * if member not found in group, print error message
     */
    public void removeMember(Person member) {
        if(this._members.contains(member)) {
            this._members.remove(member);
        } else {
            System.out.println(member.getName() + " is not in this group!");
        }
    }

    /**
     * List members
     */
    public void listMembers() {
        int count = 1;
        for (Person E: _members) {
            System.out.println(count++ + ". Name: " + E.getName() + " Phone Number: " + E.getPhone() + " Email: "
                    + E.getEmail() + " Address: " + E.getAddress());
        }
    }

    /**
     * Returns true if both groups have the same name.
     */
    public boolean isSameGroup(Group other) {
        return (other == this)
                || (other != null
                && other.getName().equals(this.getName()));
    }

    public String getName() {
        return this._name.toString();
    }

    public int getNumOfMembers() {
        return this._members.size();
    }

    public ArrayList<Person> getListOfMembers() {
        return this._members;
    }

    public void moveMember(Group origin, Group destination, Person member) {
        destination.addMember(member);
        origin.removeMember(member);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Group // instanceof handles nulls
                && this.hasSameData((Group) other));
    }

    /**
     * Determines if this object has the same data as the other object
     * @param other
     * @return
     */
    public boolean hasSameData(Group other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                && other.getName().equals(this.getName())
                && other.getListOfMembers().equals(this.getListOfMembers())); // state checks here onwards
    }

    public String toString() {
        return this._name.toString();
    }
}
