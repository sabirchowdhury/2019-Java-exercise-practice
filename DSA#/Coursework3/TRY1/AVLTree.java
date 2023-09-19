class AVLTree {
  AVLTreeNode root;
  // Note: you may define other variables here

  public AVLTree() {
    // TODO implement this
    root = new AVLTreeNode(null);
  }

  public AVLTree(String q) {
    // TODO implement this
    root = new AVLTreeNode(q);
  }

  public void createTestTree() {
    // TODO implement this
    AVLTreeNode node1 = new AVLTreeNode("1");
    AVLTreeNode node2 = new AVLTreeNode("3");
    AVLTreeNode node3 = new AVLTreeNode("5");
    AVLTreeNode node4 = new AVLTreeNode("7");
    AVLTreeNode node5 = new AVLTreeNode("6",node3,node4);
    AVLTreeNode node6 = new AVLTreeNode("2",node1,node2);
    root = new AVLTreeNode("4",node6,node5);
  }

  public void print() {
    // TODO implement this

    PreOrder(root,-1);
  }
  private void PreOrder(AVLTreeNode node, int level){
    level=level+1;
    int threshold = root.depth+4;
    String indent = "  ";
    System.out.println(indent.repeat(level) + node.value);// + indent.repeat(threshold - level) + "      B;" + node.balance + " D;" + node.depth);
    if (node.left != null) {
      PreOrder(node.left, level);
    }
    if (node.right != null) {
      PreOrder(node.right, level);
    }

  }

  public boolean inTree(String e) { 
    // TODO implement this
    AVLTreeNode node = root;
    while (node != null){
      if (node.value.compareTo(e) == 0){
        return true;
      }
      else if (e.compareTo(node.value) < 0){
        node = node.left;
      }
      else{
      node = node.right;}
    }
    return false;
  }

  public void insert(String e) { 
    // TODO implement this
    // TODO implement this
    AVLTreeNode[] stack = new AVLTreeNode[root.depth+5];
    AVLTreeNode node = root;
    int level = 0;
    boolean added = false;
    while (!added){
      stack[level]=node;
      level=level+1;
      if (e.compareTo(node.value) < 0){
        if(node.left == null){node.left = new AVLTreeNode(e);added = true;UpdateValues(stack,level);}
        else{node = node.left;}
      }
      else{
        if(node.right == null){node.right = new AVLTreeNode(e);added = true;UpdateValues(stack,level);}
        else{node = node.right;}
        }
    }
  }
  private void UpdateValues(AVLTreeNode[] stack, int level){
    int Adopt = 0;
    for (int i = level - 1; i >= 0; i--){
      if(Adopt == -1){RightRotate(stack[i],stack[i+1]);Adopt = 0;}
      if(Adopt == 1){LeftRotate(stack[i],stack[i+1]);Adopt = 0;}

      stack[i].UpdateBalanceDepth();
      if (stack[i].balance<-1){
        Adopt = -1;
      }
      else if (stack[i].balance>1){
        Adopt = 1;
      }
    }
    if(Adopt == -1){RightRotate(root);}
    if(Adopt == 1){LeftRotate(root);}
    root.UpdateBalanceDepth();

  }

  private void RightRotate(AVLTreeNode parent, AVLTreeNode son){//WHEN BALANCE <0 -- -2
    if (son.left.balance > 0){LeftRotate(son,son.left);}

    if (parent.left==son){parent.left=son.left;}
    if (parent.right==son){parent.right=son.left;}

    AVLTreeNode newdad = son.left;
    AVLTreeNode temp = newdad.right;
    son.left=temp;
    newdad.right = son;

    son.UpdateBalanceDepth();
    newdad.UpdateBalanceDepth();
  }
  private void RightRotate(AVLTreeNode son){//WHEN BALANCE <0 -- -2
    if (son.left.balance > 0){LeftRotate(son,son.left);}
    root=son.left;
    AVLTreeNode newdad = son.left;
    AVLTreeNode temp = newdad.right;
    son.left=temp;
    newdad.right = son;

    son.UpdateBalanceDepth();
    newdad.UpdateBalanceDepth();
  }
  private void LeftRotate(AVLTreeNode parent, AVLTreeNode son){//WHEN BALANCE >0 -- 2
    if (son.right!=null){
    if (son.right.balance < 0){RightRotate(son,son.right);}}//LR Rotate
    if (parent.left==son){parent.left=son.right;}
    if (parent.right==son){parent.right=son.right;}

    AVLTreeNode newdad = son.right;
    AVLTreeNode temp = newdad.left;
    son.right=temp;
    newdad.left=son;//problem

    son.UpdateBalanceDepth();
    newdad.UpdateBalanceDepth();
  }
  private void LeftRotate(AVLTreeNode son){
    if (son.right.balance < 0){RightRotate(son,son.right);}
    root=son.right;
    AVLTreeNode newdad = son.right;
    AVLTreeNode temp = newdad.left;
    son.right=temp;
    newdad.left=son;

    son.UpdateBalanceDepth();
    newdad.UpdateBalanceDepth();
  }

}
