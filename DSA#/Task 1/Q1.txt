/** A stack abstract data type that contains Strings. */
public class StringStack {

    // TODO add variables for data here
    private String[] Array;
    private int Acapacity;
    private int length = 0;
    /**
     * Constructor for creating a new StringStack with a certain capacity.
     * @param capacity the maximum number of strings the stack can hold
     */
    public StringStack(int capacity) {
        Acapacity = capacity;
        Array = new String[capacity];
        // TODO implement this
    }

    /**
     * Puts the given String on top of the stack (if there is enough space).
     * @param s the String to add to the top of the stack
     * @return false if there was not enough space in the stack to add the string;
     *         otherwise true
     */
    public boolean push(String s) {
        if (length < Acapacity){
            Array[length] = s;
            length=length+1;
            return true;
        }
        else{
            return false;
            // TODO implement this
        }
    }

    /**
     * Removes the String on top of the stack from the stack and returns it.
     * @return the String on top of the stack, or null if the stack is empty.
     */
    public String pop() {
        if (length > 0){
            String word = Array[length-1];
            Array[length-1] = "";
            length=length-1;
            return word;
        }
        else{
            return "null";
            // TODO implement this
        }
        // TODO implement this
    }

    /**
     * Returns the number of Strings in the stack.
     * @return the number of Strings in the stack
     */
    public int count() {
        return length;
        // TODO implement this
    }
}