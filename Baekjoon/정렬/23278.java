package Baekjoon.정렬;
import java.util.*;
import java.io.*;

class P23278 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        List<Integer> arr = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        for (int i=0;i<N;i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);
        List<Integer> res = arr.subList(L, N-H);

        double sum = 0.0;
        for (Integer v:res) {
            sum += v;
        }
        sb.append(sum/res.size());
        System.out.println(sb);     
    }
}
