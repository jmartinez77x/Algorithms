
//Joe Martinez
//Maximum Subsequence Product
//Source Code

/*
This program is an example of the divide and conquer method and will take an array and divide 
it into smaller sub problems which will find the maximum product of each sub problem which 
will in turn find the maxiumum product of the entire 
set of integers. 

Input: An array of integers.
Output: The maximum product of the subsequence and its start and end indexes. 
*/

class MaxSeqProduct{
	//START MAIN METHOD
	public static void main(String[] args){
		int [] A = {4, -3, 5, -2, 1, 2, 6, -2};		    //SHOULD RETURN 1440, START = 0, END = 6			//3 NEGATIVES SPREAD OUT
		//int [] A = {-2, -2, 2, 3, 1, 1, 1, 1}; 		//SHOULD RETURN 24, START = 0, END = 3				//ONLY LEFT SIDE
		//int [] A = {0, 0, 1, 1, 1, -2, -3, -4}; 		//SHOULD RETURN 24, START = 0, END = 3				//ONLY RIGHT SIDE
		//int [] A = {2, 2, 2, 2, 2, 2, 2, 2}; 			//SHOULD RETURN 512, START = 0, END = 7				//ALL TWOS

		System.out.println("maxSubSum = " + maxSubSum(A));

		maxSeqObject object = new maxSeqObject();
		MaxSeqProduct(A, 0, A.length, object);
		System.out.println("Start Index: " + object.start);
		System.out.println("End Index: " + object.end);
		System.out.println("Final Product: " + object.product);
	}
	//END MAIN METHOD

	//DYNAMIC SOLUTION
	public static int maxSubSum(int[] A){
		int maxSum = A[0];
		int curSum = A[0];
		for(int i = 1; i < A.length; i++){
			curSum += A[i];
			if(curSum > maxSum){
				maxSum = curSum;
			}
			else{
				if(curSum < 0){
					curSum = A[++i];
				}
			}
		}
		return maxSum;
	}//END DYNAMIC SOLUTION

	//START MAXSEQOBJECT CLASS
	public static class maxSeqObject {	
		public String name; 	//ARRAY NAME 
		public int product;		//FINAL PRODUCT
		public int start;		//START INDEX
		public int end; 		//END INDEX
	}
	//END MAXSEQOBJECT CLASS
	
	//START MAXIMUM SUBSEQUENCE PRODUCT METHOD
	public static int MaxSeqProduct(int[] A, int start, int end, maxSeqObject object){
		//BASE CASE
		if(start == end){ return A[start];}
		
		int center = (start+end)/2; 
		int leftStart = center;
		int rightEnd  = center;
		int finalLeftProd = MaxSeqProduct(A, start, center, object); 
		int finalRightProd = MaxSeqProduct(A, center, end-1, object);

		//LEFT SIDE
		int leftProd = A[center];
		int maxLeftProd = A[center];
		int minLeftProd = A[center];
		for(int i = center-1; i >= start; i--){ 
			leftProd *= A[i];
			if(leftProd > maxLeftProd){ 	//FIND MAXIMUM PRODUCT 
				maxLeftProd = leftProd;
				leftStart = i; 				//ASSIGN LEFT INDEX
			}
			if(leftProd < maxLeftProd){
				minLeftProd = leftProd; 	//FINDS MINIMUM PRODUCT 
			}
		}

		//RIGHT SIDE
		int rightProd = A[center];
		int maxRightProd = A[center];
		int minRightProd = A[center];
		for(int i = center+1; i < end; i++){
			rightProd *= A[i];
			if(rightProd > maxRightProd){	//FINDS MAXIMUM PRODUCT 
				maxRightProd = rightProd;
				rightEnd = i; 				//ASSIGN RIGHT INDEX 
			}
			if(rightProd < maxRightProd){	//FINDS MINIMUM PRODUCT
				minRightProd = rightProd;
			}
		}

		//FIND MAX PRODUCT FROM POSITIVE OR NEGATIVE 
		int maxPosProduct = maxLeftProd*maxRightProd;
		int maxNegProduct = minLeftProd*minRightProd;
		
		//PRINT STATEMENTS FOR TESTING
		// System.out.println(leftStart+", "+ rightEnd);
		// System.out.println("maxPosProduct: "+ maxPosProduct);
		// System.out.println("maxNegProduct: "+ maxNegProduct);
		// System.out.println("maxRightProd: "+ maxRightProd);
		// System.out.println("maxLeftProd: "+ maxLeftProd);

		//OBJECT ASSIGNMENTS
		object.name = "A";
		object.product = Math.max(Math.max(maxPosProduct, maxNegProduct), Math.max(maxRightProd, maxLeftProd));
		object.start = leftStart;
		object.end = rightEnd;

		return(object.product);
	}
	//END MAXIMUM SUBSEQUENCE PRODUCT METHOD
}