public class Contact implements Comparable<Contact> {
    public String firstName;
    public String lastName;

    public Contact(String f, String l) {
        firstName = f; lastName = l;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public int compareTo(Contact c) {
        // TODO Q1
        return 0;
    }
}
