package Baekjoon.위상정렬;
import java.util.*;
import java.io.*;
class P1005 {
    static StringBuilder sb = new StringBuilder();
    static int N,M,W,sum;
    static ArrayList<ArrayList<Integer>> graph ;
    static int[] inDegree,delay,times;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            inDegree = new int[N+1];
            delay = new int[N+1];
            times = new int[N+1];
            graph = new ArrayList<ArrayList<Integer>>();

            for (int i=0; i<=N; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                inDegree[b]++;
            }

            W = Integer.parseInt(br.readLine());

            int k = tSort(W);
            sb.append(k).append("\n");

        }
        System.out.println(sb);

    }

    public static int tSort(int target) {
        Queue<Integer> q = new ArrayDeque<Integer>();

        for (int i=1; i<=N; i++) {
            if (inDegree[i] == 0) {
                times[i] = delay[i];
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next: graph.get(cur)) {
                times[next] = Math.max(times[next], times[cur]+ delay[next]);
                System.out.println(Arrays.toString(times));
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return times[target];
    }
}
