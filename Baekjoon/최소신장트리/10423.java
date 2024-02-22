package Baekjoon.최소신장트리;
import java.util.*;
import java.io.*;

class P10423 {
    static int N,M,K,ans;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<Integer> elec;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());

         elec = new ArrayList<Integer>();
         visited = new boolean[N+1];
         graph = new ArrayList<ArrayList<Node>>();

         for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
         }

         st = new StringTokenizer(br.readLine());
         for (int i=0; i<K; i++) {
            elec.add(Integer.parseInt(st.nextToken())); 
         }

         for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
            graph.get(v).add(new Node(u,w));
         }

         Prim();
         System.out.println(ans);
    
    }

    public static void Prim() {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        ans = 0;

        for (int i=0; i<elec.size(); i++) {
            pq.offer(new Node(elec.get(i),0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.x]) continue;

            visited[cur.x] = true;
            ans += cur.weight;

            for (Node next: graph.get(cur.x)) {
                if (!visited[next.x] && check(next.x)) {
                    pq.offer(new Node(next.x, next.weight));
                }
            }
        }
    }

    public static boolean check(int x) {
        if (elec.contains(x)) return false;
        return true;
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
