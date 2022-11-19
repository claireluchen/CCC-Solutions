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
    int z = readInt();
    for (int count = 0; count < z; count++){
      int n = readInt();
      int[][] a = new int[n][n];
      int[][] ans = new int[n][n];
      for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
          a[i][j] = readInt();
          ans[i][j] = 0x3f3f3f3f;
        }
      }
      ans[0][0] = 0;
      boolean changed = true;
      while (changed) {
    	  changed = false;
    	  for (int i = 0; i < n; i++){
    	        for (int j = 0; j < n; j++){
    	          if (i == 0 && j == 0) continue;
    	          boolean reachable = false;
    	          if (i - 1 >= 0){
    	            if (Math.abs(a[i][j] - a[i - 1][j]) <= 2 && ans[i - 1][j] != -1){
    	              int ori = ans[i][j];
    	              if (a[i][j] > a[0][0] || a[i - 1][j] > a[0][0]) ans[i][j] = Math.min(ans[i][j], 1 + ans[i - 1][j]);
    	              else ans[i][j] = Math.min(ans[i][j], ans[i - 1][j]);
    	              reachable = true;
    	              if (ori != ans[i][j]) changed = true;
    	            }
    	          }
    	          if (j - 1 >= 0){
    	            if (Math.abs(a[i][j] - a[i][j - 1]) <= 2 && ans[i][j - 1] != -1){
    	              int ori = ans[i][j];
    	              if (a[i][j] > a[0][0] || a[i][j - 1] > a[0][0]) ans[i][j] = Math.min(ans[i][j], 1 + ans[i][j - 1]);
    	              else ans[i][j] = Math.min(ans[i][j], ans[i][j - 1]);
    	              reachable = true;
    	              if (ori != ans[i][j]) changed = true;
    	            }
    	          }
    	          if (i + 1 < n){
    	              if (Math.abs(a[i][j] - a[i + 1][j]) <= 2 && ans[i + 1][j] != -1){
    	                int ori = ans[i][j];
    	            	if (a[i][j] > a[0][0] || a[i + 1][j] > a[0][0]) ans[i][j] = Math.min(ans[i][j], 1 + ans[i + 1][j]);
    	                else ans[i][j] = Math.min(ans[i][j], ans[i + 1][j]);
    	                reachable = true;
    	                if (ori != ans[i][j]) changed = true;
    	              }
    	            }
    	            if (j + 1 < n){
    	              if (Math.abs(a[i][j] - a[i][j + 1]) <= 2 && ans[i][j + 1] != -1){
    	                int ori = ans[i][j];
    	            	if (a[i][j] > a[0][0] || a[i][j + 1] > a[0][0]) ans[i][j] = Math.min(ans[i][j], 1 + ans[i][j + 1]);
    	                else ans[i][j] = Math.min(ans[i][j], ans[i][j + 1]);
    	                reachable = true;
    	                if (ori != ans[i][j]) changed = true;
    	              }
    	            }
    	          if (!reachable) ans[i][j] = -1;
    	        }
    	      }
      }
      
      if (ans[n - 1][n - 1] == -1) System.out.println("CANNOT MAKE THE TRIP\n");
      else System.out.println(ans[n - 1][n - 1] + "\n");
      
    }

  }
}
