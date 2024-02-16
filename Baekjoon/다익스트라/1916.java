import java.io.*;
import java.util.*;

public class Main {
	static int N,M,a,b,INF;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int[] min_dis;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		min_dis = new int[N+1];
		INF = Integer.MAX_VALUE;
		
		for (int i=0; i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(s).add(new Node(e,c));
		}
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		dijkstra(a);
		System.out.println(min_dis[b]);
		
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2) -> o1.cost - o2.cost);
		pq.offer(new Node(start,0));
		
		for (int i=0; i<= N; i++) {
			min_dis[i] = INF;
		}
		min_dis[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (min_dis[cur.node] < cur.cost) continue;
			
			for (int i=0; i< graph.get(cur.node).size(); i++) {
				Node next = graph.get(cur.node).get(i);
				
				if (min_dis[next.node] > cur.cost + next.cost) {
					min_dis[next.node]= cur.cost + next.cost; 
					pq.offer(new Node(next.node, cur.cost+next.cost));
				}
			}
    }
	}
}

class Node {
	int node;
	int cost;
	public Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Node [node=" + node + ", cost=" + cost + "]";
	}
}
