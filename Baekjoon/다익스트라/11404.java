package Baekjoon.다익스트라;
import java.io.*;
import java.util.*;

class P11404 {
    static int N,M;
	static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
	static int[] min_dis;
	static int INF  = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for (int i=0;i<=N;i++) {
			arr.add(new ArrayList<>());
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr.get(a).add(new Node(b,c));
		}
		
		for (int i=1; i<=N; i++) {
			int[] k = dijkstra(i);
			for (int j=1;j<=N;j++) {
				if (k[j] == INF) {
					sb.append(0);
				}
				else  sb.append(k[j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static int[] dijkstra(int start) {
		min_dis = new int[N+1];
		for(int i=1;i<=N;i++) {
			min_dis[i] = INF;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2)-> o1.cost-o2.cost);
		pq.offer(new Node(start,0));
		min_dis[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (min_dis[cur.node] < cur.cost) continue;
			
			for (int i=0; i< arr.get(cur.node).size();i++) {
				Node next = arr.get(cur.node).get(i);
				
				if (min_dis[next.node] > cur.cost + next.cost) {
					min_dis[next.node]= cur.cost + next.cost;
					pq.offer(new Node(next.node, cur.cost+next.cost));
				}
			}
			
		}
		return min_dis;
	}
}

class Node {
	int node;
	int cost;
	
	public Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
	
}