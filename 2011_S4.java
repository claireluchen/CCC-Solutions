//greedy algorithm
import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}

	public static void main(String[] args) throws IOException{
	    int o1 = readInt(), o2 = readInt(), a1 = readInt(), a2 = readInt(), b1 = readInt(), b2 = readInt(), ab1 = readInt(), ab2 = readInt();
      int pO1 = readInt(), pO2 = readInt(), pA1 = readInt(), pA2 = readInt(), pB1 = readInt(), pB2 = readInt(), pAB1 = readInt(), pAB2 = readInt();
      int count = 0; int min = 0;
      min = Math.min(o1, pO1); count += min; o1 -= min; pO1 -= min;
      min = Math.min(o2, pO2); count += min; o2 -= min; pO2 -= min;
      min = Math.min(o1, pO2); count += min; o1 -= min; pO2 -= min;
      min = Math.min(a1, pA1); count += min; a1 -= min; pA1 -= min;
      min = Math.min(o1, pA1); count += min; o1 -= min; pA1 -= min;
      min = Math.min(a2, pA2); count += min; a2 -= min; pA2 -= min;
      min = Math.min(a1, pA2); count += min; a1 -= min; pA2 -= min;
      min = Math.min(o2, pA2); count += min; o2 -= min; pA2 -= min;
      min = Math.min(o1, pA2); count += min; o1 -= min; pA2 -= min;
      min = Math.min(b1, pB1); count += min; b1 -= min; pB1 -= min;
      min = Math.min(o1, pB1); count += min; o1 -= min; pB1 -= min;
      min = Math.min(b2, pB2); count += min; b2 -= min; pB2 -= min;
      min = Math.min(b1, pB2); count += min; b1 -= min; pB2 -= min;
      min = Math.min(o2, pB2); count += min; o2 -= min; pB2 -= min;
      min = Math.min(o1, pB2); count += min; o1 -= min; pB2 -= min;
      
      int tempSum = o1 + a1 + b1 + ab1;
      min = Math.min(pAB1, tempSum); count += min; tempSum -= min;
      min = Math.min(pAB2, tempSum + o2 + a2 + b2 + ab2); count += min; 

      System.out.println(count);
	}

}
