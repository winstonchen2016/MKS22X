public class KnightBoard{

    private int[][] board;
    private int[][] moves;
    private static final int[] rowChoices = {2, 2, -2, -2, 1, 1, -1, -1};
    private static final int[] colChoices = {1, -1, 1, -1, 2, -2, 2, -2};

    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows][startingCols];
	moves = new int[startingRows][startingCols];
	for(int r = 0; i < moves.length; r++){
	    
    }

    public String toString(){ //blank if you never called solve or when there is no solution
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[r].length; c++){
		if(board[r][c] < 10){
		    ans = ans + " " + board[r][c] + " ";
		}
		else{
		    ans = ans + board[r][c] + " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    public void solve(){
	solveH(0, 0, 1);
    }

    private boolean solveH(int row, int col, int level){ // level is the # of the knight
	//System.out.println("Currently at: Row: " + row + " Col: " + col + " Lvl: " + level);
	//System.out.println(toString());
	if(level >= board.length * board[0].length){
	    board[row][col] = level;
	    return true;
	}
	for(int i = 0; i < rowChoices.length; i++){
	    if(row + rowChoices[i] < board.length && row + rowChoices[i] >= 0 && col + colChoices[i] < board[0].length && col + colChoices[i] >= 0 && board[row+rowChoices[i]][col+colChoices[i]] == 0){
		board[row][col] = level;
		if(solveH(row + rowChoices[i], col + colChoices[i], level + 1)){
		    return true;
		}else{
		    board[row][col] = 0;
		}
	    }
	}
 	return false;
    }

    public void solveFast(){
	solveFastH(0, 0, 1);
    }

    private boolean solveFastH(int row, int col, int level){
	return false;
    }

    public static void main(String[]args){
	KnightBoard n55 = new KnightBoard(5, 5);
	//System.out.println(n55.toString());
	n55.solve();
	System.out.println(n55.toString());
	KnightBoard n66 = new KnightBoard(6, 6);
	n66.solve();
	System.out.println(n66.toString());
	KnightBoard n11 = new KnightBoard(1, 1);
	n11.solve();
	System.out.println(n11.toString());
	KnightBoard n93 = new KnightBoard(9, 3);
	n93.solve();
	System.out.println(n93.toString());
	KnightBoard n44 = new KnightBoard(4, 4);
	n44.solve();
	System.out.println(n44.toString()); //no solution, should print blank board
	KnightBoard n77 = new KnightBoard(7, 7);
	n77.solve();
	System.out.println(n77.toString());
    }
}
