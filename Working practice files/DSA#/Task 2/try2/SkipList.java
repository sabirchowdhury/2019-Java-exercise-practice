class SkipList {
    private SkipListNode head[];
    private int n = 0; // list size


    public SkipList() {
        SkipListNode[] head = new SkipListNode[5];

    }

    public void createTestList() {
        n = 2;
        SkipListNode a1 = new SkipListNode("Anne", n);
        SkipListNode b1 = new SkipListNode("Ben", n);
        SkipListNode c1 = new SkipListNode("Charlie", n);
        SkipListNode d1 = new SkipListNode("Don", n);
        SkipListNode e1 = new SkipListNode("Ernie", n);
        head = new SkipListNode[] {a1,a1,a1,null,null};
        a1.next=new SkipListNode[] {b1,c1,e1};
        b1.next=new SkipListNode[] {c1,null,null};
        c1.next=new SkipListNode[] {d1,e1,null};
        d1.next=new SkipListNode[] {e1,null,null};
        e1.next=new SkipListNode[] {null,null,null};
    }

    public void print() {
        SkipListNode node = head[0];

        int layer = n;
        while (layer >= 0) {
            System.out.print(node.element);
            if (node.next[layer]==null){
                node = head[0];
                System.out.println();
                layer--;
            }
            else{node = node.next[layer]; System.out.print(", ");}
        }
    }

    public boolean inList(String s) {
        SkipListNode node = head[0];
        if(node.element==s){return true;}
        int layer = n;
        while (layer >= 0) {
            if (node.next[layer].element == s){return true;}
            if (node.next[layer]==null){return false;}
            if (s.compareTo(node.next[layer].element)<0){layer--;}
            else if(s.compareTo(node.next[layer].element)>0 && node.next[layer].next[layer]==null){return false;}
            else{node = node.next[layer];}
        }
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
