public class FrontierStack implements Frontier{
    
    private Stack S;

    public FrontierStack(){
	S = new Stack();
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
