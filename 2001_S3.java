//Graph theory (BFS)
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		ArrayList<String> roads = new ArrayList<>();
		ArrayList<Integer>[] adj = new ArrayList[26];
		for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();
		String input = next();
		while(!input.equals("**")) {
			roads.add(input);
			int from = input.charAt(0) - 65;
			int to = input.charAt(1) - 65;
			adj[from].add(to); adj[to].add(from);
			input = next();
		}

		ArrayList<String> bomb = new ArrayList<>();
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				ArrayList<Integer> copyI = new ArrayList<>(adj[i]);
				ArrayList<Integer> copyJ = new ArrayList<>(adj[copyI.get(j)]);
				int temp = adj[i].remove(j);
				adj[temp].remove(new Integer(i));
				Queue<Integer> q = new LinkedList();
				boolean[] vis = new boolean[26]; //keep track if visited
				
				q.add(0); //push the starting node into the queue
				vis[0] = true; //mark the starting node visited
				while (!q.isEmpty()) {
					int cur = q.poll(); //get the head of the queue
					for (int nxt : adj[cur]) { //get the places the previous node leads to
						if (!vis[nxt]) { //if not visited
							q.add(nxt); //add the newly discovered node to the queue
							vis[nxt] = true; //mark the node visited
						}
					}
				}
				if (!vis[1]) {
					String str = "" + (char) (i + 65) + (char) (copyI.get(j) + 65);
					bomb.add(str);
				}
				adj[i] = copyI; adj[copyI.get(j)] = copyJ;
			}
		}
		
		if (bomb.size() == 0) {
			System.out.println("There are 0 disconnecting roads.");
		}else {
			Collections.sort(bomb);
			HashSet<String> set = new HashSet<>();
			for (String str : bomb) {
				if (roads.contains(str) && !set.contains(str)) {
					set.add(str); System.out.println(str);
				} 
			}
			System.out.printf("There are %d disconnecting roads.%n", set.size());
		}

	}
	
	//fast i/o
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
	static String readLine () throws IOException {
	  return br.readLine().trim();
	}

}
