public class MyLinkedList{

    private class LNode{
	
	private int val;
	private LNode next;

	public LNode(int i){
	    val = i;
	    next = null;
	}

	public LNode(int i, LNode n){
	    val = i;
	    next = n;
	}
    }

    private LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }

    public boolean add(int value){
	LNode n = new LNode(value, start);
	start = n;
	size ++;
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String ans = "[";
	LNode current = start;
        for(int i = 0; i < size; i++){
	    ans = ans + current.value + ", ";
	    current = current.next;
	}
	ans += "]";
	return ans;
    }

}
