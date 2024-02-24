package Baekjoon.백트래킹;
import java.util.*;
import java.io.*;

class P10819 {
    static int N,ans;
    static int[] input;
    static int[] num;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
  
        st = new StringTokenizer(br.readLine());

        num = new int[N];
        input= new int[N];
        visited = new boolean[N];
        ans = Integer.MIN_VALUE;

        for (int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
        System.out.println(ans);
  
     }

     public static void DFS(int cnt) {
        int tmp = 0;
        if (cnt == N) {
            for (int i=1; i<N; i++) {
                tmp += Math.abs(num[i-1] - num[i]);
            }
            ans = Math.max(ans,tmp);
            return;
        }

        for (int i=0; i<N; i++) {

            if (visited[i]) continue;

            num[cnt] = input[i];
            visited[i] = true;
            DFS(cnt+1);
            visited[i] = false;
        }
     }
}
