package Baekjoon.DP;
import java.io.*;

class P11727 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		if (N < 3) {
			System.out.println(dp[N]);
		} else {
			for (int i=3; i<=N;i++) {
				dp[i] = (dp[i-1] + 2* dp[i-2]) % 10007;
			}
			System.out.println(dp[N]);
        }	
	}
}
