package Baekjoon.자료구조;
import java.io.*;
import java.util.*;

class P25325 {
 public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap<>();


    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    for (int i =0; i<n; i++) {
        map.put(st.nextToken(),0);
    }

    for (int i=0; i<n; i++) {
        st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            map.put(t, map.get(t)+1);
        }
    }
    List<String> mapSet = new ArrayList<>(map.keySet());

    mapSet.sort((o1,o2) -> {
        if (map.get(o1) - map.get(o2) == 0) {
            return o1.compareTo(o2);
        } else {
            return map.get(o2) - map.get(o1);
        }
    });

    for(String key : mapSet) {
        System.out.println(key + " " + map.get(key));
    }
 }   
}
