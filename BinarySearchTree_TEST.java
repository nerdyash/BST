// File: BinaryTreeTest.java

import java.lang.*;
import java.io.*;
import java.util.Scanner;

/**********************************************************************
* This class is a part of project #01;
**********************************************************************/
// use BinaryTreeNode, BinarySearchTree;

public class BinarySearchTree_TEST
{

    static BinaryTreeNode root;
    static BinarySearchTree bst = new BinarySearchTree();
    static Scanner sc;
    // READ the TREE from a TEXT File
     public static BinaryTreeNode ReadTreeFromTextFile(String FileName) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader(FileName));
         sc = new Scanner(new File(FileName));
         try{
         while(sc.hasNextInt()){

             System.out.println(sc.nextInt());
            //  bst.add(sc.nextInt());
            //  bst.add(sc.nextInt());
     }
 }
     catch(Exception e){
         System.out.println(e);
     }
        return root;
    }

   // WRITE a tree NODE to a TEXT file
   // WRITE each node(data,left,right)of this tree(root in r)using Pre-order traversal, to a binary file(output)
    public static void WriteNodeToTextFile(BinaryTreeNode r, FileWriter output) throws IOException{

    }

   // WRITE a TREE to a TEXT file
    public static void WriteTreeToTextFile(BinaryTreeNode r, String FileName) throws IOException{

    }

    public static void main(String[] args)throws IOException{

        File file;
        BinaryTreeNode treeA,treeB, treeC, treeD;

        treeA = new BinaryTreeNode();
        treeB = new BinaryTreeNode();
        treeC = new BinaryTreeNode();
        treeD = new BinaryTreeNode();

        // 1)INPUT/Read TreeA from a File
        System.out.println("Tree A");

        treeA = ReadTreeFromTextFile("treeA.txt");
        while(sc.hasNextInt()){
        bst.add(sc.nextInt());
    }
        System.out.println("Root : "+ bst.getRoot());
        // 2) OUTPUT/Display TreeA:
        System.out.println("Inorder");
        treeA.inorderPrint();


        // 3) INPUT/Read TreeB from a File
        System.out.println("Tree B");
        ReadTreeFromTextFile("treeB.txt");

        // 4) OUTPUT/Display TreeB:


        // 5) Add treeB to treeA


        // 6) SEARCH for a NODE

        // 7) Make a COPY of treeC


        // 8) define the SIZE of treeD


        // 9) ADD a NODE


        // 10) REMOVE a NODE

    }
}
