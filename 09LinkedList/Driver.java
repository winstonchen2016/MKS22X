import java.util.*;
public class Driver{

    public static int[] randomArray(int size) {
	int[] ary = new int[size];
	for (int i = 0; i < ary.length; i ++) {
	    ary[i] = (int)(Math.random() * ary.length - ary.length / 2);
	}
	return ary;
    }

    public static void main(String[]args){
	MyLinkedList l = new MyLinkedList();
	System.out.println(l); //[]
	l.add(1);
	System.out.println(l); //[1]
	System.out.println(l.size()); //1
	System.out.println(l.get(0)); //1
	l.add(-2);
	System.out.println(l); //[1, -2]
	System.out.println(l.size()); //2
	System.out.println(l.get(0)); //1
	System.out.println(l.get(1)); //-2
	//System.out.println(l.get(-1)); //throws IndexOutOfBoundsException
	//System.out.println(l.get(2)); //throws IndexOutOfBoundsException
	//System.out.println(l.get(3)); //throws IndexOutOfBoundsException
	System.out.println(l.set(0, 75)); //1
	System.out.println(l); //[75, -2]
	System.out.println(l.set(1, -13)); //-2
	System.out.println(l); //[75, -13]
	//System.out.println(l.set(-1, 0)); //throws IndexOutOfBoundsException
	//System.out.println(l.set(2, 0)); //throws IndexOutOfBoundsException
	//System.out.println(l.set(3, 0)); //throws IndexOutOfBoundsException
	System.out.println(l.indexOf(1)); //-1
	System.out.println(l.indexOf(-4178)); //-1
	System.out.println(l.indexOf(75)); //0
	System.out.println(l.indexOf(-13)); //1
	l.add(89);	
	System.out.println(l.toStringDebug());
	System.out.println(l); //[75, -13, 89]
	System.out.println(l.size()); //3
	//System.out.println(l.remove(4)); //throws IndexOutOfBoundsException
	System.out.println(l.remove(1)); //-13
	System.out.println(l.size()); //2
	System.out.println(l.toStringDebug());
	System.out.println(l); //[75, 89]
	System.out.println(l.remove(0)); //75
	System.out.println(l.size()); //1
	System.out.println(l.toStringDebug());
	System.out.println(l); //[89]
	l.add(100);
	System.out.println(l.size()); //2
	System.out.println(l.toStringDebug());
	System.out.println(l); //[89, 100]
	System.out.println(l.remove(1)); //100
	System.out.println(l.size()); //1
	System.out.println(l.toStringDebug());
	System.out.println(l); //[89]
	System.out.println(l.remove(0)); //89
	System.out.println(l.size()); //0
	System.out.println(l.toStringDebug());
	System.out.println(l); //[]

	//PENN'S TESTING CODE
	/*
	MyLinkedList Penn = new MyLinkedList();
	int[] a = randomArray(5);
	for (int i = 0; i < a.length; i ++) {
	    System.out.println(Penn);
	    System.out.println("Adding " + a[i]);
	    Penn.add(a[i]);
	    if (i % 2 == 0) {
		System.out.println(Penn);
		int remove = (int)(Math.random() * Penn.size());
		System.out.println("Removing " + Penn.remove(remove) + " at " + remove);
	    }
	}
	System.out.println(Penn);
	System.out.println("Finished adding to the back");
	a = randomArray(30);
	for (int i = 0; i < a.length; i ++) {
	    System.out.println(Penn);
	    int add = (int)(Math.random() * (Penn.size() + 1));
	    if (add == Penn.size()) {
	        System.out.println("Adding " + a[i] + " at " + add + ", shifting nothing");
	    }
	    else {
		System.out.println("Adding " + a[i] + " at " + add + ", shifting " + Penn.get(add));
	    }
	    Penn.add(add, a[i]);
	}
	System.out.println(Penn);
	System.out.println("Finished adding randomly");
	a = randomArray(20);
	for (int i = 0; i < a.length; i ++) {
	    System.out.println(Penn);
	    int replace = (int)(Math.random() * Penn.size());
	    System.out.println("Replacing " + Penn.get(replace) + " at " + replace + " with " + a[i]);
	    Penn.set(replace, a[i]);
	}
	System.out.println(Penn);
	System.out.println(Penn.size());

	a = randomArray(20);
	for (int i = 0; i < a.length; i ++) {
	    System.out.println(a[i] + " is located at " + Penn.indexOf(a[i]));
	}
	//Iterator testing
	System.out.print("[");
 	for (Integer i : Penn) {
 	    System.out.print(i + ", ");
 	}
 	System.out.println("]");
	
 	Iterator<Integer> it = Penn.iterator();
 	System.out.print("[");
 	while (it.hasNext()) {
 	    System.out.print(it.next() + ", ");
 	}
 	System.out.println("]");
	*/
    }

}
