
//Joe Martinez
//AVL Tree vs Red-Black Tree
//AVL and RB Tree main java file

/*
Program creates 3 array of random numbers; one ascending, one descending, one random
It then inserts those numbers into empty AVL trees and RB trees 
The time it takes to insert the entire array is recorded and displayed at completion. 

Uses AVLTree.java and RBTree.java for creating trees/nodes and inserting/rotating
*/

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

class AVL_RBTrees{

	public static int arrSize  = 200; 	//SIZE OF ARRAY
	public static int rndRange = 200; 	//RANGE OF RANDOM NUMBERS
	
	public static ArrayList<Integer> ascArray = new ArrayList<>();
	public static ArrayList<Integer> desArray = new ArrayList<>();
	public static ArrayList<Integer> ranArray = new ArrayList<>();

	public static void main(String[] args) {

		//GENERATES AN ARRAY FROM 1 TO arrSize (IN ASCENDING ORDER)
		for(int i = 0; i < arrSize; i++){ ascArray.add(i); }

		//GENERATES AN ARRAY FROM arrSize TO 1 (IN DESCENDING ORDER)
		for(int i = arrSize; i > 0; i--){ desArray.add(i); }

		//GENERATES AN ARRAY FROM 1 TO arrSize (WITH RANDOM NUMBERS WITHIN rndRange)
		Random rand = new Random();
		for(int i = 0; i < arrSize; i++){		
			int n = rand.nextInt(rndRange) + 1;
			ranArray.add(n);
		}

		//INITIALIZE TIME KEEPING VARIABLES 
		long AVL_ascStart, AVL_desStart, AVL_ranStart, RB_ascStart, RB_desStart, RB_ranStart;
		long AVL_ascTime, AVL_desTime, AVL_ranTime, RB_ascTime, RB_desTime, RB_ranTime;


		//AVL_ascTree
		AVL_ascStart = System.currentTimeMillis();					//SET START TIME
		AVLTree<Integer> AVL_ascTree = new AVLTree<Integer>();		//INITIATE TREE OBJECT
		for(int i = 0; i < arrSize; i++){							//INSERT ARRAY INTO TREE
			AVL_ascTree.insert(ascArray.get(i));
		}
		AVL_ascTime = System.currentTimeMillis() - AVL_ascStart;	//SET TOTAL TIME

		//AVL_desTree
		AVL_desStart = System.currentTimeMillis();
		AVLTree<Integer> AVL_desTree = new AVLTree<Integer>();
		for(int i = 0; i < arrSize; i++){
			AVL_desTree.insert(desArray.get(i));
		}
		AVL_desTime = System.currentTimeMillis() - AVL_desStart;

		//AVL_ranTree
		AVL_ranStart = System.currentTimeMillis();
		AVLTree<Integer> AVL_ranTree = new AVLTree<Integer>();
		for(int i = 0; i < arrSize; i++){
			AVL_ranTree.insert(ranArray.get(i));
		}
		AVL_ranTime = System.currentTimeMillis() - AVL_ranStart;


		//RB_ascTree
		RB_ascStart = System.currentTimeMillis();
		RBTree<Integer>  RB_ascTree = new RBTree<Integer>();
		for(int i = 0; i < arrSize; i++){
			RB_ascTree.insert(ascArray.get(i));
		}
		RB_ascTime = System.currentTimeMillis() - RB_ascStart;	

		//RB_desTree
		RB_desStart = System.currentTimeMillis();
		RBTree<Integer>  RB_desTree = new RBTree<Integer>();
		for(int i = 0; i < arrSize; i++){	
			RB_desTree.insert(desArray.get(i));
		}
		RB_desTime = System.currentTimeMillis() - RB_desStart;

		//RB_ranTree
		RB_ranStart = System.currentTimeMillis();
		RBTree<Integer>  RB_ranTree = new RBTree<Integer>();
		for(int i = 0; i < arrSize; i++){
			RB_ranTree.insert(ranArray.get(i));
		}
		RB_ranTime = System.currentTimeMillis() - RB_ranStart;


		//OUTPUT OF TOTAL TIME FOR EACH TREE
		System.out.println("AVL ascending  time = " + AVL_ascTime + " milliseconds");
		System.out.println("AVL descending time = " + AVL_desTime + " milliseconds");
		System.out.println("AVL random     time = " + AVL_ranTime + " milliseconds");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("RB  ascending  time = " + RB_ascTime  + " milliseconds");
		System.out.println("RB  descending time = " + RB_desTime  + " milliseconds");
		System.out.println("RB  random     time = " + RB_ranTime  + " milliseconds");	

		//PRINT TREE
		//AVLTree.printTree();
		//RBTree.printTree();
	}
} 