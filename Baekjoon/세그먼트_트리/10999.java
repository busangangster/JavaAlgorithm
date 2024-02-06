package Baekjoon.세그먼트_트리;
import java.util.*;
import java.io.*;

class P10999 {
    static long[] tree,lazy,arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[N*4];
        lazy = new long[N*4];

        for (int i=1; i<= N;i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, N);

        for (int i=0; i<M+K;i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                long d = Long.parseLong(st.nextToken());
                update(1, 1, N, b, c, d);
            }
            else {
                if (b<=c) {
                    sb.append(sum(1, 1, N, b, c)).append("\n");
                }
                else {
                    sb.append(sum(1, 1, N, c, b)).append("\n");
                }
            }
        }
        System.out.println(sb);
    }    

    public static long init(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];		
		
		int mid = (start + end) / 2;
		return tree[node] = init(node*2,start,mid) + init(node*2+1,mid+1,end);
    }

    // 느리게 갱신되는 세그먼트 트리 
    public static void wait(int node, int start, int end) {
        if (lazy[node] != 0) { //lazy가 등록되어 있는 경우
            if (start != end) { // 해당 노드가 리프노드가 아닌경우
                lazy[node*2] += lazy[node]; // 자식들에게 lazy를 물려줌
                lazy[node*2+1] += lazy[node];
            }
            tree[node] += lazy[node] *(end-start+1); // 노드 업데이트 = 업데이트 값 * 해당 자식노드의 총 개수
            lazy[node] = 0; // 업데이트 완료 후, 해당 노드 값 삭제 
        }
    }

    public static void update(int node, int start, int end, int left, int right, long value) {

        wait(node,start,end);
        if (left > end || right < start) return;

        if (left <= start && end <= right) {
            lazy[node] = value;
            wait(node, start, end);
            return;
        }

        int mid = (start + end) / 2;
        update(node*2, start, mid, left, right, value);
        update(node*2+1, mid+1, end, left, right, value);
        tree[node] = tree[node*2]+tree[node*2+1];
    }

    public static long sum(int node, int start, int end, int left, int right) {

        wait(node, start, end);
        if (left > end || right < start) return 0;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
    }
}
