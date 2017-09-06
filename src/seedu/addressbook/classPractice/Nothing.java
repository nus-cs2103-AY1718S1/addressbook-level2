package seedu.addressbook.classPractice;

/**
 * New class for Learning Outcome 4.2
 */
public class Nothing {

    int something = 0;

    public Nothing() {
        this(5);
    }

    public Nothing(int something) {
        this.something = something;
    }

    public int getNothing() {
        return something;
    }

    public void setNothing(int something) {
        this.something = something;
    }

    public static Nothing getNothingObject() {
        //accessing 'something' here will be illegal
        return new Nothing();
    }

}
