package Baekjoon.수학;
import java.io.*;
import java.util.*;

class P1267 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int young = 0;
        int min = 0;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int k = Integer.parseInt(st.nextToken());
            if ((k % 29) == 0) young += 10 * (k/30);
            else young += 10 * (k/30 + 1);
            if ((k%59) == 0) min += 15 * (k/60);
            else min += 15 * (k/60 +1);
        }
        if (young < min) sb.append("Y").append(" ").append(young);
        else if (min < young) sb.append("M").append(" ").append(min);
        else sb.append("Y").append(" ").append("M").append(" ").append(min);
        System.out.println(sb);
    }
}
