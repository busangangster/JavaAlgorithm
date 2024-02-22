package Baekjoon.최소신장트리;
import java.io.*;
import java.util.*;

class P1197 {
    	
	static int V,E;
	static int[] parent;
	static int[][] graph;
	static long ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			makeSet();
			
			graph = new int[E][3]; // 간선 기준으로 그래프를 그려야 함 . E+1로 짜면 음수가 들어왔을 때 순서가 꼬일 수 있음 
			
			for (int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				graph[i][0] = Integer.parseInt(st.nextToken());
				graph[i][1] = Integer.parseInt(st.nextToken());
				graph[i][2] = Integer.parseInt(st.nextToken());
				
			}
			
			Arrays.sort(graph, (o1,o2) -> o1[2] - o2[2]);
			
			kruskal();
		
		System.out.println(ans);
	}
	
	public static void makeSet() {
		parent = new int[V+1];
		
		for (int i=1; i<=V; i++) {
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
		
		if (x < y) parent[y] = x;
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
		int edgeCnt = 0;
		
		for (int i=0; i<E; i++) {
			if (!isSame(find(graph[i][0]),find(graph[i][1]))) {
				union(graph[i][0],graph[i][1]);
				edgeCnt++;
				ans += graph[i][2];
			}
			
			if (edgeCnt == V-1) break;
		}
	}
}
