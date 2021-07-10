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
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}

	public static void main(String[] args) throws IOException{
		String[][] stringArray = new String[10][9];
		int[][] values = new int[10][9];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				stringArray[i][j] = next(); values[i][j] = -1;
			}
		}
		
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0 ; i < 10 ; i++) {
				for (int j = 0 ; j < 9 ; j++) {
				    StringTokenizer t = new StringTokenizer (stringArray[i][j], "+");
				    int newValue = 0;
				    int x = 0;
				    while (t.hasMoreTokens () && x != -1){
				    	x = getValue(t.nextToken(), values);
				    	if (x == -1)
				    		newValue = -1;
				    	else
				    		newValue += x;
				    }
				    if (values[i][j] != newValue){
				    	changed = true;
				    	values[i][j] = newValue;
				    }
				}
			}
		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (values[i][j] == -1) System.out.print("* ");
				else System.out.print(values[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int getValue(String str, int[][] values) {
		int val;
		if (str.charAt (0) >= 'A' && str.charAt (0) <= 'J')
		    val = values[str.charAt (0) - 'A'][str.charAt (1) - '1'];
		else
		    val = Integer.parseInt (str);
		return val;
	}
}
