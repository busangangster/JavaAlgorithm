package Baekjoon.세그먼트_트리;
import java.util.*;
import java.io.*;

class P11143 {
    static long[] arr, tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i=0;i<t;i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            arr = new long[B+1];
            tree = new long[B*4];

            for (int j=0; j<P+Q;j++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (cmd.equals("P")) {
                    update(1, 1, B, a, b);
                    arr[a] = b;
                } else if (cmd.equals("Q")) {
                    sb.append(sum(1, 1, B, a, b)).append("\n");
                }
            }
    
        }
        System.out.println(sb);
    }

    public static void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) return;

        tree[node] += diff;

        int mid = (start+end)/2;
        if (start != end) {
            update(node*2, start, mid, idx, diff);
            update(node*2+1,mid+1,end,idx,diff);
        }
    }

    public static long sum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;

        if (left <= start && end <= right) return tree[node];

        int mid = (start+end) / 2;
        return sum(node*2,start,mid,left,right) + sum(node*2+1,mid+1,end,left,right);
    }
    
}
