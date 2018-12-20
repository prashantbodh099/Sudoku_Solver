public class Sudoku_S {
	boolean valid(int num,int[][] prob,int r,int c){
   		int k;
    	int startr = (r - r%3);
   	 	int startc = (c - c%3);
    	for(k = 0;k < 9;k++){
        	if(prob[r][k] == num) {
            	return false;
        		}
       		 if(prob[k][c] == num){
            	return false;
        		}
   			 }
    	for(int l = 0;l < 3;l++) {
        	for(int m = 0;m < 3;m++){
            	if(prob[l + startr][m + startc] == num) {
                	return false;
           			 }
        		}
    		}
    return true;
		}

	boolean solver(int[][] prob, int n) { 
		int row = 0; 
		int col = 0; 
		boolean isEmpty = true; 
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 
				if (prob[i][j] == 0) { 
					row = i; 
					col = j; 
					isEmpty = false; 
					break; 
					} 
				} 
			if (!isEmpty) { 	// come out of the loop if u find a empty cell ,,,,,so now try to fill it
				break; 
				}
			} 
		if (isEmpty) { //it means nothing is left empty 
			return true; 
			} 
		for (int num = 1; num <= n; num++) { 
			if (valid(num,prob,row,col)) { 
				prob[row][col] = num; 
				if (solver(prob, n)) { 
					return true; 
					} 
				else{ 
					prob[row][col] = 0; 
					} 
				} 
			} 
		return false; 
		} 

	public static void main(String[] args) {
        Sudoku_S sud = new Sudoku_S();
        int i,j,k;
        int[][] sol;
        int[][] prob  = 
        {   {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
            {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        for(i = 0;i < 9;i++) {
            System.out.println(" ");
            for(j = 0;j < 9;j++) {
                    System.out.print(prob[i][j] + "|");
            }
        }
        if(sud.solver(prob,9)) {
         System.out.println("");
        for(i = 0;i < 9;i++) {
            System.out.println(" ");
            for(j = 0;j < 9;j++) {
                    System.out.print(prob[i][j] + "|");
                }
            }
        }
        else {
            System.out.println(" No solution Exists");
            }
    }
}	
