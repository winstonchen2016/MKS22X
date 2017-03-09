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
	    ArrayList<int> lines = new ArrayList<String>();
	}catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path.");
	    System.exit(1);
	}
	return 0;
    }

    public static void main(String[]args){
	System.out.println(bronze("makelake.in"));
    }

}
