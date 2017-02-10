public class QueenBoard{

    private int[][]board;
    private int[][]solution;
    private int solutionCount;

    public QueenBoard(int size){
	if(size <= 0){
	    throw IllegalArgumentException("Please input a non-negative number.");
	}
	board = new int[size][size];
	solution = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve(){
	return solveH(0);
    }

    private boolean solveH(int col){
	if(col > board.length){ //means a queen has been placed in every column (aka solution is found)
	    //copy board onto solution
	    for(int c = 0; c < board.size; c++){
		for(int r = 0, r < c.size; r++){
		    solution[r][c] = board[r][c];
		}
	    }
	    return true;
	}
	//loop though rows
	for(int row = 0; row < col.length; row ++){
	    if(board[row][col] == 0){
		addQueen(row, col);
		if(!solveH(col + 1)){
		    removeQueen(row, col);
		}
	    }
	}
	else{
	    return false;
	}
    }
    /*	
    public boolean countSolutions(){
	return countSolutionsH(0);
    }
	
    private boolean countSolutionsH(int col){
	if col > board size //means a queen has been placed in every column (aka solution is found)
		     removeQueen(r,c)
		     solutionCount += 1
		     return false
		     current row = 0
		     loop though rows
		     if(# at r,c == 0){
			 addQueen(r,c)
			 solveH(col + 1)
		     }
	if loop ends
		    return false;
    }
    */
    private void addQueen(r, c){
	board[r][c] = -1; //places a queen on square r, c (sets value to -1)
	//loops through array board and adds "1" to spaces threatened by the queen on r, c (excludes r, c b/c queens can't threaten themselves)
	for(int r = 0, r < board.length; r++){
	    
	}
    }
	
    private void removeQueen(r, c){
	removes a queen on square r, c (sets value to 0)
	loops through array board
		subtracts "1" to spaces threatened by the queen on r, c (excludes r, c b/c queens can't threaten tehmselves)
	    checks rows, columns, and diagonals
	    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */

    public int getSolutionCount(){
	if solution array is empty
			return -1
	    else
		return solutionCount;
    }

    /**toString
     *and all numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	loop through solution array
	    replace -1 with q
	    replace everything else with _
					return solution;
    }
}
