package Baekjoon.최소신장트리;
import java.util.*;
import java.io.*;


class P16398 {
    static int N;
    static int[][] graph; 
    static ArrayList<ArrayList<Edge>> arr;
    static boolean[] visited;
    static long ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        arr = new ArrayList<ArrayList<Edge>>();
        visited = new boolean[N+1];

        for (int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (i == j) continue;
                arr.get(i).add(new Edge(j, graph[i][j]));
                arr.get(j).add(new Edge(i, graph[i][j]));
            }
        }

        prim();
        System.out.println(ans);
     }

     public static void prim() {
        PriorityQueue<Edge> q = new PriorityQueue<Edge>();
        q.offer(new Edge(0, 0));
        ans = 0;
         
        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (visited[cur.end]) continue;

            visited[cur.end] = true;
            ans += cur.cost;

            for (Edge next: arr.get(cur.end)) {
                if (!visited[next.end]) {
                    q.offer(new Edge(next.end, next.cost));
                }
            }   
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
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
    
}
