public class USACO{

    private int[][] lake;
    private int numRows;
    private int numCols;
    private int finalHeight;
    
    public int bronze(String filename){
	ArrayList<int> lines = new ArrayList<int>();
	try{
	    File text = new File(filename); 
	    Scanner inf = new Scanner(text);
	    while(inf.hasNextLine()){
		lines.add(Integer.parseInt(inf.nextLine()));
	    }
	    
	}catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path.");
	    System.exit(1);
	}
    }

    public static void main(String[]args){
	USACO f;
	System.out.println(f.bronze("makelake.in"));
    }

}
