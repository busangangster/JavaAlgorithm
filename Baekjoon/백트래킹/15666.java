package Baekjoon;

import java.util.*;
import java.io.*;

class prac {
   static StringBuilder sb = new StringBuilder();
   static int N, M;
   static int[] ans, input;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      input = new int[N];
      ans = new int[M];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         input[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(input);
      DFS(0, 0);
      System.out.println(sb);
   }

   public static void DFS(int cnt, int start) {
      int same = 0;
      if (cnt == M) {
         for (int x : ans) {
            sb.append(x).append(" ");
         }
         sb.append("\n");
         return;
      }
      for (int i = start; i < N; i++) {
         if (same != input[i]) {
            ans[cnt] = input[i];
            same = input[i];
            DFS(cnt + 1, i);
         }
      }
   }
}
