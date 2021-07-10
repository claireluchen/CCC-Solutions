import java.io.*;
import java.util.*;
import java.math.BigInteger;
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
		int r = readInt();
		while(r != 0) {
		    int totalPoints = 0;
			int temp = r;
			for (int x = 1; x <= r; x++) {
				for (int y = temp; temp > 0; y--) {
					double distance = Math.sqrt(x * x + y * y);
					if (distance <= r) {
						totalPoints += temp;
						temp = y;
						break;
					}
				}
			}
			System.out.println(4 * totalPoints + 1);
			r = readInt(); //read next radius
		}
		
	}
}
