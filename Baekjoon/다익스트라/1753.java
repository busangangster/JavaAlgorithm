package Baekjoon.다익스트라;
import java.util.*;
import java.io.*;

class P1753 {
    static int v,e,start;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int[] min_dis;

    public static void main(String[] args) throws Exception{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        for (int i=0;i<v+1;i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<e;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(new Node(v,w));               
        }

        dijkstra(start);
        for (int i=1;i<v+1;i++) {
            if (min_dis[i] == INF) sb.append("INF").append("\n");
            else sb.append(min_dis[i]).append("\n");
        }

        System.out.println(sb);
        
    }

    public static void dijkstra(int start) {
        min_dis = new int[v+1];
        for (int i=0;i<v+1;i++) {
            min_dis[i] = INF;
        }
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        min_dis[start] = 0;
        q.offer(new Node(start,0)); 
        while (!q.isEmpty()) {
            
            Node cur_node = q.poll();

            if (min_dis[cur_node.idx]< cur_node.cost) {
                continue;
            }
            // cur_node.cost+next_node.cost
            for (int i =0; i< graph.get(cur_node.idx).size();i++) {
                Node next_node = graph.get(cur_node.idx).get(i);
                if (min_dis[next_node.idx] > cur_node.cost + next_node.cost) {
                    min_dis[next_node.idx] = cur_node.cost + next_node.cost;
                    q.offer(new Node(next_node.idx,min_dis[next_node.idx]));
                }
            } 
            
        }
    }
}

class Node {
    int idx;
    int cost;
    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}
