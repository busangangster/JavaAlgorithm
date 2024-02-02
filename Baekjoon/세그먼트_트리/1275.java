package Baekjoon.세그먼트_트리;
import java.util.*;
import java.io.*;

class P1275 {
    static long[] arr,tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		tree = new long[N*4];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N;i++) { // 배열이 입력으로 들어오기 때문에
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1, 1, N); // 초기화 과정 필요 
		
		for (int i=0; i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if ( x < y) { // x,y 크기에 따라 다름요
				sb.append(sum(1,1,N,x,y)).append("\n");
			}
			else {
				sb.append(sum(1,1,N,y,x)).append("\n");
			}
			update(1, 1, N, a, b - arr[a]);
			arr[a] = b;
		}
		System.out.println(sb);
	}
	
	public static long init(int node, int start, int end) {
		if (start == end) return tree[node] = arr[start];		
		
		int mid = (start + end) / 2;
		return tree[node] = init(node*2,start,mid) + init(node*2+1,mid+1,end);
	}
	
	public static void update(int node, int start, int end, int idx, long diff) {
		if (idx < start || idx > end) return ;
		
		tree[node] += diff;
		
		int mid = (start+end) / 2;
		if (start != end) {
			update(node*2, start, mid, idx, diff);
			update(node*2+1, mid+1, end, idx, diff);
		}
	}
	
	public static long sum(int node, int start, int end, int left, int right) {
		if (left > end || right < start) return 0;
		
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start+end) / 2;
		return sum(node*2, start, mid, left, right) + sum(node*2+1,mid+1,end,left,right);
	}
}
