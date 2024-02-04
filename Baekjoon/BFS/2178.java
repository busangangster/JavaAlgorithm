package Baekjoon.BFS;
import java.util.*;
import java.io.*;

class P2178 {
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int N,M;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i=0;i< N;i++) {
            String s = br.readLine();
            for (int j=0;j<M;j++) {
                arr[i][j] = s.charAt(j)- '0';
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;
        BFS(0,0);
        sb.append(arr[N-1][M-1]);
        System.out.println(sb);

    }   
    
    public static void BFS(int x, int y) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node (x,y));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i=0; i<4;i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) { // 범위 안에 있으면서
                    if (!visited[nx][ny] && arr[nx][ny] != 0) { // 아직 방문 X, 0이 아닌경우
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[cur.x][cur.y] + 1;
                        q.add(new Node(nx,ny));
                    }
                }
            }
        }
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
