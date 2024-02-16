import java.io.*;
import java.util.*;

public class Main {
	static int N,M,K,X,INF;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int[] min_dis;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		INF = Integer.MAX_VALUE;
		min_dis = new int[N+1];
		
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b,1));
		}
		
		dijkstra(X);
		for (int i=1; i<=N; i++) {
			if (min_dis[i] == K) {
				sb.append(i).append("\n");
			}
		}
		if (sb.length() == 0) System.out.println(-1);
		else System.out.println(sb);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2) -> (o1.cost - o2.cost));
		pq.offer(new Node(start,0));
		
		for (int i=0; i<=N; i++) {
			min_dis[i] = INF;
		}
		min_dis[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (min_dis[cur.idx] < cur.cost) continue;
			
			for (int i=0; i< graph.get(cur.idx).size(); i++) {
				Node next = graph.get(cur.idx).get(i);
				
				if (min_dis[next.idx] > cur.cost + next.cost) {
					min_dis[next.idx] = cur.cost + next.cost;
					pq.offer(new Node(next.idx, cur.cost+next.cost));
				}
			}
		}
	}
}

class Node{
	int idx;
	int cost; 
	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Node [idx=" + idx + ", cost=" + cost + "]";
	}
	
}
