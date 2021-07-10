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
		int inDegree[] = new int[7]; //store in degree
		List<Integer>[] adj = new ArrayList[7];
		for (int i = 0; i < 7; i++) adj[i] = new ArrayList<Integer>();
		adj[0].add(6); adj[0].add(3); adj[1].add(0); adj[2].add(3); adj[2].add(4);
		inDegree[6]++; inDegree[3]++; inDegree[0]++; inDegree[3]++; inDegree[4]++;
		while (true) {
			int from = readInt() - 1, to = readInt() - 1;
			if (from == -1 && to == -1) break;
			adj[from].add(to); inDegree[to]++;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue();
		for (int i = 0; i < 7; i++) {
			if (inDegree[i] == 0) q.add(i); //find starting nodes (vertex whose inDegree is 0)
		}
		List<Integer> ans = new ArrayList(); //a list of answers
		while(!q.isEmpty()) {
			int u = q.poll(); //get the first element from the queue, to be processed
			ans.add(u); //add the vertex to the answer list
			for (int v : adj[u]) { //for every vertex the current vertex leads to
				inDegree[v]--; //decrease its in degree by 1
				if(inDegree[v] == 0) q.add(v); //if in degree is 0, add it to the queue
			} 
		}
		if (ans.size() != 7) { 
			//if number of elements processed != the number of original, meaning some are not processed
			System.out.println("Cannot complete these tasks. Going to bed.");
		}else {
			for (int i : ans) {
				System.out.print(i + 1 + " ");
			}
		}
	}
}
