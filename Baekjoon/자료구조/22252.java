package Baekjoon.자료구조;
import java.util.*;
import java.io.*;

class P22252 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,PriorityQueue<Integer>> map = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		long ans = 0; // 정수형 타입을 long으로 선언. int 선언시 오답 !! cuz 100,000 * 100,000은 int형 범위 넘어섬
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");

			int info = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int k = Integer.parseInt(st.nextToken());

			if (info == 1) { // 쿼리가 1로 시작할 때
				PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙 만들기
				
				for (int j=0;j<k;j++) {
					if (map.containsKey(name)) { // map에 name이 존재하면 
							map.get(name).add(Integer.parseInt(st.nextToken())); // 해당 힙큐에 원소 추가
					} else { // 없으면 힙큐 만들어서, key: name, value: 힙큐 형태로 map에 추가
						p.add(Integer.parseInt(st.nextToken()));
						map.put(name,p);
					}
			}
				
			} else {        // 쿼리가 2일 때
				if (!map.containsKey(name)) {  // name이 map에 없는 경우, continue
					continue;
				} else { // 힙큐가 비어있지 않을 때, k만큼 ans에 정보 가치 + 
					while (!map.get(name).isEmpty() && k >0) {
						ans += map.get(name).poll();
						k --;
					}
				}
			}
		}
		System.out.println(ans);	
	}
}