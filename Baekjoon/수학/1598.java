package Baekjoon.수학;
import java.io.*;
import java.util.*;

class P1598 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()) -1;
        int b = Integer.parseInt(st.nextToken()) - 1;



        sb.append(Math.abs(a/4  - b/4) + Math.abs(a%4 - b%4));

        System.out.println(sb);
    }
}
