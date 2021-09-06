//Graph theory (BFS), string
import java.util.*;
import java.io.*;
public class Main {  
  public static void main(String[] args) throws IOException{
    int N = readInt();
    Map<String, ArrayList<String>> map = new HashMap<>();
    String[] fromURLArray = new String[N];
    for (int i = 0; i < N; i++){
      String startingURL = readLine();
      fromURLArray[i] = startingURL;
      ArrayList<String> toURL = new ArrayList<>();
      String input = readLine();
      while (!input.contains("</HTML>")){
        if (input.contains("<A HREF=")){
          //find all of the index of "
          ArrayList<Integer> index = new ArrayList<>(); 
          int tempIndex = input.indexOf("\"");
          while(tempIndex >= 0) {
        	 index.add(tempIndex);
             tempIndex = input.indexOf("\"", tempIndex + 1);
          }
          while (!index.isEmpty()){
            toURL.add(input.substring(index.get(0) + 1, index.get(1)));
            index.remove(0); index.remove(0);
          }
        }
        input = readLine();
      }
      map.put(startingURL, toURL);
    }    
    
    ArrayList<String> fromTo = new ArrayList<>();
    String input = readLine();
    while (!input.equals("The End")){
      fromTo.add(input); input = readLine();
    }

    for (String url : fromURLArray){
      ArrayList<String> to = map.get(url);
      for (String temp : to) {
          System.out.printf("Link from %s to %s\n", url, temp);
      }
    }

    while (!fromTo.isEmpty()){
      ArrayList<String> visited = new ArrayList<>();
      String from = fromTo.get(0), end = fromTo.get(1);
      Queue<String> q = new LinkedList<>();
      q.addAll(map.get(from));
      visited.addAll(map.get(from));
      while (!q.isEmpty()){
        String cur = q.poll();
        if (map.containsKey(cur) && !visited.contains(end)) {
        	for (String nxt : map.get(cur)){
        		if (!visited.contains(nxt)){
        			visited.add(nxt);
        			q.add(nxt);
        		}
        	}
        }        
      }
      if (visited.contains(end)){
        System.out.printf("Can surf from %s to %s.\n", from ,end);
      }else{
        System.out.printf("Can't surf from %s to %s.\n", from ,end);
      }
      fromTo.remove(0); fromTo.remove(0);
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
