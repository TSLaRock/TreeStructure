package TreeStructure;
//import java.util.*;
public class Main{
  
  public static void main(String args[])
  {
    /* This class will test the Tree class.
     * It will test adding nodes, adding
     * duplicate nodes, finding nodes
     * by traversing the tree, and printing
     * the tree in-order. There is a scanner
     * class so the tester can add nodes as they
     * please and print the tree to test that it
     * is working. 
     */

    TreeNode testNode = new TreeNode();
    TreeNode testNode1 = new TreeNode(9);
    TreeNode testNode2 = new TreeNode(4);
    TreeNode testNode3 = new TreeNode(8);
    TreeNode testNode4 = new TreeNode(3);
    TreeNode testNode5 = new TreeNode(10);
    
    Tree testTree = new Tree(testNode3);
    testTree.add(testNode2);
    testTree.add(testNode1);
    testTree.add(testNode4);
    
    /* test that duplicates can't be added
    TreeNode duplicateNode = new TreeNode(4);
    testTree.add(duplicateNode); */
    
    
    testTree.add(testNode);
    testTree.add(testNode5);
    
    // test printing the tree
    // printTree must take the root as a paramater
    testTree.printTree();
    System.out.println("PRINT DONE");
    testTree.del(8);
    testTree.printTree();
    
    
    // test the find method
    // which uses the traverse method
    testTree.find(0);
    testTree.find(1);
    testTree.find(2);
    testTree.find(3);
    testTree.find(8);
    
    
    
    
    
    /* START SCANNER
    Scanner sc = new Scanner(System.in);
    String input = null;
    while( input != "q")
    {
      System.out.println("Add, Print or quit?");
      input = sc.next();
      if((input.compareTo("add") == 0) || (input.compareTo("Add") == 0))
      {
        System.out.println("Enter the integer you would like to add: ");
        TreeNode newN = new TreeNode(sc.nextInt());
        testTree.add(newN);
      }
      else if((input.compareTo("Print") == 0) || (input.compareTo("print") == 0))
      {
        testTree.printTree(testTree.getRoot());
      }
      else if((input.compareTo("quit") == 0) || (input.compareTo("Quit") == 0) )
      {
        input = "q";
      }
    }
    sc.close();
    */
    
    
    
    
    
  } // end Main method
  
  
}// end class
