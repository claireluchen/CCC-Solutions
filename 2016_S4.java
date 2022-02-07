//Interval DP
import java.util.*;
import java.io.*;

public class homework {
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
		int n = readInt(), psa[] = new int[n+1], ans = 0; boolean dp[][] = new boolean[n+1][n+1];
		for(int i=1; i<=n; i++) {
			psa[i] = readInt(); ans = Math.max(ans, psa[i]);
			psa[i] += psa[i-1]; dp[i][i] = true;
		}
		for(int len=1; len<n; len++) {
			for(int L=1; L+len<=n; L++) {
				int R = L + len;
				for(int p=L, q=R; p<q; ) {
					int sumL = psa[p] - psa[L-1], sumR = psa[R] - psa[q-1];
					if(dp[L][p] && dp[q][R] && p+1 == q && sumL == sumR) {
						dp[L][R] = true;
					}else if(dp[L][p] && dp[q][R] && dp[p+1][q-1] && sumL == sumR) {
						dp[L][R] = true;
					}
					if(dp[L][R]) ans = Math.max(ans, psa[R] - psa[L-1]);
					if(sumL < sumR) p++;
					else q--;
				}
			}
		}
		System.out.println(ans);
	}
}
