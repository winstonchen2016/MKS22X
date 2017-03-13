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
	    System.out.println(numRows);
	    System.out.println(numCols);
	    System.out.println(finalHeight);
	    System.out.println(numMoves);
	    lake = new int[numRows][numCols];
	    for(int r = 0; r < numRows; r++){
		for(int c = 0; c < numCols; c++){
		    lake[r][c] = Integer.parseInt(lines.get(0));
		    lines.remove(0);
		}
	    }
	    for(int i = 0; i <= numMoves; i += 3){
		int r = Integer.parseInt(lines.get(0));
		lines.remove(0);
		int c = Integer.parseInt(lines.get(0));
		lines.remove(0);
		int d = Integer.parseInt(lines.get(0));
		lines.remove(0);
		bronzeH(lake, r - 1, c - 1, d);
	    }
	    for(int r = 0; r < numRows; r++){
		for(int c = 0; c < numCols; c++){
		    if(lake[r][c] > finalHeight){
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
	//	System.out.println(l.toString());
	System.out.println(row + " " + col + " ");
	int max = l[row][col];
	for(int r = row; r < r + 2; r++){
	    for(int c = col; c < c + 2; c++){
		if(l[r][c] > max){
		    max = l[r][c];
		}
	    }
	}
	for(int r = row; r < r + 2; r++){
	    for(int c = col; c < c + 2; c++){
		if(l[r][c] > max - depth){
		    l[r][c] = max - depth;
		}
	    }
	}
    }

    //private String toString(int[][] a){
    //	for(int r = 0; r < a.length; r++){
    //	    for(int c = 0; c < a[0].length(); c++){
    
    public static void main(String[]args){
	USACO a = new USACO();
	System.out.println(a.bronze("makelake.in"));
    }

}
