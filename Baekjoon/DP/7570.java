package Baekjoon.DP;
import java.io.*;
import java.util.*;

class P7570 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[N+1];
        for (int i=0; i< N; i++) {
            int k = Integer.parseInt(st.nextToken());
            dp[k] = Math.max(dp[k],dp[k-1]+1);
        }
        System.out.println(Arrays.toString(dp));

        sb.append(N-Arrays.stream(dp).max().getAsInt());
        System.out.println(sb);
    }
}
