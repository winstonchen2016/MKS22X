public class QuickSelect{

    public QuickSelect(){};

    public static int part(int[] data, int start, int end){
	int L = start;
	int R = end;
	int M = (int)(Math.random() * (end - start + 1) + start);
	int pivot = data[M];
	System.out.println(M);
	System.out.println(pivot);
	while(L < M && data[L] < pivot){
	    L ++;
	}
	while(R > M && data[R] > pivot){
	    R --;
	}
	return 1;
    }

    public static void main(String[]args){
	int[] a = {999, 999, 999, 4, 1, 0, 3, 2, 999, 999, 999};
	System.out.println(part(a, 0, 10));
    }
}
