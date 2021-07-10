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
		int n = readInt(), m = readInt(), d = readInt(); //n nodes, m edges, # of destination cities
		ArrayList<Pair>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) adj[i] = new ArrayList<Pair>();
		for (int i = 0; i < m; i++) {
			int from = readInt() - 1, to = readInt() - 1, weight = readInt();
			adj[from].add(new Pair(weight, to));
			adj[to].add(new Pair(weight, from));
		}
		int[] destinationCities = new int[d];
		for (int i = 0; i < d; i++) {
			destinationCities[i] = readInt() - 1;
		}
		
		PriorityQueue<Pair> q = new PriorityQueue<>();
		boolean[] visited = new boolean[n];
		int[] prev = new int[n];
		q.add(new Pair(-10000000, 0));
		ArrayList<Pair> usedEdges = new ArrayList<>(); //(weight, to)
		
		while (!q.isEmpty()) {
			Pair temp = q.poll(); 
			int cur = temp.y, curWeight = -1 * temp.x;
			if(visited[cur]) continue; 
			visited[cur] = true;
			usedEdges.add(new Pair(curWeight, cur));
			Loop:
			for (Pair nxt : adj[cur]) {
				int b = nxt.y, w = nxt.x; //b is the next node, w is the weight from cur to nxt (b)
				if (prev[b] != 0) {
					int pre = prev[b];
					for (int z = 0; z < adj[pre].size(); z++) {
						if (adj[pre].get(z).y == b) {
							if (adj[pre].get(z).x >= w) continue Loop;
						}
					}
				}
				q.add(new Pair(-w, b));
				prev[b] = cur;
			}
		}
		
		//make a new graph storing only the max spanning tree
		ArrayList<Pair>[] newGraph = new ArrayList[n];
		for (int i = 0; i < n; i++) newGraph[i] = new ArrayList<>();
		for (int i = 0; i < usedEdges.size(); i++) {
			int weight = usedEdges.get(i).x, to = usedEdges.get(i).y, from = prev[to];
			newGraph[to].add(new Pair(weight, from));
			newGraph[from].add(new Pair(weight, to));
		}
		Collections.sort(usedEdges);
		for (int i = 0; i < usedEdges.size(); i++) {
			//try removing the current edge
			int weight = usedEdges.get(i).x, to = usedEdges.get(i).y, from = prev[to];
			newGraph[to].remove(new Pair(weight, from));
			newGraph[from].remove(new Pair(weight, to));
			boolean[] vis = new boolean[n];
			//traverse through the newGraph, see which nodes we can reach
			Queue<Integer> Q = new LinkedList();
			
			Q.add(0); //push the starting node into the queue
			vis[0] = true; //mark the starting node visited
			
			while (!Q.isEmpty()) {
				int cur = Q.poll(); //get the head of the queue
				for (Pair nxt : newGraph[cur]) { //get the places the previous node leads to
					if (!vis[nxt.y]) { //if not visited
						Q.add(nxt.y); //add the newly discovered node to the queue
						vis[nxt.y] = true; //mark the node visited
					}
				}
			}
			for (int des : destinationCities) {
				if (!vis[des]) {
					System.out.println(weight); return;
				}
			}
			
			newGraph[to].add(new Pair(weight, from));
			newGraph[from].add(new Pair(weight, to));
		}
		
	}
	
	static class Pair implements Comparable<Pair>{
	    int x, y;
	    public Pair(int x, int y){
	    	this.x = x; this.y = y;
	    }
	   
	    @Override
	    public int compareTo(Pair obj) {
	    	if (x < ((Pair) obj).x) return -1;
	    	if (x > ((Pair) obj).x) return 1;
	    	return 0;
	    }
	    
	    @Override
	    public boolean equals(Object obj){
	    	if (obj instanceof Pair && x == ((Pair) obj).x && y == ((Pair) obj).y)
	    		return true;
	    	else return false;
	    }
	   
	    @Override
	    public int hashCode(){
	    	int result = x / 11 + y;
	    	return result;
	    }
		
	}

}
