package seedu.addressbook.data.person;

public class Contacts {
        public final String value;
        protected boolean isPrivate;

        public Contacts (String value, boolean isPrivate) {
            this.value = value;
            this.isPrivate = isPrivate;
        }

        @Override
        public String toString() {
            return value;
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        public boolean isPrivate() {
            return isPrivate;
        }
}
