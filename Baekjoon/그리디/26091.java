package Baekjoon.그리디;
import java.io.*;
import java.util.*;

class P26091 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i=0; i<N;i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr);
				
		int lt = 0;
		int rt = N-1;
		
		while (lt < rt) {
			
			if (arr.get(lt) + arr.get(rt) >= M) {
				cnt += 1;
				rt -= 1;
				lt += 1;
			}
			 else  {
				lt += 1;
			}	
		}
		
		sb.append(cnt);
		System.out.println(sb);
		
	}
}
