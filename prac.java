import java.util.*;
import java.io.*;

public class prac {
    static int N,M,T,ans;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<ArrayList<Edge>>();
        ans = 0;
        visited = new boolean[N+1];

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Edge(B, C));
            graph.get(B).add(new Edge(A, C));
        }

        prim(1);
        System.out.println(ans);

     }

     public static void prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.offer(new Edge(start, 0));
        int idx = 1;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.end]) continue;

            visited[cur.end] = true;
            if (cnt >= 2){
                ans += cur.cost + (T*idx);
                idx++;
            }
            else {
                ans += cur.cost;
            }

            for (Edge next: graph.get(cur.end)) {
                if (!visited[next.end]) {
                    pq.offer(new Edge(next.end, next.cost));
                }    
            }
            cnt++;
        }
     }
}

class Edge implements Comparable<Edge>{
    int end;
    int cost;
    public Edge(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
    
}



