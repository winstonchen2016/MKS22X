public class KnightBoard{

    private int[][] board;

    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows][startingCols];
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

    private boolean solveH(int row ,int col, int level){ // level is the # of the knight
	if(level >= board.length * board[0].length){
	    return true;
	}
	//for
	return false;
    }

    public static void main(String[]args){
	KnightBoard n33 = new KnightBoard(3, 3);
	System.out.println(n33.toString());
    }
}
