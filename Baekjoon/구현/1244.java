package Baekjoon.구현;
import java.io.*;
import java.util.*;

class P1244 {
  public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i=0; i<n;i++) {
			arr[i+1] = Integer.parseInt(st.nextToken());
		}
		
		int k = Integer.parseInt(br.readLine());
		for (int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				for (int j=1;j<=n;j++) {
					if (j % num == 0) {
						if (arr[j] == 0) arr[j] = 1;
						else arr[j] = 0;
					}
				}
			}
			else {
				int lt = num;
				int rt = num;
				boolean flag = true;
				
				while (true) {
					lt -= 1;
					rt += 1;
					if (lt < 1 || rt >= n+1) {
						flag = false;
						break;
					}
					
					if (arr[lt] != arr[rt]) {
						flag = false;
						break;
					}
				}
				
				if (flag == false) {
					for (int j=lt+1; j<=rt-1;j++) {
						if (arr[j] == 0) arr[j] = 1;
						else arr[j] = 0;
					}
				}
				else {
					for (int j=lt; j<=rt;j++) {
						if (arr[j] == 0) arr[j] = 1;
						else arr[j] = 0;
					}
				}

			}
		}
		for (int i=1; i<arr.length;i++) {
			sb.append(arr[i]).append(" ");
			if (i%20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
