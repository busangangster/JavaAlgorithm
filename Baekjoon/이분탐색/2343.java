package Baekjoon.이분탐색;
import java.io.*;
import java.util.*;

class P2343 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i< N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }   
        
    }    

    public static int check(int capa) {
        int cnt=0;

        return cnt;
    }
}
