import java.util.*;
public class MyDeque{

    private String[] data;
    private int front;
    private int back;
    private int size;

    public MyDeque(){
	data = new String[10];
	size = 0;
	front = 0;
	back = 0;
    }

    private void grow(){
	String[] temp = new String[size * 2];
	if(back >= front){
	    for(int i = front; i <= back; i++){
		temp[i - front] = data[i];
	    }
	}
	else{
	    for(int i = front; i < data.length; i++){
		temp[i - front] = data[i];
	    }
	    for(int i = 0; i <= back; i++){
		temp[i + data.length - front + 1] = data[i];
	    }
	}
	data = temp;
	front = 0;
	back = size - 1;
    }

    public int size(){
	return size;
    }

    public void addFirst(String s){
	System.out.println("Front: " + front + "\n" + "Back: " + back);
	if(s == null){
	    throw new NullPointerException();
	}
	if(size >= data.length){
	    grow();
	}
	if(size != 0){
	    front--;
	    if(front < 0){
		front = data.length - 1;
	    }
	}
	data[front] = s;
	size++;
        System.out.println("Front: " + front + "\n" + "Back: " + back);
    }
    
    public void addLast(String s){
	System.out.println("Front: " + front + "\n" + "Back: " + back);
	if(s == null){
	    throw new NullPointerException();
	}
	if(size >= data.length){
	    grow();
	}
	if(size != 0){
	    back++;
	    if(back >= data.length){
		back = 0;
	    }
	}
	data[back] = s;
	size++;
	System.out.println("Front: " + front + "\n" + "Back: " + back);
    }

    public String removeFirst(){
	System.out.println("Front: " + front + "\n" + "Back: " + back);
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String ans = data[front];
	front++;
	if(front >=  data.length){
	    front = 0;
	}
	size--;
	System.out.println("Front: " + front + "\n" + "Back: " + back);
	return ans;
    }

    public String removeLast(){
	System.out.println("Front: " + front + "\n" + "Back: " + back);
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String ans = data[back];
	back--;
	if(back < 0){
	    back = data.length - 1;
	}
	size--;
	System.out.println("Front: " + front + "\n" + "Back: " + back);
	return ans;
    }

    public String getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return data[front];
    }

    public String getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return data[back];
    }
    
    public String toStringDebug(){
	if (size == 0){
	    return "[]";
	}
	String ans =  "";
	ans += "[ ";
	ans += data[0];
	for(int i = 1; i < data.length; i++){
	    ans = ans + ", " + data[i];
	}
	ans += "]";
	return ans;
    }

    public static void main(String[]args){
	MyDeque a = new MyDeque();
	
	//a.addFirst(null); //throws NullPointerException
	//a.addLast(null); //throws NullPointerException
	//a.removeFirst(); //throws NoSuchElementException
	//a.removeLast(); //throws NoSuchElementException
	//a.getFirst(); //throws NoSuchElementException
	//a.getLast(); //throws NoSuchElementException

	//a.addLast("z");
	//System.out.println(a.size()); //2
	//System.out.println(a.toStringDebug());
	a.addFirst("a");
	System.out.println(a.size()); //1
	System.out.println(a.toStringDebug());
	a.addLast("z");
	System.out.println(a.size()); //2
	System.out.println(a.toStringDebug());
	a.addFirst("b");
	System.out.println(a.size()); //3
	System.out.println(a.toStringDebug());
	a.addFirst("c");
	System.out.println(a.size()); //4
	System.out.println(a.toStringDebug());
	a.addLast("y");
	System.out.println(a.size()); //5
	System.out.println(a.toStringDebug());

	System.out.println(a.getFirst()); //c
	System.out.println(a.getLast()); //y
	
	System.out.println(a.removeFirst()); //c
	System.out.println(a.size()); //4
	System.out.println(a.toStringDebug());
	System.out.println(a.removeFirst()); //b
	System.out.println(a.size()); //3
	System.out.println(a.toStringDebug());
	
	System.out.println(a.removeLast()); //y
	System.out.println(a.size()); //2
	System.out.println(a.toStringDebug());
	System.out.println(a.removeLast()); //z
	System.out.println(a.size()); //1
	System.out.println(a.toStringDebug());
	a.addFirst("t");
	System.out.println(a.removeLast()); //a
	System.out.println(a.size()); //1
	System.out.println(a.toStringDebug());

	System.out.println(a.getFirst()); //t
	System.out.println(a.getLast()); //t

	a.addFirst("q");
	a.addFirst("q");
	a.addFirst("q");
	a.addFirst("q");
	a.addFirst("q");
	a.addFirst("q");
	a.addFirst("q");
	a.addFirst("q");
	System.out.println(a.size()); //9
	System.out.println(a.toStringDebug());
	a.addFirst("q");
	System.out.println(a.size()); //10
	System.out.println(a.toStringDebug());
	//a.addFirst("q");
	//System.out.println(a.size()); //11
	//System.out.println(a.toStringDebug());
	a.addLast("p");
	System.out.println(a.size()); //11
	System.out.println(a.toStringDebug());
    }
}
