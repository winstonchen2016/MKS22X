public class QueenBoard{

    private int[][]board;
    private int[][]solution;
    private int solutionCount;

    public QueenBoard(int size){
	if(size <= 0){
	    throw new IllegalArgumentException("Please input a non-negative number.");
	}
	board = new int[size][size];
	solution = new int[size][size];
	solutionCount = -1;
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[r].length; c++){
		board[r][c] = 0;
	    }
	}
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
    public void solve(){
	//clears board
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[r].length; c++){
		board[r][c] = 0;
	    }
	}
	solveH(0);
    }

    private boolean solveH(int col){
	if(board.length == 2 || board.length == 3){
	    return false;
	}
	if(col >= board.length){ //means a queen has been placed in every column (aka solution is found)
	    //copy board onto solution
	    for(int c = 0; c < board.length; c++){
		for(int r = 0; r < board[c].length; r++){
		    solution[r][c] = board[r][c];
		}
	    }
	    return true;
	}
	//loop though rows
	for(int row = 0; row < board[col].length; row ++){
	    if(board[row][col] == 0){
		addQueen(row, col);
		//System.out.println(col);
		//System.out.println(toStringT());
		if(solveH(col + 1)){
		    return true;
		}
		else{
		    removeQueen(row, col);
		}
	    }
	}
	return false;
    }
    
    public void countSolutions(){
	solutionCount = 0;
	//clears board
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[r].length; c++){
		board[r][c] = 0;
	    }
	}
	//System.out.println(toStringT());
	countSolutionsH(0);
    }
	
    public boolean countSolutionsH(int col){
	if(board.length == 2 || board.length == 3){
	    return false;
	}
	if(col >= board.length){ //means a queen has been placed in every column (aka solution is found)
	    return true;
	}
	//loop though rows
	for(int row = 0; row < board[col].length; row ++){
	    if(board[row][col] == 0){
		//System.out.println(col);
		//System.out.println(toStringT());
		addQueen(row, col);
		//System.out.println(col);
		//System.out.println(toStringT());
		if(countSolutionsH(col + 1)){
		    solutionCount += 1;
		    removeQueen(row, col);
		}
		else{
		    removeQueen(row, col);
		}
	    }
	}
	return false;
    }
    
    private void addQueen(int r, int c){
	board[r][c] = -1; //places a queen on square r, c (sets value to -1)
	//loops through array board and adds "1" to spaces threatened by the queen on r, c (excludes spaces with queens)
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		if(board[row][col] != -1 && (row - r == 0 || col - c == 0 || Math.abs(row - r) == Math.abs(col - c))){
		    board[row][col] += 1;
		}
	    }
	}
    }
	
    private void removeQueen(int r, int c){
	//loops through array board and subtracts "1" from spaces threatened by the queen on r, c (excludes r, c b/c queens can't threaten tehmselves)
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		if(board[row][col] != -1 && (row - r == 0 || col - c == 0 || Math.abs(row - r) == Math.abs(col - c))){
		    board[row][col] -= 1;
		}
	    }
	}
	board[r][c] = 0; //removes a queen on square r, c (sets value to 0)
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */

    public int getSolutionCount(){
	return solutionCount;
    }

    /**toString
     *and all numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	//loop through solution array
	//replace -1 with q
	//replace everything else with
	String ans = "";
	for(int row = 0; row < solution.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		if(solution[row][col] == -1){
		    ans += "Q ";
		}
		else{
		    ans += "_ ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
    /*
    public void addQueenT(int r, int c){
	board[r][c] = -1; //places a queen on square r, c (sets value to -1)
	//loops through array board and adds "1" to spaces threatened by the queen on r, c (excludes spaces with queens)
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		if(board[row][col] != -1 && (row - r == 0 || col - c == 0 || Math.abs(row - r) == Math.abs(col - c))){
		    board[row][col] += 1;
		}
	    }
	}
    }

    public void removeQueenT(int r, int c){
	//loops through array board and adds "1" to spaces threatened by the queen on r, c (excludes spaces with queens)
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		if(board[row][col] != -1 && (row - r == 0 || col - c == 0 || Math.abs(row - r) == Math.abs(col - c))){
		    board[row][col] -= 1;
		}
	    }
	}
	board[r][c] = 0; //places a queen on square r, c (sets value to -1)
    }
    
    public String toStringT(){
	//loop through solution array
	//replace -1 with q
	//replace everything else with
	String ans = "";
	for(int row = 0; row < solution.length; row++){
	    for(int col = 0; col < board[row].length; col++){
	        ans = ans + board[row][col] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    */
    public static void main(String[]args){
	QueenBoard q0 = new QueenBoard(0); //exception
	
	QueenBoard q1 = new QueenBoard(1);
	System.out.println(q1.toString()); //blank grid
        q1.solve();
	System.out.println(q1.toString()); //possible solution
	System.out.println(q1.getSolutionCount()); // -1
	q1.countSolutions();
	System.out.println(q1.getSolutionCount()); // 1
	
	QueenBoard q2 = new QueenBoard(2);
	System.out.println(q2.toString()); //blank grid
	q2.solve();
	System.out.println(q2.toString()); //still blank grid
	System.out.println(q2.getSolutionCount()); // -1
	q2.countSolutions();
	System.out.println(q2.getSolutionCount()); // 0
	
	QueenBoard q3 = new QueenBoard(3);
	System.out.println(q3.toString()); //blank grid
	q3.solve();
	System.out.println(q3.toString()); //still blank grid
	System.out.println(q3.getSolutionCount()); // -1
	q3.countSolutions();
	System.out.println(q3.getSolutionCount()); // 0
	
	QueenBoard q4 = new QueenBoard(4);
	System.out.println(q4.toString()); //blank grid
	q4.solve();
	System.out.println(q4.toString()); //possible solution
	System.out.println(q4.getSolutionCount()); // -1
	q4.countSolutions();
	System.out.println(q4.getSolutionCount()); // 2
	
	QueenBoard q5 = new QueenBoard(5);
	System.out.println(q5.toString()); //blank grid
	q5.solve();
	System.out.println(q5.toString()); //possible solution
	System.out.println(q5.getSolutionCount()); // -1
	q5.countSolutions();
	System.out.println(q5.getSolutionCount()); // 10

	QueenBoard q8 = new QueenBoard(8);
	System.out.println(q8.toString()); //blank grid
	q8.solve();
	System.out.println(q8.toString()); //possible solution
	System.out.println(q8.getSolutionCount()); // -1
	q8.countSolutions();
	System.out.println(q8.getSolutionCount()); // 92

	QueenBoard q10 = new QueenBoard(10);
	System.out.println(q10.toString()); //blank grid
	q10.solve();
	System.out.println(q10.toString()); //possible solution
	System.out.println(q10.getSolutionCount()); // -1
	q10.countSolutions();
	System.out.println(q10.getSolutionCount()); // 724
    }
}
