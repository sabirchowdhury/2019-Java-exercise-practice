import java.util.Random;

class SkipListNode {
    public String element;
    public SkipListNode[] next;
    private Random r;

    public SkipListNode(String s) {
        element = s;
        Random r = new Random();
        int x = 1;
        while (r.nextFloat() < 0.5)
            x++;
        next = new SkipListNode[x];
    }


    public SkipListNode(String s, int d) {
        element = s;
        next = new SkipListNode[d];

    }

}

