// File: BinarySearchTree.java

/******************************************************************************
* An <CODE>BinarySearchTree</CODE> is a collection of int numbers & a BINARY SEARCH TREE
* <dl><dt><b>Limitations:</b> <dd>
*   Beyond <CODE>Integer.MAX_VALUE</CODE> elements, <CODE>countOccurrences</CODE>,
*   and <CODE>size</CODE> are wrong.
*
******************************************************************************/
public class BinarySearchTree implements Cloneable
{
   // Invariant of the BinarySearchTree class:
   //   1. The elements in the bag are stored in a binary search tree.
   //   2. The instance variable root is a reference to the root of the
   //      binary search tree (or null for an empty tree).
   private BinaryTreeNode root;

   // Constructor: create an empty tree with an empty root
   BinarySearchTree()
   {
      root = null;
    }

   // Change or set ROOT of the tree to a given node(newroot)
   public void setRoot(BinaryTreeNode newroot)
   {
      root = newroot;
    }

   // Get or return the ROOT of the tree
   public BinaryTreeNode getRoot()
   {
      return root;
    }

   /**
   * ADD or Insert a new node (element) into this TREE
   **/
   public void add(int element)
   {
      BinaryTreeNode curr = root;
      if(curr == null)
         curr = root = new BinaryTreeNode(element,null,null);
      else
      {
	      while(true)
	      {
	         if(element<=curr.getData())
	         {
	            if(curr.getLeft()==null)
	            {
	               curr.setLeft(new BinaryTreeNode(element,null,null));
	               break;
	            }
	            else
	               curr = curr.getLeft();
	         }
	         else
	         {
	            if(curr.getRight()==null)
	            {
	               curr.setRight(new BinaryTreeNode(element,null,null));
	               break;
	            }
	            else
	               curr = curr.getRight();
	         }
	      	}
      	}
   }




   /**
   * Add the contents of another tree to this tree.
   * @param <CODE>addend</CODE>
   *   a tree whose contents will be added to this tree
   * <dt><b>Precondition:</b><dd>
   *   The parameter, <CODE>addend</CODE>, is not null.
   * <dt><b>Postcondition:</b><dd>
   *   The elements from <CODE>addend</CODE> have been added to this tree.
   * @exception IllegalArgumentException
   *   Indicates that <CODE>addend</CODE> is null.
   **/
   public void addAll(BinarySearchTree addend)
   {
	   BinaryTreeNode addroot;
	   if(root == addend.root){
		   addroot = BinaryTreeNode.treeCopy(addend.root);
		   addTree(addroot);
	   }
	   else{
		   addTree(addend.root);
	   }
   }


   /**
   * Add the contents of another binary search tree to this tree.
   * @param <CODE>addroot</CODE>
   *   the root of a binary search tree whose contents will be added to this tree
   * <dt><b>Postcondition:</b><dd>
   *   The elements from the binary search tree specified by
   *   <CODE>addroot</CODE> have been added to this tree.
   **/
   private void addTree(BinaryTreeNode addroot)
   {
	   if(addroot != null){
		   add(addroot.getData());

			   addTree(addroot.getLeft());

			   addTree(addroot.getRight());

	   }
   }


   /**
   * FREQUENCY: Count the number of occurrences of a particular DATA(target) in this tree.
   * @param <CODE>target</CODE>: the element that needs to be counted
   * @return: the number of times that <CODE>target</CODE> occurs in this tree
   **/
   public long countOccurrences(int target)
   {
	   long count = 0;
	   BinaryTreeNode cursor = root;
	  while(cursor!=null){
		  if(target == cursor.getData()){
			  count++;
			  cursor = cursor.getLeft();
		  }
		  else if(target > cursor.getData()){
			  cursor = cursor.getRight();
		  }
		  else{
			  cursor = cursor.getLeft();
		  }

	  }
	return count;

   }


   /**
   * REMOVE a node which has its DATA = target in this tree.
   * @param <CODE>target</CODE>: the data of the node to be removed from the tree
   * <b>Postcondition:</b>: If "target" was found in the tree, then the node containing "target" is
   * removed and the method returns true. If no "target" is found then the method returns false.
   **/

   public boolean remove(int target)
   {
	   BinaryTreeNode cursor = root;
	   BinaryTreeNode parent = null;

	   if(root == null){
		   return false;
	   }
	   else{
		   while(cursor!=null && cursor.getData() != target){
			   parent = cursor;
			   if(cursor.getData() > target){

				   cursor = cursor.getLeft();

			   }
			   else {

				   cursor = cursor.getRight();

			   }
		   }
		  if(cursor.getData() == target){
		   if(cursor ==  root){
			   if(cursor.getLeft() == null){
				   root = root.getRight();

			   }
			   else{
				   cursor.setData(cursor.getLeft().getRightmostData());
				   cursor.setLeft(cursor.getLeft().removeRightmost());
			   }
		   }

		   if(cursor.getLeft() == null){
			   if(cursor == parent.getLeft()){
				   parent.setLeft(cursor.getRight());

			   }
			   else{
				   parent.setRight(cursor.getRight());

			   }
		   }
		   else{
			   cursor.setData(cursor.getLeft().getRightmostData());
			   cursor.setLeft(cursor.getLeft().removeRightmost());

		   }
		   return true;
		  }
		 }
	return false;


   }


   /**
   * Determine the SIZE of the tree or the number of nodes in this tree USING the size method in BinaryTreeNode
   * @param - none
   * @return : the number of elements in this tree
   **/
//   public int size( )
//   {
//      return 0;
//   }

}
