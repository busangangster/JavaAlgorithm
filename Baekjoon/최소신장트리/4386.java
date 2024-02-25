package Baekjoon.최소신장트리;
import java.util.*;
import java.io.*;

class P4386 {
    static int N;
	static double ans;
	static ArrayList<Node> stars;
	static ArrayList<ArrayList<Edge>> graph;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		stars = new ArrayList<Node>();
		graph = new ArrayList<ArrayList<Edge>>();
		visited = new boolean[N+1];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = i;
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars.add(new Node(idx,x,y));
		}
		
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0;i<N; i++) {
			for (int j = i+1; j<N; j++) {
				double dis = Math.sqrt(Math.pow(Math.abs(stars.get(i).x - stars.get(j).x), 2) 
						+ Math.pow(Math.abs(stars.get(i).y - stars.get(j).y), 2));
				graph.get(i).add(new Edge(j,dis));
				graph.get(j).add(new Edge(i,dis));
			}
		}
	
		Prim(0);
		System.out.printf("%.2f",ans);
	}
	
	public static void Prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.offer(new Edge(start,0));
		ans = 0.0;
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (visited[cur.end]) continue;
			
			visited[cur.end] = true;
			ans += cur.cost;
			
			for (Edge next: graph.get(cur.end)) {
				if (!visited[next.end]) {
					pq.offer(new Edge(next.end,next.cost));
				}
			}
		}
	}
}

class Node{
	int idx;
	double x;
	double y;
	public Node(int idx, double x, double y) {
		this.idx = idx;
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Node [idx=" + idx + ", x=" + x + ", y=" + y + "]";
	}
	
}

class Edge implements Comparable<Edge>{
	int end;
	double cost;
	public Edge(int end, double cost) {
		this.end = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		if (this.cost < o.cost) return -1;
		else return 1;
	}
	
}
