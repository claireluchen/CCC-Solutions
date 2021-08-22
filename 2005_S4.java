//Graph theory (BFS)
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
		int L = readInt(); //L sets of data
		for (int x = 0; x < L; x++) {
			int n = readInt(); //n rows of input
			String[] input = new String[n];
			for (int i = 0; i < n; i++) {
				input[i] = next();
			}
			String root = input[n-1];
			Map<String, ArrayList<String>> adj = new HashMap<>();
			ArrayList<String> temp = new ArrayList<>(); adj.put(input[n-1], temp);
			for (int i = 0; i < n-1; i++) {
				if (input[i+1].equals(input[n-1])) {
					ArrayList<String> tempList = adj.get(input[n-1]);
					tempList.add(input[i]);
					adj.put(input[n-1], tempList);
				}
				if (adj.containsKey(input[i])) {
					ArrayList<String> tempList = adj.get(input[i]);
					tempList.add(input[i+1]);
					adj.put(input[i], tempList);
				}else {
					ArrayList<String> tempList = new ArrayList<>();
					tempList.add(input[i+1]);
					adj.put(input[i], tempList);
				}				
			}
			
			//find the longest distance from root
			int maxDis = -1;
			Queue<String> q = new LinkedList();
			Map<String, Integer> dis = new HashMap<>();
			ArrayList<String> vis = new ArrayList<>();
			
			q.add(root); //push the starting node into the queue
			vis.add(root); //mark the starting node visited
			dis.put(root, 0); //distance from starting node is 0
			
			while (!q.isEmpty()) {
				String cur = q.poll(); //get the head of the queue
				for (String nxt : adj.get(cur)) { //get the places the previous node leads to
					if (!vis.contains(nxt)) { //if not visited
						q.add(nxt); //add the newly discovered node to the queue
						vis.add(nxt); //mark the node visited
						dis.put(nxt, dis.get(cur) + 1); //distance from the starting house, which is one more step than the previous node
						if (dis.get(nxt) > maxDis) {maxDis = dis.get(nxt);}
					}
				}
			}
			int numOfEdge = adj.size() - 1;

			//print number of edges * 2 * 10 - longest distance from root * 2 * 10
			System.out.println(numOfEdge * 2 * 10 - (maxDis) * 2 * 10);
		}		
	}
}
