
//Joe Martinez
//Coin change problem
//SOURCE CODE

/*
THIS PROGRAM USES DYNAMIC PROGRAMMING TO SOLVE THE COIN CHANGE PROBLEM.
WITH A GIVE VARIABLE "c" AMOUNT OF CHANGE IT WILL DETERMINE THE MINIMUM AMOUNT
OF COINS TO RETURN ACCORDING THE PARAMETERS SET IN THE DENOM ARRAY. 
*/

import java.util.*;

class coinChange{
	public static void main(String[] args){
		int c = 12; 		//AMOUNT OF CHANGE TO BE MADE
		int opt1 = 0;		//OPTION 1 TO RETURN
		int opt2 = 0;		//OPTINO 2 TO RETURN

		int denom[] = {10, 6, 1};					//DENOMINATIONS USED TO MAKE CHANGE
		//int denom[] = {25, 10, 5, 1};
		int [][] C = new int[denom.length][c+1];	//TABLE TO HOLD DATA


		//FILL LAST ROW OF TABLE WITH HOW MANY PENNIES IT WILL TAKE TO MAKE CHANGE
		for(int j = 0; j < c + 1; j++){
            C[denom.length-1][j] = j;
        }

        //FILL IN REST OF TABLE FROM ROW 1 TO ROW 0 
		for(int i = denom.length - 2; i >= 0; i--){
			for(int j = 0; j < c+1; j++){
                if (denom[i] > j || C[i+1][j] < (1 + C[i][j - denom[i]])){
                    C[i][j] = C[i + 1][j];
                    opt1 = C[i][j];

                }
                else{
                    C[i][j] = 1 + C[i][j - denom[i]];
                    opt2 = C[i][j];
                }
			}
		}

		//PRINT TABLE
        for(int i = 0; i <= denom.length-1; i++){
            System.out.print(i + " | ");
            for(int j = 0; j < c+1; j++){
                if(j >= 10 && i < 2){ System.out.print(C[i][j] + "  "); }
                else{ System.out.print(C[i][j] + " "); }
            }
            System.out.print("\n");
        }//END PRINT TABLE

		System.out.println("Minimum dynamic option = " + Math.min(opt1,opt2));

		//Greedy_coin_change(denom, c);
		//dynamicSubStr();
	}//END MAIN


	//BEGIN GREEDY COIN 
	public static void Greedy_coin_change(int[] denom, int A){ 
		int i = 1;
		while (A > 0) {
			int c = A/denom[i];
			System.out.println("Greedy solution: " + c + " coins of denomination " + denom[i]);
			A = A - c * denom[i];
			i = i + 1;
		} 
	}//END GREEDY COIN


	//BEGIN DYNAMIC SUBSTRING
	public static void dynamicSubStr(){
		int maxLen = 0;
		String aloha[] = {"a", "l", "o", "h", "a"};
		String hello[] = {"h", "e", "l", "l", "o"};
		int [][] L = new int[hello.length + 1][aloha.length + 1];
		
		for(int row = 1; row <= hello.length; row++){
			for(int col = 1; col <= aloha.length; col++){
				if(aloha[row -1] == hello[col -1]){
					if(row == 1 || col == 1){
						L[row][col] = 1;
					}
					else{
						L[row][col] = 1 + L[row-1][col-1];
					}
					if(L[row][col] > maxLen){
						maxLen = L[row][col];
					}
				}
			}
		}
		System.out.println("Length of max sub-string between " + 
			Arrays.toString(aloha) + " and " + Arrays.toString(hello) + " is " + maxLen);
	}//END DYNAMIC SUB STRING

}//END COIN CHANGE CLASS