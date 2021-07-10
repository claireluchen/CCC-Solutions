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
	
	static Map<Integer, Integer> adj = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		int numOfStudent = readInt();
		for (int i = 0; i < numOfStudent; i++) {
			int x = readInt(), y = readInt();
			adj.put(x, y);
		}
		
		int a = readInt(), b = readInt();
		while (a != 0 && b != 0) {
			//check if a and read b and keep track of the length
			int distance = 0;
			ArrayList<Integer> visited = new ArrayList<>();
			
			Queue<Integer> q = new LinkedList();
			q.add(a);
			visited.add(a);
			int next = -1;
			while (!q.isEmpty() && next != b && next != a) {
				int cur = q.poll();
				next = adj.get(cur);
					if (!visited.contains(next)) {
						q.add(next);
						visited.add(next);
						distance++;
					}							
			}
			
			if (visited.contains(b)) {
				System.out.println("Yes " + (distance-1));
			}else {
				System.out.println("No");
			}
			a = readInt(); b = readInt();
		}	
		
	}

}
