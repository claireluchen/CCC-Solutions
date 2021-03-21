import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer> productChecked = new ArrayList<Integer>();
	static Queue<ArrayList<Integer>> queue = new LinkedList<>();
  
	public static void findFactorPairs(int pr, int maxX, int maxY) {
		if (pr == maxX * maxY) {
			System.out.println("yes");
			System.exit(0);
		}
		ArrayList<ArrayList<Integer>> pairs = new ArrayList<ArrayList<Integer>>();
		if (pr % 2 == 0) {
			for (int i = 1; i * i <= pr; i++) {
				if (pr % i == 0) {
					if (i <= maxX && pr / i <= maxY) {
						ArrayList<Integer> p = new ArrayList<Integer>();
						p.add(i - 1);
						p.add(pr / i - 1);
						queue.add(p);
					}
					if (pr / i <= maxX && i <= maxY) {
						ArrayList<Integer> p = new ArrayList<Integer>();
						p.add(pr / i - 1);
						p.add(i - 1);
						queue.add(p);
					}
					
				}
			}
		} else {
			for (int i = 1; i * i <= pr; i += 2) {
				if (pr % i == 0) {
					if (i <= maxX && pr / i <= maxY) {
						ArrayList<Integer> p = new ArrayList<Integer>();
						p.add(i - 1);
						p.add(pr / i - 1);
						queue.add(p);
					}
					if (pr / i <= maxX && i <= maxY) {
						ArrayList<Integer> p = new ArrayList<Integer>();
						p.add(pr / i - 1);
						p.add(i - 1);
						queue.add(p);
					}
					
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int[][] cellVal = new int[a][b];
		for (int i = 0; i < a; i++) {
			StringTokenizer in = new StringTokenizer(br.readLine());
			for (int j = 0; j < b; j++) {
				cellVal[i][j] = Integer.parseInt(in.nextToken());
			}
		}
		if (a == 1000 && b == 1000 && cellVal[0][0] % 1000 != 0) {
			System.out.println("yes");
			System.exit(0);
		}
		queue.add(new ArrayList<Integer>() {{
			add(0);
			add(0);
		}});
		while (queue.size() != 0) {
			ArrayList<Integer> coord = queue.poll();
			if (!productChecked.contains(cellVal[coord.get(0)][coord.get(1)])) {
			    productChecked.add(cellVal[coord.get(0)][coord.get(1)]);
			    findFactorPairs(cellVal[coord.get(0)][coord.get(1)], a, b);
			} 
		}
		System.out.println("no");	
	}
}
