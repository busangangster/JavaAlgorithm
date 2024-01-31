package Baekjoon.브루트포스;
import java.util.*;
import java.io.*;

class P20529 {
    static int bt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int min_v = Integer.MAX_VALUE;
			
			for (int n = 0; n<N;n++) {
				arr[n] =  st.nextToken();
			}
			
			if (N > 32) { // 같은 mbti가 하나라도 3개 이상 있을 시, 답은 무조건 0임 
				sb.append(0).append("\n");
				continue;
			}
		
			else {
				for (int i=0; i<N-2;i++) {
					for (int j=i+1;j<N-1;j++) {
						for (int k=j+1; k<N; k++) {
							bt = 0;
							compare(arr[i],arr[j]);
							compare(arr[j],arr[k]);
							compare(arr[i],arr[k]);
							
							if (bt < min_v) {
								min_v = bt;
							} 
						}		
					}
				}
				sb.append(min_v).append("\n");
			}
		}	
		System.out.println(sb);
	}
	
	public static void compare(String x, String y) {
		for (int i=0; i<4;i++) {
			if (x.charAt(i) != y.charAt(i)) {
				bt += 1;
			}
		}
	}
}
