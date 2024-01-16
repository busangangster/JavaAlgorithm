package Baekjoon.누적합;
import java.util.*;
import java.io.*;

class P11659 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[n];

		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    int[] dp = new int[n]; // 누적합을 저장하는 배열
    dp[0] = arr[0];

    for (int i=1;i<n;i++) {
      dp[i] = dp[i-1] + arr[i]; // 누적합 저장 
    }

		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			if (k==1) {
        sb.append(dp[t-1]).append("\n");
      } else {
        sb.append(dp[t-1]-dp[k-2]).append("\n");
      }
		}
		System.out.println(sb);	
	}
}

