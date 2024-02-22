package Baekjoon.최소신장트리;
import java.io.*;
import java.util.*;

class P14621 {
    static int N,M,ans;
	static char[] sex;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph;
	static int[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sex = new char[N+1];
		graph = new ArrayList<ArrayList<Node>>();
		visited = new boolean[N+1];
		check = new int[N+1];
	
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			sex[i] = st.nextToken().charAt(0);
		}
		
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v,d));
			graph.get(v).add(new Node(u,d));
		}
		
		Prim(1);
		
		if (Arrays.stream(check).sum() == N) System.out.println(ans);
		else System.out.println(-1);
	}
	
	public static void Prim(int start) { // 조건 3. 최단경로인지를 Prim으로 계산 
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start,0));
		ans = 0 ;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.x]) continue;
			
			visited[cur.x] = true;
			ans += cur.dis;
			check[cur.x] = 1;  // 조건2. 어떤 대학교에서든 모든 대학교로 이동이 가능한 경로인지 확인 

			for (Node next: graph.get(cur.x)) {
				if (!visited[next.x] && check(cur.x,next.x)) {
					pq.offer(new Node(next.x,next.dis));
				}
			}	
		}
	}
	
	public static boolean check(int x, int y) { // 조건 1. 남초 대학교와 여초 대학교를 연결하는 도로인지 확인 
		if (sex[x] == sex[y]) return false;
		else return true;
	}
}

class Node implements Comparable<Node>{
	int x;
	int dis;
	public Node(int x, int dis) {
		this.x = x;
		this.dis = dis;
	}
	@Override
	public int compareTo(Node o) {
		return this.dis - o.dis;
	}
}
