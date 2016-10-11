// File: BinaryTreeTest.java

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**********************************************************************
* This class is a part of project #01;
**********************************************************************/
// use BinaryTreeNode, BinarySearchTree;

public class BinarySearchTree_TEST
{

    static BinaryTreeNode root;
	static BufferedWriter bw = null;
    static BufferedWriter bw1 = null;

	// READ the TREE from a TEXT File
     public static BinaryTreeNode ReadTreeFromTextFile(String FileName) throws IOException {

        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc;
        int x;
        String path = "C:\\Users\\User\\Desktop\\SUNY_Yash\\Suny sem 3\\Advanced Data Structure\\thakkary1-01\\";
         sc = new Scanner(new File(path+FileName));
         try
         {
             while(sc.hasNextInt())
             {
                 x = sc.nextInt();
                 System.out.println(x + "\n");
                 bst.add(x);

             }
         }
         catch(Exception e){
             System.out.println(e);
         }
         sc.close();
        return bst.getRoot();
    }

   // WRITE a tree NODE to a TEXT file
   // WRITE each node(data,left,right)of this tree(root in r)using Pre-order traversal, to a binary file(output)
    public static void WriteNodeToTextFile(BinaryTreeNode r, FileWriter output) throws IOException{
        if(r != null){
	    	output.write(Integer.toString(r.getData())+" ");

	        if(r.getLeft() != null){
	            WriteNodeToTextFile(r.getLeft(), output);
	        }
	        if(r.getRight() != null){
	            WriteNodeToTextFile(r.getRight(), output);
	        }
        }
    }

   // WRITE a TREE to a TEXT file
    public static void WriteTreeToTextFile(BinaryTreeNode r, String FileName) throws IOException{

            String path = "C:\\Users\\User\\Desktop\\SUNY_Yash\\Suny sem 3\\Advanced Data Structure\\thakkary1-01\\";
    		File file = new File(path+FileName);
    		FileWriter fw= new FileWriter(file);
            WriteNodeToTextFile(r, fw);
            fw.close();

    }

    public static void main(String[] args)throws IOException{

        File file ;
        BinaryTreeNode treeA,treeB, treeC, treeD;
        treeA = new BinaryTreeNode();
        treeB = new BinaryTreeNode();
        treeC = new BinaryTreeNode();
        treeD = new BinaryTreeNode();
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree bst1 = new BinarySearchTree();
        BinarySearchTree bst2 = new BinarySearchTree();
        String path = "C:\\Users\\User\\Desktop\\SUNY_Yash\\Suny sem 3\\Advanced Data Structure\\thakkary1-01\\";
        Scanner sc = new Scanner(new File(path+"treeC.txt")),
        		sc1 = new Scanner(System.in);




        // 1)INPUT/Read TreeA from a File
        System.out.println("1) Input (read) treeA from a text file:  \n");

        System.out.println("Reading a TREE from treeA.txt file: \n\n");

        treeA = ReadTreeFromTextFile("treeA.txt");

        // 2) OUTPUT/Display TreeA:
        System.out.println("2) Print treeA: \n\n");
        System.out.println("Inorder treeA");
        treeA.inorderPrint();
        System.out.println();
        System.out.println("Preorder treeA");
        treeA.preorderPrint();
        System.out.println();
        System.out.println("Postorder treeA");
        treeA.postorderPrint();
        System.out.println("\n\n");
        System.out.println("Display treeA: (with indentation) \n");
        treeA.print(10);

        // 3) INPUT/Read TreeB from a File
        System.out.println("3) Input (read) treeB from a text file: \n\n");
        System.out.println("Reading a TREE from treeB.txt file:");
        treeB = ReadTreeFromTextFile("treeB.txt");

        // 4) OUTPUT/Display TreeB:
        System.out.println("Display Tree B: \n");
        treeB.print(10);

        // 5) Add treeB to treeA
        bst.setRoot(treeA);
        bst1.setRoot(treeB);
        bst.addAll(bst1);
        treeC = bst.getRoot();
        System.out.println("5) The treeB has been added to treeA => tree C  \n\n Writing this tree to treeC.txt\n \n\n  writing treeC to a text file ...\n   Display treeC: \n");
        treeC.print(10);
        WriteTreeToTextFile(treeC, "treeC.txt");

        // 6) SEARCH for a NODE
        bst2.setRoot(treeC);
        System.out.println("6) Enter the Value of a node Z to SEARCH in treeC : \n");
        int search = sc1.nextInt();
        System.out.println(search + " has appeared "+ bst2.countOccurrences(search)+" times in Tree C.\n");


        // 7) Make a COPY of treeC
        BinaryTreeNode rootD = new BinaryTreeNode();
        treeD = BinaryTreeNode.treeCopy(treeC);
        System.out.println("7) Display treeD(a copy of treeC): ");
        treeD.print(10);
        rootD = treeD;
        // 8) define the SIZE of treeD

        System.out.println("Tree D's size : "+ BinaryTreeNode.treeSize(rootD));

        // 9) ADD a NODE

          System.out.println("9) Enter a Value X for the NEW node to be ADDED:  ");
          int insert = sc1.nextInt();
          //ins.setData(insert);
          //BinaryTreeNode ins = new BinaryTreeNode(insert, null, null);
//          file = new File(path+"treeC.txt");
//          FileWriter fw = new FileWriter(file,true);
//          WriteNodeToTextFile(new BinaryTreeNode(insert, null, null), fw);
//          fw.close();
          bst.add(insert);
          treeC = bst.getRoot();
          System.out.println("Display the NEW TreeC AFTER adding a the with X: ");
          treeC.print(10);

        // 10) REMOVE a NODE
          BinarySearchTree bst3 = new BinarySearchTree();
          bst3.setRoot(treeD);
          System.out.println("Remove node from TreeD : ");
          System.out.println("10) Enter the Value Y of the node to be REMOVED: ");
          int delete = sc1.nextInt();
          if(bst3.countOccurrences(delete)>0){
        	  System.out.println("Result of removing number : "+ delete +" is true.");
        	  bst3.remove(delete);
          }
          else{
        	  System.out.println("Result of removing number : "+delete+" is false.");
          }

          System.out.println("Display the NEW TreeD after removing the node : ");
          treeD = bst3.getRoot();
          treeD.print(10);
    }
}
