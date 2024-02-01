package Baekjoon.세그먼트_트리;
import java.util.*;
import java.io.*;

class P2042 {
    static long[] arr;
    static int a,b;
    static long c;

    public static class SegmentTree {
        long[] tree;
        int treeSize;

        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int) Math.pow(2,h+1);
            tree = new long[treeSize];
        }

        public static long init(long[] tree, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];

            int mid = (start+end) / 2;
            return tree[node] = init(tree,node*2,start,mid) + init(tree,node*2+1,mid+1,end);
        }

        public static void update(long[] tree, int node, int start, int end, int idx, long diff) {
            if (idx < start || idx > end) return;

            tree[node] += diff;

            int mid = (start+end) / 2;
            if (start != end) {
                update(tree,node*2,start,mid,idx,diff);
                update(tree,node*2+1,mid+1,end,idx,diff);
            }
        }

        public static long sum(long[] tree, int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 0;

            if (left <= start && end <= right) {
                return tree[node];
            }

            int mid = (start+end) / 2;
            return sum(tree,node*2,start,mid,left,right) + sum(tree,node*2+1,mid+1,end,left,right);
        }

    }

    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    arr = new long[N+1];

    for (int i=1; i<=N;i++) {
        arr[i] = Long.parseLong(br.readLine());
    }

    SegmentTree sgTree = new SegmentTree(N);

    sgTree.init(sgTree.tree,1,1,N);

    for (int i=0; i< M+k;i++) {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Long.parseLong(st.nextToken());

        if (a == 1) {
             sgTree.update(sgTree.tree,1,1,N,b,c-arr[b]);
             arr[b] = c;
        }
        else {
            // sgTree.sum(sgTree.tree,1,1,N,b,(int) c);
            sb.append(sgTree.sum(sgTree.tree,1,1,N,b,(int) c)).append("\n");
        }
    }
    System.out.println(sb);
}
}
