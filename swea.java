import java.util.*;
import java.io.*;
 
public class swea {
  
    static int N, cell[][], min_v, maxCore;
    static int dx[] = {0,0,-1,1}; 
    static int dy[] = {-1,1,0,0};
    static List<Core> coreList; 
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
             
            cell = new int[N][N];
            coreList = new ArrayList<>();

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    int k = Integer.parseInt(st.nextToken());
                    if(k==1) {
                        cell[i][j] = k;

                        if(i==0 || j==0 || i==N-1 || j==N-1)
                            continue;
                        coreList.add(new Core(i,j));  // 행, 열
                    }
                     
                }
            }
             
            min_v = Integer.MAX_VALUE;
            maxCore = Integer.MIN_VALUE;
             
            DFS(0,0,0);
             
            sb.append("#"+t+" "+min_v+"\n");
        }
         
        System.out.println(sb.toString());
    }
     
    public static void DFS(int idx, int cnt, int wire) {

        if(idx == coreList.size()) {  // 기저조건 
            if(maxCore < cnt) { 
                maxCore = cnt;
                min_v = wire;
            } else if(maxCore == cnt) { 
                min_v = Math.min(wire, min_v);
            }
            return;
        }
         
        int x = coreList.get(idx).x;
        int y = coreList.get(idx).y;
         
        for(int dir=0; dir<4; dir++) {
            int count=0, nx=x, ny=y;
             
            while(true) {
                nx += dx[dir];
                ny += dy[dir];
                 
                if(!check(nx,ny)) { // 범위 벗어나거나
                    break;
                }
                 
                if(cell[ny][nx] == 1) { // 중간에 코어 만날 때
                    count = 0;
                    break;
                }
                 
                count++; // 정상적으로 연결됐을 때 
            }
 
            int fill_x = x;
            int fill_y = y;
             
            for(int i=0; i<count; i++) {
                fill_x += dx[dir];
                fill_y += dy[dir];
                cell[fill_y][fill_x] = 1;
            }
             
            if(count==0)
                DFS(idx+1, cnt, wire);
            else {
                DFS(idx+1, cnt+1, wire+count);
                 
                fill_x = x; // 원래대로 되돌리기
                fill_y = y;
                 
                for(int i=0; i<count; i++) {
                    fill_x += dx[dir];
                    fill_y += dy[dir];
                    cell[fill_y][fill_x] = 0;
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        if (0 <= x && x < N && 0 <=y && y <N)  return true;
        else return false;
    }
}

class Core {
    int x,y;  

    public Core(int y, int x) {
        this.y = y;
        this.x = x;
    }   
}
