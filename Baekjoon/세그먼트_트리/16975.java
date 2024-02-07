package Baekjoon.세그먼트_트리;
import java.util.*;
import java.io.*;

class P16975 {
    static long[] arr,tree,lazy;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new long[N+1];
        tree = new long[N*4];
        lazy = new long[N*4];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        init(1, 1, N);

        int M = Integer.parseInt(br.readLine());
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                update(1, 1, N, a, b, c);
            }
            else {
                sb.append(getX(1, 1, N, a, a)).append("\n");
            }
        }
        System.out.println(sb);

    }

    public static long init(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start+end) / 2;
        return tree[node] = init(node*2, start, mid) + init(node*2+1,mid+1,end);
    }

    public static void wait(int node, int start, int end) {
        if (lazy[node] != 0) {
            if (start != end) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            tree[node] += lazy[node] * (end - start + 1);
            lazy[node] = 0;
        }
    }

    public static void update(int node, int start, int end, int left, int right, int value) {

        wait(node, start, end);
        if (left > end || right < start) return;

        if (left <= start && end <= right) {
            wait(node, start, end);
            lazy[node] = value;
            return;
        }

        int mid = (start+end) / 2;
        update(node*2,start,mid,left,right,value);
        update(node*2+1,mid+1,end,left,right,value);
        tree[node] = tree[node*2] + tree[node*2+1];
    }

    public static long getX(int node, int start, int end, int left, int right) {
        wait(node, start, end);

        if (left > end || right < start) return 0;

        if (left <= start && end <= right) return tree[node];

        int mid = (start+end) / 2;
        return getX(node*2, start, mid, left, right) + getX(node*2+1, mid+1, end, left, right);
    }

}
