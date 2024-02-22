package Baekjoon.최소신장트리;
import java.io.*;
import java.util.*;

class P1922 {
    static int N,M,ans;
	static int[] parent;
	static int[][] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new int[M][3];
		
		makeSet();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());

		}
		
		Arrays.sort(graph, (o1,o2) -> o1[2]-o2[2]);
		
		kruskal();
		System.out.println(ans);

	}
	
	public static void makeSet() {
		
		parent = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			parent[i] = i;
		}
	}
	
	public static int find(int x) {
		if (x == parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x < y) parent[y] =x;
		else parent[x] = y;
	}
	
	public static boolean isSame(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return true;
		else return false;
	}
	
	public static void kruskal() {
		ans = 0;
		
		for (int i=0; i<M; i++) {
			if (!isSame(find(graph[i][0]),find(graph[i][1]))) {
				union(find(graph[i][0]),find(graph[i][1]));
				ans += graph[i][2];
			}
		}
		
	}
}
