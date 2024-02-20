import java.io.*;
import java.util.*;

public class Main {
	static int N,M,INF,P,Q;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int[] min_dis;
	static int[] house;
	static int[] convience;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		INF = Integer.MAX_VALUE;
		
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b,c));
			graph.get(b).add(new Node(a,c));
		}
		
		st = new StringTokenizer(br.readLine());
		
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		house = new int[P];
		convience = new int[Q];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<P; i++) {
			house[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<Q; i++) {
			convience[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(house);
		
		int[] distance = dijkstra();
		int ans = 0;
		int min_v = Integer.MAX_VALUE;
		int tmp = 0;
		
		for (int i=0; i< house.length; i++) {
			tmp = distance[house[i]];
			if (tmp < min_v) {
				min_v = tmp;
				ans = house[i];
			}
		}
		System.out.println(ans);
	}
	
	public static int[] dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2) -> o1.cost - o2.cost);
		min_dis = new int[N+1];
		for (int i=0; i<=N; i++) {
			min_dis[i] = INF;
		}
		
		for (int i=0; i<Q; i++) {
			pq.offer(new Node(convience[i],0));
		}
		
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
		return min_dis;
	}
}

class Node{
	int node;
	int cost;
	public Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
}
