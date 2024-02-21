package Baekjoon.분리집합;
import java.util.*;
import java.io.*;

class P10775 {
    static int G,P;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        int cnt=0;

        makeSet();

        for (int i=0; i<P; i++) {
            int n = Integer.parseInt(br.readLine());
            int gate = find(n);
        
            if (gate == 0) break;

            union(gate,gate-1);
            cnt++;
            System.out.println(Arrays.toString(parent));
        }
        System.out.println(cnt);

    }

    public static void makeSet() {

        parent = new int[G+1];

        for (int i=1; i<=G; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);

    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
}
