package Baekjoon.다익스트라;
import java.util.*;
import java.io.*;

class P1753 {
    static int v,e,start;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(); // 정점을 저장할 그래프
    static int[] min_dis; // 최단경로를 저장할 배열

    public static void main(String[] args) throws Exception{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        for (int i=0;i<v+1;i++) {
            graph.add(new ArrayList<>()); // 그래프 초기화
        }
        for (int i=0; i<e;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(new Node(v,w)); // u -> v로 w의 가중치를 가지는 간선 그리기
        }

        dijkstra(start);

        for (int i=1;i<v+1;i++) { // 결과값 출력 
            if (min_dis[i] == INF) sb.append("INF").append("\n");
            else sb.append(min_dis[i]).append("\n");
        }

        System.out.println(sb);
        
    }

    public static void dijkstra(int start) {
        min_dis = new int[v+1];
        for (int i=0;i<v+1;i++) { // 각 정점의 최단거리를 MAX_VALUE값으로 초기화
            min_dis[i] = INF;
        }
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost); // 우선순위 큐 생성

        min_dis[start] = 0; // 출발지점은 가중치가 0임 
        q.offer(new Node(start,0));  // Node 클래스에서 정의한 대로 (정점,가중치) 순으로 큐에 삽입 

        while (!q.isEmpty()) {
            
            Node cur_node = q.poll();

            if (min_dis[cur_node.idx]< cur_node.cost) { // 현재 정점까지의 최단경로가 가중치보다 작을 경우는 갱신 필요 X 
                continue;
            }
            
            for (int i =0; i< graph.get(cur_node.idx).size();i++) { // 해당 정점이랑 간선을 가지는 정점 탐색 
                Node next_node = graph.get(cur_node.idx).get(i);
                if (min_dis[next_node.idx] > cur_node.cost + next_node.cost) { // 최단경로 갱신 
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
