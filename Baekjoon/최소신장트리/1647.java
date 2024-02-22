package Baekjoon.최소신장트리;
import java.io.*;
import java.util.*;

class P1647 {
    
	static int N,M;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<ArrayList<Node>>();
		
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b,w));
			graph.get(b).add(new Node(a,w));
		}
		
		int k = Prim(1);
		System.out.println(k);
		
	}
	
	public static int Prim(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int ans = 0;
		int max_v = 0;
		visited = new boolean[N+1];
		
		pq.offer(new Node(start,0));
		
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (visited[cur.x]) continue;
			
			visited[cur.x] = true;
			ans += cur.weight;
			max_v = Math.max(max_v, cur.weight);
			
			for (Node next: graph.get(cur.x)) {
				if (!visited[next.x]) {
					pq.offer(new Node(next.x,next.weight));
				}
			}
			
		}

		ans -= max_v;
		return ans;
	}
	
}

class Node implements Comparable<Node>{
	int x;
	int weight;
	public Node(int x, int weight) {
		this.x = x;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}
