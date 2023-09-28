public class AVLTreeNode {
    public AVLTreeNode left;
    public AVLTreeNode right;
    public String value;
    public int balance;
    public int depth;


    public AVLTreeNode(String s){
        value = s;
        depth = 1;
        balance = 0;

    }

    public AVLTreeNode(String s, AVLTreeNode l, AVLTreeNode r){
        value = s;
        right = r;
        left = l;
        balance = r.depth-l.depth;
        if (r.depth<=l.depth){
            depth = l.depth + 1;
        }
        else{depth = r.depth+1;}
    }
    public void UpdateBalanceDepth() {
        if (right == null && left == null){
            depth = 1;
            balance = 0;
        }
        else if (right == null){
            depth = left.depth + 1;
            balance = -left.depth;
        }
        else if (left == null){
            depth = right.depth + 1;
            balance = right.depth;
        }
        else {
            balance = right.depth - left.depth;
            if (right.depth <= left.depth) {
                depth = left.depth + 1;
            } else {
                depth = right.depth + 1;
            }
        }
    }



}


