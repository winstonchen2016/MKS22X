public class QuickSelect{

    public QuickSelect(){};

    public static int part(int[] data, int start, int end){
	int L = start + 1;
	int R = end;
	int M = (int)(Math.random() * (end - start + 1) + start);
	int pivot = data[M];
	System.out.println("Pivot Index: " + M);
	System.out.println("Pivot Element: " + pivot);
	swap(data, start, M); //moves pivot to beginning for easier sorting
	//System.out.println("Initial array: " + toString(data) + "\n");
	while(L < R){
	    while(data[L] < pivot && L < end){ //increments lower bound upwards until it hits an element that needs swapping
		L ++;
	    }
	    while(data[R] >= pivot && R > start){ //increments upper bound downwards until it hits an element that needs swapping
		R --;
	    }
	    System.out.println("L: " + L);
	    System.out.println("R: " + R);
	    System.out.println("Before swap: " + toString(data));
	    if(L < R){ //swaps L and R if they are on the wrong sides
		swap(data, L, R);
	    }
	    //System.out.println("After  swap: " + toString(data) + "\n");
	    if(data[L] == pivot && data[R] == pivot){ //prevetns infinite looping from swapping identical elements (probably not necessary?)
		L++;
		R--;
	    }
	}
	if(r != start){
	    swap(data, start, R);
	}
	//System.out.println("Pivot Index: " + M);
	//System.out.println("Pivot Element: " + pivot);
	//System.out.println("Final L: " + L);
	//System.out.println("Final R: " + R);
	System.out.println("Final array: " + toString(data) + "\n");
	return R;
    }

    public static void swap(int[] ar, int a, int b){
	int temp = ar[a];
	ar[a] = ar[b];
	ar[b] = temp;
    }
	
    public static String toString(int[] ar){
	String ans = "[";
	for(int i = 0; i < ar.length - 1; i++){
	    ans = ans + ar[i] + " ";
	}
	ans = ans + ar[ar.length - 1] + "]";
	return ans;
    }
    
    public static void main(String[]args){
	//int[] a = {5, 7, 6, 1, 3, 2, 0, 4, 8, 9};
	//System.out.println(part(a, 0, 9));
	//int[] b = {999, 999, 999, 4, 1, 0, 3, 2, 999, 999, 999};
	//System.out.println(part(b, 3, 7));
	//System.out.println(part(b, 0, 10));
	//swap (a, 2, 3);
	//System.out.println(toString(a));
	int x = 0;
	while(x < 50){
	    int[] c = new int[10];
	    for(int i = 0; i < c.length; i++){
		c[i] = (int)(Math.random() * 50);
	    }
	    System.out.println("Initial array: " + toString(c));
	    System.out.println(part(c, 0, c.length - 1));
	}
    }
}
