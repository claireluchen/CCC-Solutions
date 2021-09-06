//implementation, hashset/map
import java.util.*;
import java.io.*;

public class Main{
  static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static String next() throws IOException {
	 	while (st == null || !st.hasMoreTokens())
	    	st = new StringTokenizer(br.readLine().trim());
	  return st.nextToken();
	}
	static int readInt() throws IOException {
	  return Integer.parseInt(next());
	}

  public static void main(String[] args) throws IOException{
    int M = readInt(), N = readInt();
    int k = readInt();

    HashSet<Integer> goldRows = new HashSet<>();
    HashSet<Integer> goldCols = new HashSet<>();

    for (int i = 0; i < k; i++){
      String rOrc = next();
      int num = readInt() - 1;
      if (rOrc.equals("R")){
        if (goldRows.contains(num)) goldRows.remove(new Integer(num));
        else goldRows.add(num);
      }else{
        if (goldCols.contains(num)) goldCols.remove(new Integer(num));
        else goldCols.add(num);
      }
    }

    System.out.println(N * goldRows.size() + M * goldCols.size() - 2 * goldRows.size() * goldCols.size());

  }

}
