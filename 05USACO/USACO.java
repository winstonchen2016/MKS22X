import java.util.*;
import java.io.*;

public class USACO{
    
    public USACO(){};

    public static int bronze(String filename){
	int[][] lake;
	int numRows;
	int numCols;
	int finalHeight;
	int numMoves;
	int vol = 0;
	ArrayList<String> lines = new ArrayList<String>();
	try{
	    File text = new File(filename); 
	    Scanner inf = new Scanner(text);
	    while(inf.hasNext()){
		lines.add(inf.next());
	    }
	    numRows = Integer.parseInt(lines.get(0));
	    lines.remove(0);
	    numCols = Integer.parseInt(lines.get(0));
	    lines.remove(0);
	    finalHeight = Integer.parseInt(lines.get(0));
	    lines.remove(0);
	    numMoves = Integer.parseInt(lines.get(0));
	    lines.remove(0);
	    //System.out.println(numRows);
	    //System.out.println(numCols);
	    //System.out.println(finalHeight);
	    //System.out.println(numMoves);
	    lake = new int[numRows][numCols];
	    for(int r = 0; r < numRows; r++){
		for(int c = 0; c < numCols; c++){
		    lake[r][c] = Integer.parseInt(lines.get(0));
		    lines.remove(0);
		}
	    }
	    //System.out.println(toString(lake));
	    for(int i = 0; i < numMoves; i ++){
		int r = Integer.parseInt(lines.get(0));
		lines.remove(0);
		int c = Integer.parseInt(lines.get(0));
		lines.remove(0);
		int d = Integer.parseInt(lines.get(0));
		lines.remove(0);
		bronzeH(lake, r - 1, c - 1, d);
		//System.out.println(toString(lake));
	    }
	    for(int r = 0; r < numRows; r++){
		for(int c = 0; c < numCols; c++){
		    if(lake[r][c] < finalHeight){
			vol += finalHeight - lake[r][c];
		    }
		}
	    }
	}catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path.");
	    System.exit(1);
	}
	return vol * 72 * 72;
    }

    private static void bronzeH(int[][] l, int row, int col, int depth){
	//System.out.println(row + " " + col + " " + depth);
	int max = l[row][col];
	for(int r = row; r <= row + 2; r++){
	    for(int c = col; c <= col + 2; c++){
		//System.out.println(r + " " + c);
		if(l[r][c] > max){
		    max = l[r][c];
		}
	    }
	}
	for(int r = row; r <= row + 2; r++){
	    for(int c = col; c <= col + 2; c++){
		if(l[r][c] > max - depth){
		    l[r][c] = max - depth;
		}
	    }
	}
    }

    public int silver(String filename){
	int[][] pasture;
	int numRows;
	int numCols;
	int time;
	int startRow;
	int startCol;
	int endRow;
	int endCol;
	int numSolns = -1;
	ArrayList<String> lines = new ArrayList<String>();
	try{
	    File text = new File(filename); 
	    Scanner inf = new Scanner(text);
	    while(inf.hasNext()){
		lines.add(inf.next());
	    }
	    numRows = Integer.parseInt(lines.get(0));
	    lines.remove(0);
	    numCols = Integer.parseInt(lines.get(0));
	    lines.remove(0);
	    time = Integer.parseInt(lines.get(0));
	    lines.remove(0);
	    pasture = new int[numRows][numCols];
	    for(int r = 0; r < numRows; r++){
		for(int c = 0; c < numCols; c++){
		    if(lines.get(0).charAt(c) == '*'){
			pasture[r][c] = -1;
		    }
		    else{
			 pasture[r][c] = 0;
		    }	
		}
		lines.remove(0);
	    }
	    startRow = Integer.parseInt(lines.get(0)) - 1;
	    lines.remove(0);
	    startCol = Integer.parseInt(lines.get(0)) - 1;
	    lines.remove(0);
	    endRow = Integer.parseInt(lines.get(0)) - 1;
	    lines.remove(0);
	    endCol = Integer.parseInt(lines.get(0)) - 1;
	    lines.remove(0);
	    /*System.out.println(numRows);
	    System.out.println(numCols);
	    System.out.println(time);
	    System.out.println(startRow);
	    System.out.println(startCol);
	    System.out.println(endRow);
	    System.out.println(endCol);
	    */
	    pasture[startRow][startCol] = 1;
	    //System.out.println(toString(pasture));
	    numSolns = silverH(pasture, pasture, endRow, endCol, time);
	}catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path.");
	    System.exit(1);
	}
	return numSolns;
    }

    private static int silverH(int[][] old, int[][] n, int er, int ec, int t){
	if (t == 0) {
	    return old[er][ec] + n[er][ec];
	}
	n = reset(old);
	//System.out.println(toString(old));
	//System.out.println(toString(n));
	for(int r = 0; r < old.length; r++){
	    for(int c = 0; c < old[r].length; c++){
		if(old[r][c] > 0){
		    if(validIndex(n, r + 1, c) && n[r+1][c] != -1){
			n[r+1][c] += old[r][c];
		    }
		    if(validIndex(n, r - 1, c) && n[r-1][c] != -1){
			n[r-1][c] += old[r][c];
		    }
		    if(validIndex(n, r, c + 1) && n[r][c+1] != -1){
			n[r][c+1] += old[r][c];
		    }
		    if(validIndex(n, r, c - 1) && n[r][c-1] != -1){
			n[r][c-1] += old[r][c];
		    }
		}
	    }
	}
	//System.out.println(toString(n));
	return silverH(n, reset(old), er, ec, t - 1);
    }

    private static boolean validIndex(int[][] ar, int row, int col){
	return row >= 0 && col >= 0 && row < ar.length && col < ar[0].length;
    }

    private static int[][] reset(int[][] ar){
	int[][] ans = new int[ar.length][ar[0].length];
	for(int r = 0; r < ans.length; r++){
	    for(int c = 0; c < ans[0].length; c++){
		if(ar[r][c] == -1){
		    ans[r][c] = -1;
		}
		else{
		    ans[r][c] = 0;
		}
	    }
	}
	return ans;
    }
    
    private static String toString(int[][] a){
	String ans = "";
    	for(int r = 0; r < a.length; r++){
    	    for(int c = 0; c < a[0].length; c++){
		ans = ans + a[r][c] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
	USACO a = new USACO();
	/*System.out.println(a.bronze("makelake1.in"));
	System.out.println(342144);
	System.out.println(a.bronze("makelake2.in"));
	System.out.println(102762432);
	System.out.println(a.bronze("makelake3.in"));
	System.out.println(1058992704);
	System.out.println(a.bronze("makelake4.in"));
	System.out.println(753121152);
	System.out.println(a.bronze("makelake5.in"));
	System.out.println(1028282688);
	System.out.println(a.bronze("makelake6.in"));
	System.out.println(72207936);
	System.out.println(a.bronze("makelake7.in"));
	System.out.println(265508928);
	System.out.println(a.bronze("makelake8.in"));
	System.out.println(776609856);
	System.out.println(a.bronze("makelake9.in"));
	System.out.println(2098830528);
	System.out.println(a.bronze("makelake10.in"));
	System.out.println(211201344);
	*/
	System.out.println(a.silver("ctravel1.in"));
    }

}
