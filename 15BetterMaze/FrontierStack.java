import java.util.*;

public class FrontierStack implements Frontier{
    
    private Stack<Location> S;

    public FrontierStack(){
	S = new Stack<Location>();
    }

    public void add(Location l){
	S.push(l);
    }

    public Location next(){
	return S.pop();
    }

    public int size(){
	return S.size();
    }
}
