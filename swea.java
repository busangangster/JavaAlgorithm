import java.util.*;
import java.io.*;
 
public class swea {
    static int N,M,K,ans;
    static int[][] graph;
    static boolean[][] visited;
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
        visited = new boolean[N][M];
        ans = Integer.MAX_VALUE;

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(Arrays.deepToString(graph));
        BFS();
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
       
    }

    public static void BFS() {
        Queue<Node> q = new ArrayDeque<Node>();
        q.offer(new Node(0,0,0,1));
        visited[0][0] = true;
        boolean flag = true; // true면 낮, false면 밤. 
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur);

            if (cur.x == N-1 && cur.y == M-1) {
                ans = cur.cnt;
                return ;
            }

            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (check(nx,ny) && !visited[nx][ny]) {
                    if (flag) { // 낮일 때 

                        if (graph[nx][ny] == 1) {
                            if (cur.wall < K) {
                                q.offer(new Node(nx,ny,cur.wall+1,cur.cnt+1));
                            }
                            else {
                                continue;
                            }
                        }
                        else{
                            q.offer(new Node(nx,ny,cur.wall,cur.cnt+1));
                        }
                        flag = false;
                        visited[nx][ny] = true;
                    }
                    else { // 밤일 때
                        if (graph[nx][ny] == 1) {
                            if (cur.wall < K) {
                                q.offer(new Node(cur.x,cur.y,cur.wall,cur.cnt+1));
                                visited[cur.x][cur.y] = false;
                            }
                            else {
                                continue;
                            }
                        }
                        else {
                                q.offer(new Node(nx,ny,cur.wall,cur.cnt+1));
                                visited[nx][ny] = true;
                        }
                        flag = true;
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y){
        if (0 <= x && x < N && 0 <= y && y < M) return true;
        else return false;
    }
}

class Node {
    int x,y,wall,cnt;
    public Node(int x, int y, int wall, int cnt) {
        this.x = x;
        this.y = y;
        this.wall = wall;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "Node [x=" + x + ", y=" + y + ", wall=" + wall + ", cnt=" + cnt + "]";
    }
    
}