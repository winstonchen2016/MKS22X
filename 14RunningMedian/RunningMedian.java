public class RunningMedian{
    
    private MyHeap smaller;
    private MyHeap larger;

    public RunningMedian(){
	smaller = new MyHeap(true); //max heap
	larger = new MyHeap(false); //min heap
    }
    
    public void add(int n){
	if(n > getMedian()){ //if greater than median, put in larger heap
	    larger.add(n);
	}
	else{                //if less than median, put in smaller heap
	    smaller.add(n);
	}
	while(larger.size() - smaller.size() > 1){ //fixes/balances heap sizes
	    smaller.add(larger.remove());
	}
	while(smaller.size() - larger.size() > 1){ //fixes/balances heap sizes
	    larger.add(smaller.remove());
	}
    }

    public double getMedian(){
	if(smaller.size() == 0 && larger.size == 0){ //empty heaps return 0.0
	    return 0.0;
	}
	if(smaller.size() > larger.size()){ //odd amount, smaller heap has more
	    return smaller.peek();
	}
	else if(larger.size() > smaller.size()){ //odd amount, larger heap has more
	    return larger.peek();
	}
	else{
	    return (smaller.peek() + larger.peek()) / 2.0; //even amount, take average
	}
    }

    /*
    public String toString(){ //debug only
	String ans = "";
	ans = ans + "smaller:" + smaller.toString();
	ans += "\n";
	ans = ans + "larger:" + larger.toString();
	return ans;
    }
    */

    public static void main(String[]args){
	RunningMedian a = new RunningMedian();
	System.out.println(a.getMedian()); //0.0
	//System.out.println(a.toString());
	a.add(1);
	System.out.println(a.getMedian()); //1.0
	//System.out.println(a.toString());
	a.add(2);
	System.out.println(a.getMedian()); //1.5
	//System.out.println(a.toString());
	a.add(3);
	System.out.println(a.getMedian()); //2.0
	//System.out.println(a.toString());
	a.add(-1);
	System.out.println(a.getMedian()); //1.5
	//System.out.println(a.toString());
	a.add(-2);
	System.out.println(a.getMedian()); //1.0
	//System.out.println(a.toString());
	a.add(-100);
	System.out.println(a.getMedian()); //0.0
	//System.out.println(a.toString());
	a.add(100);
	System.out.println(a.getMedian()); //1.0
	//System.out.println(a.toString());
	a.add(50);
	System.out.println(a.getMedian()); //1.5
	//System.out.println(a.toString());
	a.add(-50);
	System.out.println(a.getMedian()); //1.0
	//System.out.println(a.toString());
	a.add(-3);
	System.out.println(a.getMedian()); //0.0
	//System.out.println(a.toString());
    }
}
