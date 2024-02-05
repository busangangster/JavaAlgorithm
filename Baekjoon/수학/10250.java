package Baekjoon.수학;
import java.util.*;
import java.io.*;

class P10250 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    
        int t = Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int floor = N%H;
            int ho = N/H+1;

            if (floor == 0) {
                floor = H;
                ho = N/H;
            } 
            
            if (ho < 10) {
                sb.append(floor).append(0).append(ho).append("\n");
            }
            else {
                sb.append(floor).append(ho).append("\n");  
            }
        }
        System.out.println(sb);
    }
}
