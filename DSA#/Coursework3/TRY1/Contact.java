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
        if (lastName != c.lastName) {
            return lastName.compareTo(c.lastName);
        }
        return firstName.compareTo(c.firstName);
    }
}
