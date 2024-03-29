package Baekjoon.정렬;
import java.io.*;
import java.util.*;

class P14400 {
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayList<Integer> x_pos = new ArrayList<>();
        ArrayList<Integer> y_pos = new ArrayList<>();

        int N = Integer.parseInt(br.readLine().trim());
        for (int i=0; i<N;i++) {
            st = new StringTokenizer(br.readLine().trim());
            x_pos.add(Integer.parseInt(st.nextToken()));
            y_pos.add(Integer.parseInt(st.nextToken()));

        }
        Collections.sort(x_pos);
        Collections.sort(y_pos);

        int con_x = x_pos.get(N/2);
        int con_y = y_pos.get(N/2);
        long ans = 0;

        for (int i=0; i<N; i++) {
            ans += Math.abs(con_x - x_pos.get(i)) + Math.abs(con_y - y_pos.get(i)); 
        }
        sb.append(ans);
        System.out.println(sb);
    }
}
