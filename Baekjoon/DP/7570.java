package Baekjoon.DP;
import java.io.*;
import java.util.*;

class P7570 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 뽑은 수를 맨 뒤와 앞으로만 이동시킬 수 있기 때문에, 증가하는 부분수열은 연속적이어야 함 !
		// 그게 아니라 아무데나 집어넣을 수 있으면 연속적이지 않아도 됨. 
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N;i++) {
			int k = Integer.parseInt(st.nextToken());
			dp[k] = dp[k-1]+1;
		}

        sb.append(N-Arrays.stream(dp).max().getAsInt());
        System.out.println(sb);
	}
}
