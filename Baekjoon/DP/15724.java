package Baekjoon.DP;
import java.io.*;
import java.util.*;

class P15724 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][m+1];

        for (int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j=1;j<=m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i=0;i<k;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            // 직사각형 내에서 범위 합 구하기 
            int ans = arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1];
            sb.append(ans).append("\n");
        }
        
        System.out.println(sb);
    }
    
}
