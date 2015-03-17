
//Joe Martinez
//AVL Tree vs Red-Black Tree
//AVL Tree class file

/*
This file is used by AVL_RBTrees.java to create
and maintain an AVL Tree.
*/

public class AVLTree<T extends Comparable<? super T>>{

	//CREATE OBJECT 
	public AVLNode<T> root;

	public AVLTree(){ root = null; }

	public static class AVLNode<T> {
		public T element;			//Node
		public AVLNode<T> left;		//left child
		public AVLNode<T> right;	//right child
		public int height; 

		public AVLNode (T avlRoot){
			this(avlRoot, null, null);
		}	

		public AVLNode(T avlRoot, AVLNode<T> l, AVLNode<T> r){
			element = avlRoot;
			left = l;
			right = r;
		}
	}//END CREATE OBJECT


	//FIND HEIGHT
	public int height(AVLNode<T> t){
		if(t == null){
			return -1;
		}
		return t.height;
		//return t == null ? -1 : t.height;
	}

	//FIND MAX HEIGHT
	public int max(int a, int b){
		if(a > b){
			return a;
		}else{
			return b; 
		}
	}

	//PRE INSERT 
	public boolean insert(T x){
		try{
			root = insert(root, x);
			return true;
		}
		catch(Exception e){
			return false; 
		}
	}

	//MAIN INSERT 
	public AVLNode<T> insert(AVLNode<T> t, T x) throws Exception{
		//IF DUPLICATE
		if(x.compareTo(t.element) == 0){
			throw new Exception("Duplicate");
		}
		//IF NULL
		if(t == null){
			t = new AVLNode<T>(x);
		}
		//IF LESS THAN 
		else if(x.compareTo(t.element) < 0){
			t.left = insert(t.left, x);
		
			if(height(t.left) - height(t.right) == 2){
				if(x.compareTo(t.left.element) < 0){
					t = singleWithLeft(t);
				}
				else{
					t = doubleWithLeft(t);
				}
			}
		}
		//IF GREATER THAN
		else if(x.compareTo(t.element) > 0){
			t.right = insert(t.right, x);
	
			if(height(t.right) - height(t.left) == 2){
				if(x.compareTo(t.right.element) > 0){
					t = singleWithRight(t);
				}
				else{
					t = doubleWithRight(t);
				}
			}
		}
		//UPDATE HEIGHT AND RETURN
		t.height = max(height(t.left), height(t.right)) + 1;
		return t; 
	}


	//SINGLE ROTATION WITH LEFT
	public AVLNode<T> singleWithLeft(AVLNode<T> k2){
		AVLNode<T> k1 = k2.right;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right)) +1;
		k1.height = max(height(k1.left), k2.height) +1;

		return k1;
	}

	//DOUBLE ROTATION WITH LEFT
	public AVLNode<T> doubleWithLeft(AVLNode<T> k3){
		k3.left = singleWithRight(k3.left);
		return singleWithLeft(k3);
	}

	//SINGLE ROTATION WITH RIGHT
	public AVLNode<T> singleWithRight(AVLNode<T> k1){
		AVLNode<T> k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right)) +1;
		k2.height = max(height(k2.right), k1.height) +1;

		return k2;
	}

	//DOUBLE ROTATION WITH RIGHT
	public AVLNode<T> doubleWithRight(AVLNode<T> k1){
		k1.right = singleWithLeft(k1.right);
		return singleWithRight(k1);
	}

	/*
	public static void printTree(){
		// System.out.println("Test");
		printTree(root);
	}
	
	public static void printTree(AVLNode<T> t){
		System.out.println("Test");
	// 	if(t != null){
	// 		printTree(t.left);
	// 		System.out.print(t.element + " ");
	// 		printTree(t.right);
	// 	}
	}*/
}