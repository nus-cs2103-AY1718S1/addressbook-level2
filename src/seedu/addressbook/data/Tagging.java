package seedu.addressbook.data;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.ui.TextUi;

public class Tagging {
    private ArrayList<TaggingRecord> Taggings;

    public Tagging () {
        Taggings = new ArrayList<>();
    }

    public void addAdditionTaggingRecord (ReadOnlyPerson person, Tag tagToChange) {
        TaggingRecord recordOfAddition = new TaggingRecord(true, person.getName().toString(), tagToChange);
        Taggings.add(recordOfAddition);
    }

    public void addDeletionTaggingRecord (ReadOnlyPerson person, Tag tagToChange) {
        TaggingRecord recordOfDeletion = new TaggingRecord(false, person.getName().toString(), tagToChange);
        Taggings.add(recordOfDeletion);
    }

    /**
     * To give an array list of strings representation of the tagging records.
     * @return an arraylist ready to be passed to UI
     */
    public ArrayList<String> passTaggingRecordStringList () {
        ArrayList<String> recordStringList = new ArrayList<>();
        for (TaggingRecord record: Taggings) {
            recordStringList.add(record.TaggingRecordToString());
        }
        return recordStringList;
    }

    /**
     * A private class implementing the single row of tagging record
     */
    private class TaggingRecord {
        boolean addOrDelete; // Define add to be true and delete be false
        String personName;
        Tag tagToChange;

        /**
         * Constructor for TaggingRecord
         * @param addOrDelete
         * @param personName
         * @param tagToChange
         */
        public TaggingRecord(boolean addOrDelete, String personName, Tag tagToChange) {
            this.addOrDelete = addOrDelete;
            this.personName = personName;
            this.tagToChange = tagToChange;
        }

        /**
         * Copy Constructor
         * @param toBeCopied
         */
        public TaggingRecord(TaggingRecord toBeCopied) {
            this(toBeCopied.getAddOrDelete(), toBeCopied.getPersonName(), toBeCopied.getTagToChange());
        }

        private boolean getAddOrDelete () {
            return addOrDelete;
        }

        private String getPersonName () {
            return personName;
        }

        private Tag getTagToChange () {
            return tagToChange;
        }

        /**
         * Get the String representation of one tagging record
         * @return
         */
        public String TaggingRecordToString(){
            String res = "";
            if (getAddOrDelete()){
                res += "+ ";
            } else {
                res += "- ";
            }
            res += getPersonName() + " ";
            res += getTagToChange().toString();
            return res;
        }
    }
}
