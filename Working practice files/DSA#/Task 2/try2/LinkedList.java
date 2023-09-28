
class LinkedList {
    private ListNode head = null;
    private int n = 0; // list size
    private ListNode tail = null;

    public void addFirst(Object o) {
        if (n == 0) {
            head = new ListNode(o, null);;
            tail = head;
        }
        else{
        head = new ListNode(o, head);
        }
        n++;
    }

    public void add(Object o) {
        ListNode node = new ListNode(o, null);
        if (n == 0) {
            head = node;
            tail = node;
        }
        else {

            tail.next = node;
            tail = node;
        }
        n++;
    }

    public Object get(int i) {
        if (i<0 || i>=n) {
            return null;
        }
        ListNode node = head;
        for (int j=0; j<i; j++) {
            node = node.next;
        }
        return node.element;
    }

    public void insert(Object o, int i) {
        if (i<0 || i>n) {
            return;
        }
        if (i==0) {
            addFirst(o);
            return;
        }
        if (i==n) {
            add(o);
            return;
        }
        ListNode node = head;
        for (int j=0; j<i-1; j++) {
            node = node.next;
        }
        node.next = new ListNode(o, node.next);
        n++;
        return;
    }
    public void remove(int i) {
        if (i<0 || i>=n){
            return;
        }
        if (i==0) {
            head = head.next;
            n--;
            return;
        }
        ListNode node = head;
        for (int j=0; j<i-1; j++) {
            node = node.next;
        }

        if (i==n-1) {
            node.next = null;
            tail = node;
            n--;
            return;
        }
        node.next = node.next.next;
        n--;

    }

}