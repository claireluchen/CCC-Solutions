//BFS, TreeSet
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
  static class Pair implements Comparable<Pair> {
	int x, y;
	Pair(int x, int y){
	  this.x = x; this.y = y;
	}
	public int compareTo(Pair other) {
	  if (this.x != other.x) return this.x - other.x;
	  return this.y - other.y;
	}
  }
  public static void main(String[] args) throws IOException{
    int n = readInt(), m = readInt(), d = readInt();
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();
    for (int i = 0; i < m; i++){
      int a = readInt() - 1, b = readInt() - 1;
      adj[b].add(a);
    }
    int[] subway = new int[n];
    for (int i = 0; i < n; i++){
      subway[i] = readInt() - 1;
    }
    
    int[] dist = new int[n];
    Arrays.fill(dist, 0x3f3f3f3f);
    boolean[] vis = new boolean[n];
    Queue<Integer> q = new LinkedList<>();
    q.add(n - 1);
    dist[n - 1] = 0; vis[n - 1] = true;
    while (!q.isEmpty()){
      int cur = q.poll();
      for (int nxt : adj[cur]){
        if (!vis[nxt]){
          dist[nxt] = dist[cur] + 1;
          vis[nxt] = true;
          q.add(nxt);
        }
      }
    }
        
    TreeSet<Pair> set = new TreeSet<>();
    for (int i = 0; i < n; i++){
      set.add(new Pair(i + dist[subway[i]], i));
    }
    
    for (int z = 0; z < d; z++){
      int sa = readInt() - 1, sb = readInt() - 1;
      int old1 = sa + dist[subway[sa]], old2 = sb + dist[subway[sb]];
      
      set.remove(new Pair(old1, sa)); set.remove(new Pair(old2, sb));

      int temp = subway[sa]; subway[sa] = subway[sb]; subway[sb] = temp;
      int new1 = sa + dist[subway[sa]], new2 = sb + dist[subway[sb]];
      set.add(new Pair(new1, sa)); set.add(new Pair(new2, sb));
      System.out.println(set.first().x);
    }
  }
}
