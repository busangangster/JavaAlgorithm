package Baekjoon.위상정렬;
import java.io.*;
import java.util.*;

class P2252 {
    static int N,M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] inDegrees;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inDegrees = new int[N+1];

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            inDegrees[b]++;
        }
        tSort();
        System.out.println(sb);
        
    }
    public static void tSort() {
        Queue<Integer> q = new ArrayDeque<Integer>();

        for (int i=1; i<=N; i++) {
            if (inDegrees[i] == 0) {
                inDegrees[i]--;
                sb.append(i).append(" ");
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            ArrayList<Integer> now = graph.get(cur);

            for (int i=0; i<now.size(); i++) {
                inDegrees[now.get(i)]--;
                if (inDegrees[now.get(i)] == 0) {
                    inDegrees[now.get(i)]--;
                    sb.append(now.get(i)).append(" ");
                    q.offer(now.get(i));
                }
            }
        }
    }

}

