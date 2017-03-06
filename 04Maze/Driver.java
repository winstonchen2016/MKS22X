public class Driver{

    public static void main(String[]args){
        Maze f;
        f = new Maze("data1.dat");
	
        f.setAnimate(true); //true animates the maze.
        f.solve();
	
        System.out.println(f);

	Maze g;
        g = new Maze("data2.dat");
	
        g.setAnimate(true); //true animates the maze.
        g.solve();
	
        System.out.println(g);
	
	Maze h;
        h = new Maze("data3.dat");
	
        h.setAnimate(true); //true animates the maze.
        h.solve();
	
        System.out.println(h);
    }
}
