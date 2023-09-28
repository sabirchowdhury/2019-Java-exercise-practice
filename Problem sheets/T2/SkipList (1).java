class SkipList {
    private SkipListNode[] head;
    private int n = 0; // list size

    public SkipList() {
        // TODO implement this
    }

    public void createTestList() {
        // TODO implement this
    }

    public void print() {
        // TODO implement this
    }

    public boolean inList(String s) {
        // TODO implement this
        return false;
    }

    public static void main(String[] args) {
        SkipList sl = new SkipList();
        sl.createTestList();
        sl.print();
        System.out.println();

        System.out.println(sl.inList("Anne") + " should be true");
        System.out.println(sl.inList("Ben") + " should be true");
        System.out.println(sl.inList("Charlie") + " should be true");
        System.out.println(sl.inList("Don") + " should be true");
        System.out.println(sl.inList("Ernie") + " should be true");

        System.out.println(sl.inList("Arya") + " should be false");
        System.out.println(sl.inList("Elmo") + " should be false");
        System.out.println(sl.inList("Zorro") + " should be false");
    }
}
