package Baekjoon.자료구조;
import java.util.*;
import java.io.*;

class P7662 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            int k = Integer.parseInt(br.readLine());
            // 수가 들어갈 때마다 그 수의 개수를 세주면서, 키 값에 따라 오름차순으로 정렬하기 위해 TreeMap를 사용
            TreeMap<Integer, Integer> tm = new TreeMap<>(); 

            for (int j=0;j<k;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                String s = st.nextToken();
                char d = s.charAt(0);
                int v = Integer.parseInt(st.nextToken());

                if (d == 'D') { // 수를 트리에서 빼는 경우
                    if (tm.isEmpty()) continue;
                    else {
                        if (v == 1) {
                            int tmp = tm.lastKey(); // tree의 최댓값
                            int cnt = tm.get(tmp);
                            if (cnt == 1) tm.remove(tmp); // 해당 수의 개수가 한개면, 트리에서 삭제
                            else tm.put(tmp,cnt-1); // 한개 이상이면 갯수 1 감소 
                            
                        } else {
                            int tmp = tm.firstKey(); // 트리의 최솟값
                            int cnt = tm.get(tmp);
                            if (cnt == 1) tm.remove(tmp);
                            else tm.put(tmp,cnt-1);
                        }
                    }
                } else{ // 수를 트리에 집어 넣는경우 
                    tm.put(v,tm.getOrDefault(v,0)+1);
                }
            }
            if (tm.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(tm.lastKey()+" "+tm.firstKey()).append("\n");
        }
        System.out.println(sb);
    }
}
