package TreeStructure;

public class Tree{
  
  // -- DATA -- \\
  private TreeNode root = null;
  private int size = 0; // used for special case testing statements
  private TreeNode current = null;

  
  // -- CONSTRUCTORS -- \\
  public Tree()
  {
    this.root = null;
  }
  
  public Tree(TreeNode rootNode)
  {
    this.root = rootNode;
    size = 1;
  }
  
  // -- METHODS -- \\
  
  // getRoot method, only necessary as a 
  // paramter for the printTree(TreeNode) method
  public TreeNode getRoot()
  {
    return root;
  }
  
  
  // add
  public void add(TreeNode newNode)
  { 
    current = root;
    // special case if the size is 1
    if(size == 1)
    {
      // if the keys are equal, print an error message
      if(newNode.getKey() == root.getKey())
      {
        System.out.println("ERROR: DUPLICATE KEYS NOT ALLOWED.");
      }
      // if the key is less, set the newnode to the left
      else if(newNode.getKey() < root.getKey())
      {
        newNode.setParent(root);
        root.setLeft(newNode);
        newNode.setPos(0);
        size++;
        
      }
      // if the key is greater, set the newnode to the right
      else if(newNode.getKey() > root.getKey())
      {
        newNode.setParent(root);
        root.setRight(newNode);
        newNode.setPos(1);
        size++;
      }
    }
    else // if the tree size > 1
    {
      // traverse to find the node to compare to
      traverse(newNode.getKey());
      // if the newNode's key is equal to current's key
      // print an error message
      if(newNode.getKey() == current.getKey())
      {
        System.out.println("ERROR: DUPLICATE KEYS NOT ALLOWED.");
      }
      // if the newNode's key is less than current's key,
      // add it to the left
      else if(newNode.getKey() < current.getKey())
      {
        newNode.setParent(current);
        current.setLeft(newNode);
        newNode.setPos(0);
        size++;
      }
      // if the key is greater, add to the right
      else if(newNode.getKey() > current.getKey())
      {
        newNode.setParent(current);
        current.setRight(newNode);
        newNode.setPos(1);
        size++;
      }
    }
    // do not increment size unconditionally,
    // because if someone tries to add a duplicate
    // size should not increase. 
    
    
    // reset current to root
    current = root;
  }
  
  
  // traverse method
  // Assumes the current will be equal to the root when being called
  // Will traverse until the key is either found, the tree ends, or 
  // the proper place for the key to go is found
  public void traverse(int key)
  {
    // if the current key is already equal, return
    if (key == current.getKey())
    {
      return;
    }
    
    // if the key is less than the current key
    else if(key < current.getKey())
    {
      // go left
      while (current.getLeft() != null)
      {
        // if the key is equal, return
        if ( key == current.getKey())
        {
          return;
        }
        else if(key < current.getKey())
        {
          // traverse to the left
          current = current.getLeft();
        }
        else if( key > current.getKey())
        {
          // traverse right
          current = current.getRight();
        }
      }
    }
    else if(key > current.getKey())
    {
      while (current.getRight() != null)
      {
        // if the key is equal, return
        if ( key == current.getKey())
        {
          return;
        }
        else if(key < current.getKey())
        {
          // traverse to the left
          current = current.getLeft();
        }
        else if( key > current.getKey())
        {
          // traverse right
          current = current.getRight();
        }
        
      }
    }
    // if the key is greater than the current key, go right
    else if( key > current.getKey())
    {
      // go right
      while (current.getRight() != null)
      {
        // if the keys are equal, return
        if ( key == current.getKey())
        {
          return;
        }
        // if the key is less than the current node
        else if(key < current.getKey())
        {
          // traverse to the left
          current = current.getLeft();
        }
        // if the key is greater than the current node
        else if( key > current.getKey())
        {
          // traverse right
          current = current.getRight();
        }
      }
    }
  }
  
  // this method uses the traverse method
  // to attempt to find keys that we suspect
  // are in the tree. If the key isn't there,
  // an error message is printed. 
  public void find(int key)
  {
    traverse(key);
    if(current.getKey() == key)
    {
    current.printNode();
    }
    else
    {
      System.out.println("The key you're looking for was not found.");
    }
    current = root;
  }
  
    // remove node
  public void del(int key) 
  {
    // reset current to root
    current = root;
    
    // current should be pointing to where key goes
    traverse(key);
    
    // test if key exists
    if (current.getKey() != key)
    {
      System.out.println(key + " does not exist.");
    }
    else
    // we know where the key is but not whether it is
    // the left or the right node of the parent.
    {
      // delete leaf
      if ((current.getLeft() == null) && 
          (current.getRight() == null))
      {
        // find if current is a left or a right subtree
        if (current.getPos() == 0) // 0 = left
        {
          // find root of current subtree: current.getParent()
          // and set it's left reference to null
          current.getParent().setLeft(null);
        }
        else // 1 = right
        {
          // find root of current subtree: current.getParent()
          // and set it's right reference to null
          current.getParent().setRight(null);
        }
      }
      // delete node with only right child
      else if (current.getLeft() == null) 
      {
        // check if this is parent's left node
        if (current.getPos() == 0) // 0 = left
        {
          // find root of current subtree: current.getParent()
          // and set it's right reference to deleted node's child
          current.getParent().setLeft(current.getRight());
        }
        else // right
        {
          // find root of current subtree: current.getParent()
          // and set it's right reference to deleted node's child
          current.getParent().setRight(current.getRight());
        }
      }
      // delete node with only left child
      else if (current.getRight() == null) 
      {
        // check if this is parent's left node
        if (current.getPos() == 0) // 0 = left
        {
          // find root of current subtree: current.getParent()
          // and set it's left reference to deleted node's child
          current.getParent().setLeft(current.getLeft());
        }
        else // right
        {
          // find root of current subtree: current.getParent()
          // and set it's left reference to deleted node's child
          current.getParent().setRight(current.getLeft());
        }
      }
      // delete node with 2 children
      else
      {
        TreeNode rl = current;
        // find left most descendent of right subtree
        rl = current.getRight();
        while(rl.getLeft() != null)
          rl = rl.getLeft();
        current.setKey(rl.getKey());
        rl.getParent().setLeft(null);
      }
    }
  }
  
  // polymorphic printTree() with empty paramters
 public void printTree()
 {
   this.printTree(root);
 }
 
 // actual printTree method, needs to start at the root
 public void printTree(TreeNode node)
 {
   // if the given node (initially the root) isn't null
  if (node != null)
  {
    // call printTree on the left subtree
   printTree(node.getLeft());
   // print the root
   node.printNode();
   // call printTree again, this time on 
   // the right subtree
   printTree(node.getRight());
  }
 }
   
  
} // end class