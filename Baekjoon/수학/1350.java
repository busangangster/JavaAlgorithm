package Baekjoon.수학;
import java.util.*;
import java.io.*;

class P1350 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            if (arr[i] == 0) continue;
            else if (arr[i] <= k) ans += k;
            else {
                if (arr[i] % k == 0) ans += k *(arr[i]/k);
                else ans += k * (arr[i]/k+1);
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }    
}
