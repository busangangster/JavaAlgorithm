package Baekjoon.구현;
import java.util.*;
import java.io.*;

class P1453 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            int k = Integer.parseInt(st.nextToken());
            if (arr[k] != 0) cnt++;
            else arr[k] = k;
        }
        sb.append(cnt);
        System.out.println(sb);
    }
}
