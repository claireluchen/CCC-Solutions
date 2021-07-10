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
    int n = readInt(); //find number of path from 0 to n - 1
    ArrayList<Integer>[] parent = new ArrayList[n], child = new ArrayList[n];

    for (int i = 0; i < n; i++) {
    	parent[i] = new ArrayList<>(); child[i] = new ArrayList<>();
    }
    
	  int a = readInt() - 1, b = readInt() - 1;
    while (a != -1 && b != -1){
      parent[b].add(a); child[a].add(b);
      a = readInt() - 1; b = readInt() - 1;
    }
    
    int[] dp = new int[n]; dp[n - 1] = 1;
    for (int p : parent[n - 1]) dp[p] = 1;
    for (int cur = n - 2; cur >= 0; cur--) {
    	for (int nxt : parent[cur]) {
    		dp[nxt] += dp[cur];
    	}
    }
    
    System.out.println(dp[0]);
  }
}
