package Baekjoon.분할정복;
import java.io.*;
import java.util.*;

class P2630 {
    static int white = 0;
    static int blue = 0;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0,0,N);

        sb.append(white).append("\n");
        sb.append(blue);
        System.out.println(sb);
    }

    public static void solution(int x, int y, int size) {

        if (check(x,y,size)) {
            if (arr[x][y] == 0) white++;
            else blue++;
            return;
        }
        
        int newSize = size/2;

        solution(x, y, newSize);
        solution(x, y+newSize, newSize);
        solution(x+newSize, y, newSize);
        solution(x+newSize, y+newSize, newSize);
    }

    public static boolean check(int x, int y, int size) {
        
        int color = arr[x][y];

        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (arr[i][j] != color) return false;
            }
        }
        return true;
    }
}
