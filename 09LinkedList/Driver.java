public class Driver{

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
    }

}
