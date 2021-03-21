import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
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
	int n = readInt();
	int[] h = new int[n + 1]; int[] w = new int[n];
	for (int i = 0; i <= n; i++) h[i] = readInt();
	for (int i = 0; i < n; i++) w[i] = readInt();
	double area = 0;
	for (int i = 0; i < n; i++) {
		double temp = (double) (h[i] + h[i+1]) * w[i] / 2;
		area += temp;
	}
	if (area == (int) area) System.out.printf("%.0f", area);
	else System.out.println(area);	
  }  
}
