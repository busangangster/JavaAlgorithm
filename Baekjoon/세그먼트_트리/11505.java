package Baekjoon.세그먼트_트리;
import java.io.*;
import java.util.*;

class P11505 {
    static long[] arr;
    static int a,b,c;
    static final int MOD = 1000000007;

    public static class SegmentTree {
        long[] tree;
        int treeSize;

        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            treeSize = (int) Math.pow(2,h+1);
            tree = new long[treeSize];
        }

        public long init(long[] tree, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];

            int mid = (start+end) / 2;
            return tree[node] = init(tree,node*2,start,mid) * init(tree,node*2+1,mid+1,end) % MOD;
        }

        public long update(long[] tree, int node, int start, int end, int idx, int value) {
            if (idx < start || idx > end) {
                return tree[node];
            }
            if (start == end) {
                return tree[node] = value;
            }

            int mid = (start+end) / 2;
            return tree[node] = update(tree,node*2,start,mid,idx,value)* update(tree,node*2+1,mid+1,end,idx,value) % MOD;
        }

        public long multi(long[] tree, int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 1;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            int mid = (start+end)/2;
            return multi(tree, node*2, start, mid, left, right) * multi(tree, node*2+1, mid+1, end, left, right) % MOD;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];

        for (int i=1; i<=N; i++) {
            arr[i] = Long.parseLong(br.readLine()); 
        }

        SegmentTree sgTree = new SegmentTree(N);

        sgTree.init(sgTree.tree, 1, 1, N);

        for (int i=0; i<M+K; i++) {
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == 1){
                arr[b] = c;
                sgTree.update(sgTree.tree, 1, 1, N, b, c);
            }
            else {
                sb.append(sgTree.multi(sgTree.tree, 1, 1, N, b, c)%MOD).append("\n");

            }
        }
        System.out.println(sb);
    }
}
