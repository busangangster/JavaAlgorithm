package Baekjoon.정렬;
import java.util.*;
import java.io.*;

class P26265 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][2];

        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
        
        // 이차원 문자열 배열 정렬을 위해서는 람다식을 활용하여 compare를 재정의 해야함
        Arrays.sort(arr,new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) return o2[1].compareTo(o1[1]);
                else  return o1[0].compareTo(o2[0]);
            }   
        });

        for (String[] m: arr) {
            sb.append(m[0]+" "+m[1]).append("\n");
        }    
        
        System.out.println(sb);
    }
}
