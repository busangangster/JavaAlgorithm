package Baekjoon.최소신장트리;
import java.util.*;
import java.io.*;

class P21924 {
    static int N,M;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    static int[] check;
    static long total,ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        check = new int[N+1];
        total = 0;

        graph = new ArrayList<ArrayList<Node>>();

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c =  Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
            total += c;
        }
        Prim(1);

        if (Arrays.stream(check).sum() == N) System.out.println(total-ans);
        else System.out.println(-1);

    }

    public static void Prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start,0));

        ans = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.x]) continue;

            visited[cur.x] = true;
            ans += cur.cost;
            check[cur.x] = 1;

            for (Node next: graph.get(cur.x)) {
                if (!visited[next.x]) {
                    pq.offer(new Node(next.x, next.cost));
                }
            }


        }
    }
}

class Node implements Comparable<Node>{
    int x;
    int cost;
    public Node(int x, int cost) {
        this.x = x;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
