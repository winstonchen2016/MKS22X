import java.util.*;

public class Quiz2Redux{  

    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    
    public static ArrayList<String> combinations(String s){
	ArrayList<String> words = new ArrayList<String>();
	help(words, s, "", 0);
	Collections.sort(words);
	return words;
    }
  
    private static void help(ArrayList<String> words, String str, String now, int index){
	if(index >= str.length()){
	    words.add(now);
	}
	else{
	    help(words, str, now + str.charAt(index), index + 1);
	    help(words, str, now, index + 1);
	}
    }

    public static void main(String[]args){
	System.out.println(combinations(""));
	System.out.println("[]");
	System.out.println(combinations("abcd"));
	System.out.println("[, a, ab, abc, abcd, abd, ac, acd, ad, b, bc, bcd, bd, c, cd, d]");
	System.out.println(combinations("kji"));
	System.out.println("[, i, j, ji, k, ki, kj, kji]");
    }
    
}
