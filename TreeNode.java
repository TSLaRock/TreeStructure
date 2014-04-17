package TreeStructure;

public class TreeNode {
  
  
  // -- DATA -- \\
  private int key = 0;
  private TreeNode parent = null;
  private TreeNode left = null;
  private TreeNode right = null;
  private int pos = 0;
  
  // -- CONSTRUCTORS -- \\
  
  // default constructor, everything is null, key 0
  public TreeNode()
  {
    this.setParent(null);
    this.setLeft(null);
    this.setRight(null);
    this.setKey(0);
  }
  
  // Constructor given a parent and a key  -- don't know if I'll use this anymore
  public TreeNode(TreeNode parent, int key)
  {
    this.setParent(parent);
    this.setLeft(null);
    this.setRight(null);
    this.setKey(key);
  }
  
  // Main constructor, given only a key. The tree
  // will decide the rest of the data to be given
  // to the node when it is added/edited.
  public TreeNode(int key)
  {
    this.setParent(null);
    this.setLeft(null);
    this.setRight(null);
    this.setKey(key);
  }
  
  // 
  
  // -- METHODS -- \\
  
  
  // setParent
  public void setParent(TreeNode parentNode)
  {
    this.parent = parentNode;
  }
  
  
  // getParent
  public TreeNode getParent()
  {
    return(this.parent);
  }
  
  
  // setLeft
  public void setLeft(TreeNode leftNode)
  {
    this.left = leftNode;
  }
  
  
  // getLeft
  public TreeNode getLeft()
  {
    return(this.left);
  }
  
  
  // setRight
  public void setRight(TreeNode rightNode)
  {
    this.right = rightNode;
  }
  
  
  // getRight
  public TreeNode getRight()
  {
    return(this.right);
  }
  
  
  // setKey
  public void setKey(int key)
  {
    this.key = key;
  }
  
  
  // getKey
  public int getKey()
  {
    return(this.key);
  }
  
  // setPos
  public void setPos(int pos)
  {
    this.pos = pos;
  }
  
  // getPos
  public int getPos()
  {
    return(this.pos);
  }
  
  // printNode
  public void printNode()
  {
    System.out.println(this.getKey());
  }
  
  
  
  
} // end class

