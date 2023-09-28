class SkipList {
    private SkipListNode head;
    private int n = 0; // list size
    private int layers;


    SkipList() {
        SkipListNode head = new SkipListNode(null,new SkipListNode[] {null,null,null,null,null});

    }

    public void createTestList() {
        layers=2;
        SkipListNode e1 = new SkipListNode("Ernie",new SkipListNode[] {null,null,null});
        SkipListNode d1 = new SkipListNode("Don",new SkipListNode[] {e1,null,null});
        SkipListNode c1 = new SkipListNode("Charlie",new SkipListNode[] {d1,e1,null});
        SkipListNode b1 = new SkipListNode("Ben",new SkipListNode[] {c1,null,null});
        head = new SkipListNode("Anne",new SkipListNode[] {b1,c1,e1});
    }

    public void print() {
        SkipListNode node = head;

        int layer = layers;
        while (layer >= 0) {
            System.out.print(node.element);
            if (node.next[layer]==null){
                node = head;
                System.out.println();
                layer--;
            }
            else{node = node.next[layer]; System.out.print(", ");}
        }
    }

    public boolean inList(String s) {
        SkipListNode node = head;
        if(node.element==s){return true;}
        int layer = layers;
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
