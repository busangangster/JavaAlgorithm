package Baekjoon.BFS;
import java.util.*;
import java.io.*;
 
class P16933 {
    static int N,M,K,ans;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
     
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;  
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        ans = Integer.MAX_VALUE;

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        BFS();
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
       
    }

    public static void BFS() {
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        visited = new boolean[N][M][K+1];
        q.offer(new Node(0,0,0,1,true)); // true면 낮, false면 밤. 
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N-1 && cur.y == M-1) {
                ans = cur.cnt;
                return ;
            }

            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny][cur.wall] && graph[nx][ny] == 0) {
                        q.offer(new Node(nx,ny,cur.wall,cur.cnt+1,!cur.flag));
                        visited[nx][ny][cur.wall] = true;
                    }
    
                    else if (cur.wall < K && graph[nx][ny] == 1 && !visited[nx][ny][cur.wall+1]) {
                        if (cur.flag)  {// 낮  
                            q.offer(new Node(nx,ny,cur.wall+1,cur.cnt+1,false)); 
                            visited[nx][ny][cur.wall+1] = true;
                        }
                        else  { // 밤  
                            q.offer(new Node(nx,ny,cur.wall+1,cur.cnt+2,false));
                            visited[nx][ny][cur.wall+1] = true;
                        }
                        
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y){
        return (0 <= x && x < N && 0 <= y && y < M) ;
    }
}

class Node implements Comparable<Node>{
    int x,y,wall,cnt;
    boolean flag;
    public Node(int x, int y, int wall, int cnt, boolean flag) {
        this.x = x;
        this.y = y;
        this.wall = wall;
        this.cnt = cnt;
        this.flag = flag;
    }

    @Override
    public int compareTo(Node o) {
        return this.cnt - o.cnt;
    }   
}