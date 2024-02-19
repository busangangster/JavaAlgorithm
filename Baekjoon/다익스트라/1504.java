package Baekjoon.다익스트라;
import java.util.*;
import java.io.*;

class P1504 {
    static int N,E,INF;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int[] min_dis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
    
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        min_dis = new int[N+1];
        INF = Integer.MAX_VALUE;

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        
        int[] first = dijkstra(1);
        int[] second = dijkstra(v1);
        int[] third = dijkstra(v2);


        int from_v1_to_v2 = first[v1] + second[v2] + third[N];
        int from_v2_to_v1 = first[v2] + second[v1] + third[N];

        int ans = Math.min(from_v1_to_v2,from_v2_to_v1);
        if (ans == INF) sb.append(-1);
        else sb.append(ans);

        System.out.println(sb);
        
    }    

    public static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2) -> o1.cost - o2.cost);
        for (int i=0; i<=N; i++) {
            min_dis[i] = INF;
        }
        min_dis[start] = 0;
        pq.offer(new Node(start,0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (min_dis[cur.node] < cur.cost) continue;

            for (int i=0; i< graph.get(cur.node).size(); i++) {
                Node next = graph.get(cur.node).get(i);
                if (min_dis[next.node] > cur.cost + next.cost) {
                    min_dis[next.node] = cur.cost + next.cost;
                    pq.offer(new Node(next.node, cur.cost + next.cost));
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
