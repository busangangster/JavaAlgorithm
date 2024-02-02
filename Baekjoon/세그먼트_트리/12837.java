package Baekjoon.세그먼트_트리;
import java.util.*;
import java.io.*;

class P12837 {
    static long[] arr,tree;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		tree = new long[N*4];
			
		
		for (int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			long amount = Long.parseLong(st.nextToken());
			
			if (cmd == 1) { // update
				
				arr[day] += (int) amount;
				update(1, 1, N, day,amount);	
				
			}
			else if (cmd == 2) { // print
				sb.append(sum(1, 1, N, day, (int) amount)).append("\n");
			}

		}
		System.out.println(sb);
	}	
	

	public static long update(int node, int start, int end, int idx, long value) {
		if (idx < start || idx > end) return tree[node];

		if (start == end) return tree[node] += value;

		
		int  mid = (start +end) / 2;
		return tree[node] = update(node*2,start,mid,idx,value)+update(node*2+1,mid+1,end,idx,value);
	}
	
	public static long sum(int node, int start, int end, int left, int right) {
		if ( left > end || right < start) return 0;
		
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start+end) / 2;
		return sum(node*2,start,mid,left,right) + sum(node*2+1,mid+1,end,left,right);
	}
}
