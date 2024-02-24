package Baekjoon;

import java.util.*;
import java.io.*;

class prac {
   static int N, M;
   static int[] dx = { -1, 0, 1, 0 };
   static int[] dy = { 0, 1, 0, -1 };
   static int[][] graph;
   static boolean[][] visited;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      graph = new int[N][M];

      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            graph[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      int hour = 1;
      int cur_cheese = check();
      while (true) {
         init();
         melt();
         int k = check();

         if (k == 0) {
            System.out.println(hour);
            System.out.println(cur_cheese);
            break;
         } else {
            hour++;
            cur_cheese = k;
         }
      }

   }

   public static void init() {
      Queue<Node> q = new ArrayDeque<Node>();
      q.offer(new Node(0, 0));
      visited = new boolean[N][M];
      visited[0][0] = true;

      while (!q.isEmpty()) {
         Node cur = q.poll();

         for (int i = 0; i < 4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];

            if (check(nx, ny) && !visited[nx][ny]) {
               if (graph[nx][ny] == 1) {
                  visited[nx][ny] = true;
                  graph[nx][ny] = -1;
               } else {
                  visited[nx][ny] = true;
                  q.offer(new Node(nx, ny));
               }
            }
         }
      }
   }

   public static void melt() {
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            if (graph[i][j] == -1) {
               graph[i][j] = 0;
            }
         }
      }
   }

   public static int check() {
      int cheese = 0;
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            if (graph[i][j] == 1) {
               cheese++;
            }
         }
      }
      return cheese;
   }

   public static boolean check(int x, int y) {
      if (0 <= x && x < N && 0 <= y && y < M)
         return true;
      else
         return false;
   }
}

class Node {
   int x;
   int y;

   public Node(int x, int y) {
      this.x = x;
      this.y = y;
   }
}
