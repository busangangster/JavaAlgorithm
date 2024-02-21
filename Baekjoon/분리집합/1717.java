package Baekjoon.분리집합;
import java.util.*;
import java.io.*;

class P1717 {
    static int N,M;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;    

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        makeSet();

        for (int  i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(a,b);
            }
            else {
                String ans = (isSame(a,b) ? "YES" : "NO");
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void makeSet() {
        parent = new int[N+1];

        for (int i=1; i<=N; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        else {
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        }
        else {
            parent[x] = y;
        }
    }

    public static boolean isSame(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return true;
        else return false;
    }
    
}
