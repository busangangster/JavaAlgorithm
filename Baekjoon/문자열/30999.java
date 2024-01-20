package Baekjoon.문자열;
import java.util.*;
import java.io.*;

class P30999 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int half = m / 2 + 1;
        int ans = 0;
        
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            int cnt = 0;
            for (int j=0; j<s.length();j++) {
                if (s.charAt(j) == 'O') {
                    cnt ++ ;
                }
            }
            if (cnt >= half) {
                ans++;
            }
        }
        sb.append(ans);
        System.out.println(sb);

        
    }    
}
