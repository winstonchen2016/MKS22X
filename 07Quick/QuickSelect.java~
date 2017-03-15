public class QuickSelect{

    public QuickSelect(){};

    public static int part(int[] data, int start, int end){
	int pivot = data[Math.random() * data.length / 1];
	ArrayList<int> a1 = new ArrayList<int>();
	for(int i = 0; i < data.length; i++){
	    if(data[i] < pivot){
		a1.add(data[i]);
	    }
	}
	for(int i = 0; i < data.length; i++){
	    if(data[i] ==  pivot){
		a1.add(data[i]);
	    }
	}
	for(int i = 0; i < data.length; i++){
	    if(data[i] == pivot){
		a1.add(data[i]);
	    }
	}
	return a1.indexOf(pivot);
    }
}
