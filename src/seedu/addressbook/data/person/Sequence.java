package seedu.addressbook.data.person;

public class Sequence {
    public static int nextSequenceNumber = 0;
    private int sequenceNumber;
    public Sequence() {
        nextSequenceNumber++;
        sequenceNumber= nextSequenceNumber;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

}
