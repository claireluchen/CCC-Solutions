import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static String next () throws IOException {
	  	 while (st == null || !st.hasMoreTokens())
	   	 st = new StringTokenizer(br.readLine().trim());
	   	 return st.nextToken();
	}

	public static boolean test(String str) {
		while (str.contains("ANA") || str.contains("BAS")) {
			str = str.replace("ANA", "A");
			str = str.replace("BAS", "A");
		}
		return (str.equals("A"));
	}
	
	public static void main(String[] args) throws IOException{
		String input = next();
		while (!input.equals("X")) {
			if(test(input)) {System.out.println("YES");} else {System.out.println("NO");}
			input = next();
		}
	}

}
