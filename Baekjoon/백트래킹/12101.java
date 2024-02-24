package Baekjoon.백트래킹;
import java.util.*;
import java.io.*;

class P12101 {
    static int N, M,count;
    static int[] num,input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        input = new int[3];
        count = 0;

        for (int i=0; i<3; i++) {
            input[i] = i+1;
        }
        
        DFS(0,0);
        
        if (sb.length() == 0) System.out.println(-1);
        else {
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
        }
    }

    public static void DFS(int cnt, int sum) {
        if (sum == N) {
            count++;
            if (count == M) {
                for (int i=0; i<num.length; i++) {
                    if (num[i] != 0) {
                        sb.append(num[i]).append("+");
                    }
                }
            return;
        }
    }
        for (int i=0; i<3; i++) {
            if (sum+input[i] > N) {
                return;
            }
            num[cnt] = input[i];
            DFS(cnt+1,sum + input[i]);
            num[cnt] = 0;
        }
    }
}

