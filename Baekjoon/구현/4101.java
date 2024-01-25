package Baekjoon.구현;
import java.util.*;
import java.io.*;

class P4101 {
     public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b ==0) break;
            else {
                if (a > b) sb.append("Yes").append("\n");
                else sb.append("No").append("\n");
            }
        }
        System.out.println(sb);
     }
}
