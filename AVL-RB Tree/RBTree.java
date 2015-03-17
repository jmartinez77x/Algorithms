
//Joe Martinez
//AVL Tree vs Red-Black Tree
//RB Tree class file

/*
This file is used by AVL_RBTrees.java to create 
and maintain a Red-Black Tree.
*/

public class RBTree<T extends Comparable<? super T>>{
	
	//GLOBAL COLOR VARIABLES
	public static final boolean RED   = true;
	public static final boolean BLACK = false;


	//CREATE OBJECT
	public RBNode<T> root;
	public static class RBNode<T>{
		public T element;		//NODE
		public RBNode<T> left;	//LEFT CHILD
		public RBNode<T> right;	//RIGHT CHILD
		public int height;		//HEIGHT OF NODE
		public boolean color; 
		
		public RBNode(T element, int height, boolean color){
			this.element = element;
			this.height  = height;
			this.color   = color; 
		}
	}//END OBJECT CREATION


	//RED-CHECK FUNCTION
	public  boolean isRed(RBNode<T> t){
		if(t == null){ return false; }
		return t.color == RED;
	}


	//COLOR-FLIP FUNCTION
	public void flipColor(RBNode<T> t){
		t.color =  RED;
		t.left.color = BLACK;
		t.right.color = BLACK;
	}


	//PRE HEIGHT-CHECK FUNCTION
	public int height(){
		return height(root);
	}

	//SECOND PART OF HEIGHT-CHECK FUNCTION
	public int height(RBNode<T> t){
		if(t == null){ return 0; }
		else{ return t.height; }
	}


	//PRE INSERT FUNCTION
	public void insert(T x){
		root = insert(x, root);
		root.color = BLACK;
	}

	//INSERT FUNCTION
	public RBNode<T> insert(T x,RBNode<T> t){	
		//CHECK NULL
		if(t == null){
			return new RBNode<T>(x, 1, RED);
		}
		//CHECK DUPLICATE
		if(x.compareTo(t.element) == 0){
			return t; 
		}	
		//CHECK LESS THAN
		if(x.compareTo(t.element) < 0){
			t.left = insert(x, t.left);
		}
		//CHECK GREATER THAN
		else if(x.compareTo(t.element) > 0){
			t.right = insert(x, t.right);
		}
		//CHECK RIGHT CHILD RED 
		if(isRed(t.right) && !isRed(t.left)){
			t = rotateWithLeft(t);
		}
		//CHECK TWO RED IN A ROW
		if(isRed(t.left) && isRed(t.left.left)){
			t = rotateWithRight(t);
		}
		//CHECK TWO RED CHILDREN
		if(isRed(t.left) && isRed(t.right)){
			flipColor(t);
		}
		//UPDATE HEIGHT AND RETURN
		t.height = height(t.left) + height(t.right) + 1;
		return t; 
	}


	//ROTATE WITH RIGHT CHILD
	public RBNode<T> rotateWithRight(RBNode<T> t){
		RBNode tmp = t.left;
		t.left = tmp.right;
		tmp.right = t;
		tmp.color = t.color;
		t.color = true; 
		tmp.height = t.height;
		tmp.height = 1 + height(t.left) + height(t.right);
		return tmp; 
	}


	//ROTATE WITH LEFT CHILD
	public RBNode<T> rotateWithLeft(RBNode<T> t){
		RBNode tmp = t.right;
		t.right = tmp.left;
		tmp.left = t;
		tmp.color = t.color;
		t.color = true;
		tmp.height = t.height;
		t.height = 1 + height(t.left) + height(t.right);
		return tmp; 
	}
}//END