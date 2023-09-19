class DoublyLinkedList {
    private ListNode2 head = null;
    private int n = 0; // list size
    private ListNode2 tail = null;
	// TODO implement this...

    /**
     * Prints out the elements in the list from the first to the last (front to back) and then from the last to the first
     * (back to front). This is useful to test whether the list nodes are connected correctly with next and prev references.
     */
    public void addFirst(Object o) {
        if (n == 0) {
            head = new ListNode2(o, null, null);;
            tail = head;
        }
        else{
            ListNode2 node=new ListNode2(o, null, head);
            head.prev=node;
            head = node;
        }
        n++;
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
            ListNode2 node = new ListNode2(o, tail ,null);
            tail.next = node;
            tail = node;
            n++;
            return;
        }
        ListNode2 node = head;
        for (int j=0; j<i-1; j++) {
            node = node.next;
        }
        ListNode2 newone = new ListNode2(o, node ,node.next);
        node.next = newone;
        node.next.next.prev=newone;
        n++;
        return;
    }

    public Object get(int i) {
        if (i<0 || i>=n) {
            return null;
        }
        ListNode2 node = head;
        for (int j=0; j<i; j++) {
            node = node.next;
        }
        return node.element;
    }

    public void print() {
        // no elements to print for empty list
        if (head == null) {
            System.out.println("list empty.");
            return;
        }



        // follow next references to list elements from the front to the back of the list
        System.out.print("front to back: ");
        ListNode2 node = head;
        System.out.print(node.element + " ");
        while (node.next != null) {
            node = node.next;
            System.out.print(node.element + " ");
        }

        // follow prev references to list elements from the back to the front of the list
        System.out.print("-- and back to front: ");
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.prev;
        }
        System.out.println();
    }
    public void remove(int i) {
        if (i<0 || i>=n){
            return;
        }
        if (i==0) {
            head = head.next;
            if (n>1) {
                head.prev = null;
            }
            n--;
            return;
        }
        ListNode2 node = head;
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
        node.next.prev=node;
        n--;

    }
}
