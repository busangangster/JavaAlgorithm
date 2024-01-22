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
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            for (int j=0;j<k;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                String s = st.nextToken();
                char d = s.charAt(0);
                int v = Integer.parseInt(st.nextToken());

                if (d == 'D') {
                    if (tm.isEmpty()) continue;
                    else {
                        if (v == 1) {
                            int tmp = tm.lastKey(); // tree의 최댓값
                            int cnt = tm.get(tmp);
                            if (cnt == 1) {
                                tm.remove(tmp);
                            } else {
                                tm.put(tmp,cnt-1);
                            }

                        } else {
                            int tmp = tm.firstKey(); // 트리의 최솟값
                            int cnt = tm.get(tmp);
                            if (cnt == 1) {
                                tm.remove(tmp);
                            } else {
                                tm.put(tmp,cnt-1);
                            }

                        }
                    }
                } else{
                    tm.put(v,tm.getOrDefault(v,0)+1);
                }
            }
            if (tm.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(tm.lastKey()+" "+tm.firstKey()).append("\n");
        }
        System.out.println(sb);
    }
}
