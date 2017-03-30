public class MyLinkedList{

    private class LNode{
	
	private int val;
	private LNode next;

	private LNode(int i){
	    val = i;
	    next = null;
	}

	private LNode(int i, LNode n){
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
	if(size == 0){
	    start = new LNode(value);
	    size++;
	    return true;
	}
	LNode current = start;
	for(int i = 0; i < size - 1; i++){
	    current = current.next;
	}
	current.next = new LNode(value);
	size ++;
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String ans = "[";
	if(size == 0){
	    return ans + "]";
	}
	LNode current = start;
        for(int i = 0; i < size; i++){
	    ans = ans + current.val + ", ";
	    current = current.next;
	}
	return ans.substring(0, ans.length() - 2) + "]";
    }

    public int get(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for(int i = 0; i < index; i++){
	    current = current.next;
	}
	return current.val;
    }

    public int set(int index, int newValue){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for(int i = 0; i < index; i++){
	    current = current.next;
	}
	int ret = current.val;
	current.val = newValue;
	return ret;
    }

}
