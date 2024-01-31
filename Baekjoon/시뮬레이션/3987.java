package Baekjoon.시뮬레이션;
import java.util.*;
import java.io.*;

class P3987 {

    static int N,M;
    static Character[][] arr;
    static int PR,PC;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[] alpha = {'U','R','D','L'};
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Character[N][M];

        for (int i=0;i<N;i++) {
            String s = br.readLine();
            for (int j=0;j<M;j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine()," ");
        PR = Integer.parseInt(st.nextToken());
        PC = Integer.parseInt(st.nextToken());
        int ans=0;
        int max_v = Integer.MIN_VALUE;
        boolean flag = true;
        for (int i=0;i<4;i++) {
            cnt = 0;
            move(PR-1, PC-1, i);
            if (cnt == 1000000) {
                flag = false;
                ans = i;
                break; 
            }
            else {
                if (cnt > max_v) {
                    max_v = cnt;
                    ans = i;
                }
            }
        }

        if (flag) {
            sb.append(alpha[ans]).append("\n").append(max_v);
 
        } else {
            sb.append(alpha[ans]).append("\n").append("Voyager");
        }
        System.out.println(sb);
        
    }

    private static void move(int x, int y, int d) {
        int nx = x;
        int ny = y;
        
        while (true) {
            nx =  nx + dx[d];
            ny =  ny + dy[d];
            
            cnt++;
            if (nx >= N || nx < 0 || ny < 0 || ny >= M ) break;
            if (arr[nx][ny] == 'C')  break;
            if (cnt == 1000000) break;

            if (arr[nx][ny] == '.') continue;
            
            else {
                if (d == 0) { // 위로 갈 때
                    if (arr[nx][ny] == '/') {
                        d = 1;
                    } else if (arr[nx][ny] == '\\') {
                        d = 3;
                    }
                } else if (d == 1) { // 오른쪽으로 갈 때
                    if (arr[nx][ny] == '/') {
                        d = 0;
                    } else if (arr[nx][ny] == '\\') {
                        d = 2;
                    }
                } else if (d == 2) { // 밑에서 올 때
                    if (arr[nx][ny] == '/') {
                        d = 3;
                    } else if (arr[nx][ny] == '\\') {
                        d = 1;
                    }
                } else if (d == 3) { // 왼쪽에서 올 때
                    if (arr[nx][ny] == '/') {
                        d = 2;
                    } else if (arr[nx][ny] == '\\') {
                        d = 0;
                    }
                }
            }
        }
    }    
}
