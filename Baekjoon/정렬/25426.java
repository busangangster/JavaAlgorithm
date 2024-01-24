package Baekjoon.정렬;
import java.util.*;
import java.io.*;

class P25426 {
    public static void main(String[] args)throws Exception {
        // 질문 !!! a와 b의 범위가 10의 9승 즉, 10억까지이며, int의 범위는 약 20억까지인데,
        // 왜 int를 쓰면 안되지 ?? 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Long[][] arr = new Long[n][];

        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            long k = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            Long[] tmp = new Long[2];
            tmp[0] = k;
            tmp[1] = v;
            arr[i] = tmp;
        }

        Arrays.sort(arr,(o1,o2) -> {
            return o1[0].compareTo(o2[0]);
        });

        long ans = 0;
        for (int i=0;i<n;i++) {
            ans += arr[i][0]*(i+1) + arr[i][1];
        }
        sb.append(ans);
        System.out.println(sb);
    }    
}
