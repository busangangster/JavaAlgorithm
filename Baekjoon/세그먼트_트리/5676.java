package Baekjoon.세그먼트_트리;
import java.util.*;
import java.io.*;

class P5676 {
    static long[] arr;
	static long ans;
	static long[] tree;	
		
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String input = ""; // 여러개의 테스트 케이스를 입력받을 때
		while ((input = br.readLine()) != null) { // input이 있을 때만 실행. 
			st = new StringTokenizer(input); // tokenizer 매개변수를 input으로 받음
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr = new long[N+1]; // arr 배열 크기 초기화 
			tree = new long[N*4]; // tree 크기 초기화
			
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=N;i++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i] = (tmp==0)?0:(tmp>0)?1:-1;
			}

			
			init(1,1,N);
			
			for(int i=0; i<K;i++) {
				st = new StringTokenizer(br.readLine());
				
				String cmd = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (cmd.equals("P")) { 
					ans = multi(1,1,N,a,b);
					sb.append((ans==0)? 0: (ans>0)? "+" : "-");
					
				} else if (cmd.equals("C")) { 
//					arr[a] = b; 값을 구하는 게 아니기 때문에, 굳이 update 할 필요 없음 
					b = (b == 0)? 0 : (b>0) ? 1 : -1;
					update(1, 1, N, a, b);
				}
				
			}	
			sb.append("\n");
		}
		System.out.println(sb); // 결과값 출력 
	}
	
	private static long init(int node, int start, int end) { // tree 초기화
		if (start == end) return tree[node] = arr[start];
		
		int mid = (start+end) / 2;
		return tree[node] = init(node*2,start,mid) 
				* init(node*2+1,mid+1,end);
	}
	
	private static long update( int node, int start, int end, int idx, int value) { // tree update
		if (idx <start || idx > end) return tree[node];
		
		if (start == end) return tree[node] = value;
		
		int mid = (start+end) / 2;
		return tree[node] = update(node*2,start,mid,idx,value)
						* update(node*2+1,mid+1,end,idx,value);
	}
	
	private static long multi(int node, int start, int end, int left, int right) { // tree 구간의 곱 구하기 
		if (left > end || right < start) return 1;
		
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start+end) / 2;
		return multi(node*2,start,mid,left,right)
				* multi(node*2+1,mid+1,end,left,right);
	}
}
