import java.util.*;
import java.io.*;

public class prac {
    static int N,M,cnt;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	StringTokenizer st;

	st = new StringTokenizer(br.readLine());

	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());

	graph = new ArrayList<ArrayList<Node>>();
	visited = new boolean[N+1];

    cnt = 0;

	for (int i=0; i<=N; i++) {
		graph.add(new ArrayList<>());
	}

	for (int i=0; i<M; i++) {
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		graph.get(u).add(new Node(v,c));
		graph.get(v).add(new Node(u,c));
        cnt++;
	}

	System.out.println(graph);
	prim(1);
	System.out.println(cnt % 998244353);

    }

public static void prim(int start) {
	PriorityQueue<Node> pq = new PriorityQueue<Node>();
	pq.offer(new Node(start,0));
	// cnt = 0;

	while (!pq.isEmpty()) {

		Node cur = pq.poll();
		System.out.println(cur);

		if (visited[cur.end]) continue;

		visited[cur.end] = true;

		for (Node next: graph.get(cur.end)) {
            System.out.println(next);
			if (!visited[next.end]) {

				pq.offer(new Node(next.end,next.cost));
			    }
		    }
	    }
    }
}

class Node implements Comparable<Node>{
    int end;
    int cost;
    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
	    return this.cost - o.cost;
    }

    @Override
    public String toString() {
    	return "Node [end=" + end + ", cost=" + cost + "]";
    }
}