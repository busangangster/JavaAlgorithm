package Baekjoon.분할정복;
import java.io.*;


class P1992 {
    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0; i< N; i++){
            String s = br.readLine();
            for (int j=0; j< N; j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        solution(0,0,N);
        System.out.println(sb);
    }

    public static void solution(int x, int y, int size) {

        if (check(x,y,size)) {
            if (arr[x][y] == 0) sb.append(0);
            else sb.append(1);
            return;
        }

        int newSize = size / 2;

        sb.append('(');
        solution(x, y, newSize);
        solution(x, y+newSize, newSize);
        solution(x+newSize, y, newSize);
        solution(x+newSize, y+newSize, newSize);
        sb.append(')');

    }

    public static boolean check(int x, int y, int size) {
        int num = arr[x][y];

        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (arr[i][j] != num) return false;
            }
        }
        return true;
    }
}
