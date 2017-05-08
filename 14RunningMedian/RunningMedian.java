public class RunningMedian{
    
    private MyHeap smaller;
    private MyHeap larger;

    public RunningMedian(){
	smaller = new MyHeap(true); //max heap
	larger = new MyHeap(false); //min heap
    }
    
    public void add(int n){
	smaller.add(n);
	while(smaller.size() - larger.size() > 1){
	    larger.add(smaller.remove());
	}
    }

    public double getMedian(){
	if(smaller.size() > larger.size()){
	    return smaller.peek();
	}
	else if(larger.size() > smaller.size()){
	    return larger.peek();
	}
	else{
	    return smaller.peek() + larger.peek() / 2.0;
	}
    }

    public String toString(){
	String ans = "";
	ans = ans + "smaller:" + smaller.toString();
	ans += "\n";
	ans = ans + "larger:" + larger.toString();
	return ans;
    }

    public static void main(String[]args){
	RunningMedian a = new RunningMedian();
	a.add(1);
	System.out.println(a.getMedian()); //1.0
	System.out.println(a.toString());
	a.add(2);
	System.out.println(a.getMedian()); //1.5
	a.add(3);
	System.out.println(a.getMedian()); //2.0

    }
}
